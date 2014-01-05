package com.expense.calc.builder;

import java.util.Date;

import com.expense.calc.model.Expense;
import com.expense.calc.model.Member;

public class ExpenseTestBuilder extends AbstractTestBuilder<Expense> {
	

	private static final String DESCRIPTION = "lunch at macD";
	private String description=DESCRIPTION;
	private Double amount=100D;
	private Member spender=null;
	private Date date=new Date();

	public static ExpenseTestBuilder anExpense() {
		return new ExpenseTestBuilder();
	}
	
	public ExpenseTestBuilder withDescription(String description) {
		this.description=description;
		return this;
	}
	
	public ExpenseTestBuilder withAmount(Double amount) {
		this.amount=amount;
		return this;
	}
	
	public ExpenseTestBuilder withSpender(Member spender) {
		this.spender=spender;
		return this;
	}
	
	public ExpenseTestBuilder withDate(Date date) {
		this.date=date;
		return this;
	}
	
	@Override
	public Expense build() {
		Expense expense=new Expense();
		expense.setDescription(description);
		expense.setExpenseDate(date);
		expense.setAmount(amount);
		expense.setSpender(spender);
		return expense;
	}

}
