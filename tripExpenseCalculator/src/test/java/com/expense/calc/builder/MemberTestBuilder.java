package com.expense.calc.builder;

import com.expense.calc.model.Member;

public class MemberTestBuilder extends AbstractTestBuilder<Member> {

	
	private static final String NAME="chandan agarwal";
	private String name=NAME;
	
	private static final String EMAIL="cooldudebtn@gmail.com";
	private String email=EMAIL;
	
	public static MemberTestBuilder aMember(){
		return new MemberTestBuilder();
	}

	
	public MemberTestBuilder withName(String name){
		this.name=name;
		return this;
	}
	
	public MemberTestBuilder withEmail(String email){
		this.email=email;
		return this;
	}
	@Override
	public Member build() {
		Member member =new Member();
		member.setName(this.name);
		member.setEmailId(this.email);
		return member;
	}

}
