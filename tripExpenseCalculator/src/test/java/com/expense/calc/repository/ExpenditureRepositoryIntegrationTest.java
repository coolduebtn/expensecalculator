package com.expense.calc.repository;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.expense.calc.builder.ExpenditureTestBuilder;
import com.expense.calc.builder.ExpenseTestBuilder;
import com.expense.calc.builder.UserTestBuilder;
import com.expense.calc.model.Expenditure;
import com.expense.calc.model.Expense;
import com.expense.calc.model.User;
import com.google.common.collect.Sets;

public class ExpenditureRepositoryIntegrationTest extends
		AbstractRepositoryIntegrationTest {
	
	@Autowired
	private ExpenditureRepository expenditureRepository;
	private User user1;
	private User user2;
	
	@Before
	public void init() {
		user1 = createMember("cooldude@gmail.com","chandu");
		user2 = createMember("chandan.agarwal@aubay.be","aubay");
	}
	
	@Test
	public void persistExpenditureTest() {
		
		Set<User> members=Sets.newHashSet(user1,user2);
		Expenditure expenditure = ExpenditureTestBuilder.anExpenditure().withMembers(members).build();
		expenditureRepository.persist(expenditure);
		assertThat(expenditure.getId()).isNotNull();
		assertThat(expenditure.getMembers().size()).isEqualTo(2);
	}
	
	@Test
	public void loadExpenditureTest() {
		Expenditure expenditure = ExpenditureTestBuilder.anExpenditure().buildAndPersist();
		
		Expenditure loadedExp = expenditureRepository.load(expenditure.getId());
		assertThat(expenditure).isEqualTo(loadedExp);
	}
	
	@Test
	public void deleteExpenditureTest() {
		Expenditure expenditure = ExpenditureTestBuilder.anExpenditure().buildAndPersist();
		expenditureRepository.delete(expenditure);
		assertThat(expenditureRepository.getById(expenditure.getId())).isNull();
	}
	
	@Test
	public void addMember() {
		Expenditure expenditure = ExpenditureTestBuilder.anExpenditure().buildAndPersist();
		expenditure.addMember(user1);
		
		Expenditure expenditureFromDb = expenditureRepository.getById(expenditure.getId());
		assertThat(expenditureFromDb.getMembers()).containsOnly(user1);
	}
	
	@Test
	public void removeMember() {
		Expenditure expenditure = ExpenditureTestBuilder.anExpenditure().buildAndPersist();
		expenditure.addMember(user1);
		
		expenditure.addMember(user2);
		
		Long id = expenditure.getId();
		Expenditure expenditureFromDb = expenditureRepository.getById(id);
		assertThat(expenditureFromDb.getMembers()).containsOnly(user1,user2);
		
		expenditureFromDb.deleteMember(user1);
		Expenditure expenditureFromDb1 = expenditureRepository.getById(id);
		assertThat(expenditureFromDb1.getMembers()).containsOnly(user2);
		
	}
	
	@Test
	public void addExpenseTest() {
		Expenditure expenditure = ExpenditureTestBuilder.anExpenditure().buildAndPersist();
		Expense expense1 = ExpenseTestBuilder.anExpense().withSpender(user1)
				.build();
		expenditure.addExpense(expense1);
		
		
		Expenditure expenditureFromDb = expenditureRepository.getById(expenditure.getId());
		assertThat(expenditureFromDb.getExpenses()).containsOnly(expense1);
	}
	
	@Test
	public void removeExpenseTest() {
		Expenditure expenditure = ExpenditureTestBuilder.anExpenditure().buildAndPersist();
		Expense expense1 = ExpenseTestBuilder.anExpense().withSpender(user1)
				.build();
		expenditure.addExpense(expense1);
		
		Expense expense2 = ExpenseTestBuilder.anExpense().withSpender(user1)
				.build();
		expenditure.addExpense(expense2);
		Expenditure expenditureFromDb = expenditureRepository.getById(expenditure.getId());
		assertThat(expenditureFromDb.getExpenses()).containsOnly(expense1,expense2);
		
		expenditure.deleteExpense(expense1);
		Expenditure expenditureFromDb2 = expenditureRepository.getById(expenditure.getId());
		assertThat(expenditureFromDb2.getExpenses()).containsOnly(expense2);
		
	}

	
	private User createMember(String email,String userName) {
		return UserTestBuilder.aUser().withEmail(email).withUsername(userName).buildAndPersist();
	}

}
