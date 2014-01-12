package com.expense.calc.repository;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.expense.calc.builder.ExpenditureTestBuilder;
import com.expense.calc.builder.ExpenseTestBuilder;
import com.expense.calc.builder.UserTestBuilder;
import com.expense.calc.model.Expenditure;
import com.expense.calc.model.Expense;
import com.expense.calc.model.User;

public class ExpenseRepositoryIntegrationTest extends
		AbstractRepositoryIntegrationTest {

	private User spender;
	private Expenditure expenditure;
	
	@Autowired
	private ExpenseRepository expenseRepository;
	

	@Before
	public void init() {
		expenditure=ExpenditureTestBuilder.anExpenditure().buildAndPersist();
		spender = UserTestBuilder.aUser().withName("chandan").withUsername("chandu").withEmail("chandan@gmail.com")
				.buildAndPersist();
	}

	
	@Test
	public void loadExpenseTest() {
		Expense expense = ExpenseTestBuilder.anExpense().withSpender(spender)
				.build();
		expenditure.addExpense(expense);
		expenseRepository.flush();
		
		assertThat(expense.getId()).isNotNull();
		Expense load = expenseRepository.load(expense.getId());
		assertThat(load).isEqualTo(expense);
	}
	

}
