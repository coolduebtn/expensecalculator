package com.expense.calc.repository;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.expense.calc.builder.UserTestBuilder;
import com.expense.calc.model.User;

public class UserRepositoryIntegrationTest extends AbstractRepositoryIntegrationTest{

	@Autowired
	private UserRepository memberRepository;
	
	@Test
	public void persistMemberTest() {
		User member = UserTestBuilder.aUser().build();
		memberRepository.persist(member);
		assertThat(member.getId()).isNotNull();
	}
	
	@Test 
	public void loadMemberTest() {
		User member = UserTestBuilder.aUser().buildAndPersist();
		
		User loadedMember = memberRepository.load(member.getId());
		assertThat(loadedMember).isEqualTo(member);
	}
	
	@Test
	public void deleteMemberTest() {
		User member = UserTestBuilder.aUser().buildAndPersist();
		
		memberRepository.delete(member);
		User byId = memberRepository.getById(member.getId());
		assertThat(byId).isNull();
	}
	
	@Test
	public void loadUserByUsername() {
		User member = UserTestBuilder.aUser().withUsername("chandan").buildAndPersist();
		
		User fromDbUser = memberRepository.loadUserByUsername("chandan");
		assertThat(fromDbUser).isEqualTo(member);
		
		User fromDbUser2 = memberRepository.loadUserByUsername("chandu");
		assertThat(fromDbUser2).isNull();
	}
}
