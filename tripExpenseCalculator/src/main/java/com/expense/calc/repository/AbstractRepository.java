package com.expense.calc.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public AbstractRepository() {
		super();
	}

	protected Session session() {
		return sessionFactory.getCurrentSession();
	}

	protected List getAll(Class persistentClass) {
		return session().createCriteria(persistentClass).setCacheable(true).list();
	}

}