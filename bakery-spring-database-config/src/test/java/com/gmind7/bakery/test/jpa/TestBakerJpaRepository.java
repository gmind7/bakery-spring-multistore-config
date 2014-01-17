package com.gmind7.bakery.test.jpa;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.gmind7.bakery.config.AbstractApplicationTest;

public class TestBakerJpaRepository extends AbstractApplicationTest {
	
	@Autowired
	private BakerJpaRepository repository;
	
	private Baker baker;
	
	@Before
	public void initBaker(){
		Baker source = new Baker(1L);
		source.setUsername("daesungkim");
		source.setFirstname("kim");
		source.setLastname("daesung");
		this.baker = repository.save(source);
	}
	
	@Test
	public void findOne(){
		Baker result = repository.findOne(1L);
		assertEquals(baker, result);
	}
	
	@Test
	public void QFindByBaker(){
		Page<Baker> result = repository.QFindByBaker(new PageRequest(0, 5));
		assertNotNull(result);
	}
}
