package com.expense.calc.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.google.common.collect.Sets;

@Entity
public class Expenditure implements BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String place;

	@ManyToOne
	private User creator;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Expenditure_Member", joinColumns = { @JoinColumn(name = "expenditure_id") }, inverseJoinColumns = { @JoinColumn(name = "member_id") })
	private Set<User> members = Sets.newHashSet();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "expenditure_id", nullable = false)
	private Set<Expense> expenses = Sets.newHashSet();

	@Override
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Set<User> getMembers() {
		return members;
	}

	public void setMembers(Set<User> members) {
		this.members = members;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public void addMember(User member) {
		this.members.add(member);
	}

	public void deleteMember(User member) {
		this.members.remove(member);
	}

	public Set<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(Set<Expense> expenses) {
		this.expenses = expenses;
	}

	public void addExpense(Expense expense) {
		this.expenses.add(expense);
	}

	public void deleteExpense(Expense expense) {
		this.expenses.remove(expense);

	}

}
