package com.expense.calc.repository;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.expense.calc.builder.MemberTestBuilder;
import com.expense.calc.model.Member;

public class MemberRepositoryIntegrationTest extends AbstractRepositoryIntegrationTest{

	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	public void persistMemberTest() {
		Member member = MemberTestBuilder.aMember().build();
		memberRepository.persist(member);
		assertThat(member.getId()).isNotNull();
	}
	
	@Test 
	public void loadMemberTest() {
		Member member = MemberTestBuilder.aMember().buildAndPersist();
		
		Member loadedMember = memberRepository.load(member.getId());
		assertThat(loadedMember).isEqualTo(member);
	}
	
	@Test
	public void deleteMemberTest() {
		Member member = MemberTestBuilder.aMember().buildAndPersist();
		
		memberRepository.delete(member);
		Member byId = memberRepository.getById(member.getId());
		assertThat(byId).isNull();
	}
}
