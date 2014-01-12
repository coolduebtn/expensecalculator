package com.expense.calc.repository;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.expense.calc.model.User;

@Repository
public class UserRepository extends BaseEntityRepository<User> {

	@Override
	public Class<User> getPersistentClass() {
		return User.class;
	}
	
	public User loadUserByUsername(String username) {
		return (User) createCriteria().add(Restrictions.eq("username", username)).uniqueResult();
	}

}
