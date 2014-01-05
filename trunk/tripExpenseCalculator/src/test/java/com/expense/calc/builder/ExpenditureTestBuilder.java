package com.expense.calc.builder;

import static com.google.gwt.thirdparty.guava.common.collect.Sets.newHashSet;

import java.util.Set;

import com.expense.calc.model.Expenditure;
import com.expense.calc.model.Member;
import com.google.gwt.thirdparty.guava.common.collect.Sets;

public class ExpenditureTestBuilder extends AbstractTestBuilder<Expenditure> {

	private static String NAME="Trip to Budapest";
	private String name=NAME;
	
	private static String PLACE="Budapest";
	private String place=PLACE;
	
	private Set<Member> members=Sets.newHashSet();
	
	public static ExpenditureTestBuilder anExpenditure() {
		return new ExpenditureTestBuilder();
	}
	
	public ExpenditureTestBuilder withName(String name) {
		this.name=name;
		return this;
	}

	public ExpenditureTestBuilder withExpenditure(String place) {
		this.place=place;
		return this;
	}
	
	public ExpenditureTestBuilder withMembers(Member... members) {
		this.members.addAll(newHashSet(members));
		return this;
	}
	
	public ExpenditureTestBuilder withMembers(Set<Member> members) {
		this.members=members;
		return this;
	}
	@Override
	public Expenditure build() {
		Expenditure expenditure=new Expenditure();
		expenditure.setName(this.name);
		expenditure.setPlace(this.place);
		expenditure.setMembers(this.members);
		return expenditure;
	}

}
