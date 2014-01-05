package com.expense.calc.repository;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.expense.calc.builder.ExpenditureTestBuilder;
import com.expense.calc.builder.MemberTestBuilder;
import com.expense.calc.model.Expenditure;
import com.expense.calc.model.Member;
import com.google.common.collect.Sets;

public class ExpenditureRepositoryIntegrationTest extends
		AbstractRepositoryIntegrationTest {
	
	@Autowired
	private ExpenditureRepository expenditureRepository;
	
	@Test
	public void persistExpenditureTest() {
		Set<Member> members=Sets.newHashSet(createMember("cooldudebtn@gmail.com"),createMember("chandan.agarwal@aubay.be"));
		Expenditure expenditure = ExpenditureTestBuilder.anExpenditure().withMembers(members).build();
		expenditureRepository.persist(expenditure);
		assertThat(expenditure.getId()).isNotNull();
		assertThat(expenditure.getMembers().size()).isEqualTo(2);
	}
	
	@Test
	public void loadExpenditureTest() {
		Expenditure expenditure = ExpenditureTestBuilder.anExpenditure().buildAndPersist();
		
		Expenditure loadedExp = expenditureRepository.load(expenditure.getId());
		assertThat(expenditure).isEqualTo(loadedExp);
	}
	
	@Test
	public void deleteExpenditureTest() {
		Expenditure expenditure = ExpenditureTestBuilder.anExpenditure().buildAndPersist();
		expenditureRepository.delete(expenditure);
		assertThat(expenditureRepository.getById(expenditure.getId())).isNull();
	}
	
	@Test
	public void addMember() {
		Expenditure expenditure = ExpenditureTestBuilder.anExpenditure().buildAndPersist();
		Member member1 = createMember("cooldudebtn@gmail.com");
		expenditure.addMember(member1);
		
		Expenditure expenditureFromDb = expenditureRepository.getById(expenditure.getId());
		assertThat(expenditureFromDb.getMembers()).containsOnly(member1);
	}
	
	@Test
	public void removeMember() {
		Expenditure expenditure = ExpenditureTestBuilder.anExpenditure().buildAndPersist();
		Member member1 = createMember("cooldudebtn@gmail.com");
		expenditure.addMember(member1);
		
		Member member2 = createMember("cooldude@gmail.com");
		expenditure.addMember(member2);
		
		Long id = expenditure.getId();
		Expenditure expenditureFromDb = expenditureRepository.getById(id);
		assertThat(expenditureFromDb.getMembers()).containsOnly(member1,member2);
		
		expenditureFromDb.deleteMember(member1);
		Expenditure expenditureFromDb1 = expenditureRepository.getById(id);
		assertThat(expenditureFromDb1.getMembers()).containsOnly(member2);
		
	}
	
	private Member createMember(String email) {
		return MemberTestBuilder.aMember().withEmail(email).build();
	}

}
