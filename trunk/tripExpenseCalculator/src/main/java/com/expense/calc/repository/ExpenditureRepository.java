package com.expense.calc.repository;

import org.springframework.stereotype.Repository;

import com.expense.calc.model.Expenditure;

@Repository
public class ExpenditureRepository extends BaseEntityRepository<Expenditure>{

	@Override
	public Class<Expenditure> getPersistentClass() {
		return Expenditure.class;
	}

}
