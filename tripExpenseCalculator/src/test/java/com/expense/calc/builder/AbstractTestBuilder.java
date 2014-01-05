package com.expense.calc.builder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.mockito.MockitoAnnotations;

import com.expense.calc.ApplicationContextHolder;


public abstract class AbstractTestBuilder<T> {

	public AbstractTestBuilder() {
		MockitoAnnotations.initMocks(this);
	}

	abstract public T build();

	public T buildAndPersist() {
		T toBePersisted = build();
		getSession().persist(toBePersisted);
		getSession().flush();
		return toBePersisted;
	}

	protected Session getSession() {
		return ApplicationContextHolder.getContext().getBean(SessionFactory.class).getCurrentSession();
	}
}
