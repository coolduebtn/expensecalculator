package com.expense.calc.repository;

import org.springframework.stereotype.Repository;

import com.expense.calc.model.Expense;

@Repository
public class ExpenseRepository extends BaseEntityRepository<Expense> {

	@Override
	public Class<Expense> getPersistentClass() {
		return Expense.class;
	}

}
