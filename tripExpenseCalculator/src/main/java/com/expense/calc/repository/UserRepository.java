package com.expense.calc.repository;

import org.springframework.stereotype.Repository;

import com.expense.calc.model.User;

@Repository
public class UserRepository extends BaseEntityRepository<User> {

	@Override
	public Class<User> getPersistentClass() {
		return User.class;
	}

}
