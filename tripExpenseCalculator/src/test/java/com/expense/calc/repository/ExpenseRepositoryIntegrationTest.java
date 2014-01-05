package com.expense.calc.repository;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.expense.calc.builder.ExpenseTestBuilder;
import com.expense.calc.builder.MemberTestBuilder;
import com.expense.calc.model.Expense;
import com.expense.calc.model.Member;

public class ExpenseRepositoryIntegrationTest extends
		AbstractRepositoryIntegrationTest {

	private Member spender;
	
	@Autowired
	private ExpenseRepository expenseRepository;

	@Before
	public void init() {
		spender = MemberTestBuilder.aMember().withName("chandan")
				.buildAndPersist();
	}

	@Test
	public void persistExpenseTest() {
		Expense expense = ExpenseTestBuilder.anExpense().withSpender(spender)
				.build();
		expenseRepository.persist(expense);
		assertThat(expense.getId()).isNotNull();
	}
	
	@Test
	public void loadExpenseTest() {
		Expense expense = ExpenseTestBuilder.anExpense().withSpender(spender).buildAndPersist();
		
		Expense load = expenseRepository.load(expense.getId());
		assertThat(load).isEqualTo(expense);
	}
	
	@Test
	public void deleteExpenseTest() {
		Expense expense = ExpenseTestBuilder.anExpense().withSpender(spender).buildAndPersist();
		expenseRepository.delete(expense);
		
		Expense byId = expenseRepository.getById(expense.getId());
		assertThat(byId).isNull();
	}

}
