package com.expense.calc.repository;

import org.springframework.stereotype.Repository;

import com.expense.calc.model.Member;

@Repository
public class MemberRepository extends BaseEntityRepository<Member> {

	@Override
	public Class<Member> getPersistentClass() {
		return Member.class;
	}

}
