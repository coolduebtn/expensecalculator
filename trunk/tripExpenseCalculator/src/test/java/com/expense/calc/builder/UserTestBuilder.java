package com.expense.calc.builder;

import com.expense.calc.model.User;

public class UserTestBuilder extends AbstractTestBuilder<User> {

	
	private static final String NAME="chandan agarwal";
	private String name=NAME;
	
	private static final String EMAIL="cooldudebtn@gmail.com";
	private String email=EMAIL;
	private String username="cooldudebtn";
	private String password="password";
	
	public static UserTestBuilder aUser(){
		return new UserTestBuilder();
	}

	public UserTestBuilder withUsername(String username){
		this.username=username;
		return this;
	}
	
	public UserTestBuilder withPassword(String password){
		this.password=password;
		return this;
	}
	
	public UserTestBuilder withName(String name){
		this.name=name;
		return this;
	}
	
	public UserTestBuilder withEmail(String email){
		this.email=email;
		return this;
	}
	@Override
	public User build() {
		User user =new User();
		user.setName(this.name);
		user.setEmailId(this.email);
		user.setUsername(username);
		user.setPassword(password);
		return user;
	}

}
