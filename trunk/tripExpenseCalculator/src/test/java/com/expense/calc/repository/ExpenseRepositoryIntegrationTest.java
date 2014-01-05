package com.expense.calc.repository;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.expense.calc.builder.ExpenditureTestBuilder;
import com.expense.calc.builder.ExpenseTestBuilder;
import com.expense.calc.builder.MemberTestBuilder;
import com.expense.calc.model.Expenditure;
import com.expense.calc.model.Expense;
import com.expense.calc.model.Member;

public class ExpenseRepositoryIntegrationTest extends
		AbstractRepositoryIntegrationTest {

	private Member spender;
	private Expenditure expenditure;
	
	@Autowired
	private ExpenseRepository expenseRepository;
	

	@Before
	public void init() {
		expenditure=ExpenditureTestBuilder.anExpenditure().buildAndPersist();
		spender = MemberTestBuilder.aMember().withName("chandan")
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
