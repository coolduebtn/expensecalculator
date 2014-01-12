package com.expense.calc.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Expense implements BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String description;
	
	private Double amount;
	
	@Temporal(TemporalType.DATE)
	private Date expenseDate;
	
	@ManyToOne
	private User spender;

	@Override
	public Long getId() {
		return this.id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public User getSpender() {
		return spender;
	}

	public void setSpender(User spender) {
		this.spender = spender;
	}
	
	public Date getExpenseDate() {
		return expenseDate;
	}
	
	public void setExpenseDate(Date date) {
		this.expenseDate = date;
	}

}
