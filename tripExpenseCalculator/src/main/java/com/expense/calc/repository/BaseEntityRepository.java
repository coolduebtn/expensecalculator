package com.expense.calc.repository;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.expense.calc.model.BaseEntity;

public abstract class BaseEntityRepository<E extends BaseEntity> extends AbstractRepository {

	public Long persist(Object entity) {
		return (Long) session().save(entity);
	}

	@SuppressWarnings("unchecked")
	public E load(Long id) {
		return (E) session().load(getPersistentClass(), id);
	}

	@SuppressWarnings("unchecked")
	public E getById(Long id) {
		return (E) session().get(getPersistentClass(), id);
	}

	public List<E> getByIds(Long... ids) {
		return (List<E>) createCriteria().add(Restrictions.in("id",ids)).list();
	}

	public List<E> getByIds(Collection<Long> ids) {
		return (List<E>) createCriteria().add(Restrictions.in("id",ids)).list();
	}

	public abstract Class<E> getPersistentClass();

	public void delete(E entity) {
		session().delete(entity);
	}

	public void flush() {
		session().flush();
	}

	public void clearSession() {
		session().clear();
	}

	@SuppressWarnings("unchecked")
	public List<E> getAll() {
		return (List<E>) getAll(getPersistentClass());
	}

	public void deleteAll() {
		List<E> all = this.getAll();
		for (E entity : all) {
			session().delete(entity);
		}
	}

	public E merge(E entity) {
		return (E) session().merge(entity);
	}

	public void saveOrUpdate(E entity) {
		session().saveOrUpdate(entity);
	}

	protected Criteria createCriteria() {
		return session().createCriteria(getPersistentClass());
	}

}
