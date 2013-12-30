package com.gmind7.bakery.config;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gmind7.bakery.common.AbstractApplicationTest;
import com.gmind7.bakery.test.Baker;
import com.gmind7.bakery.test.BakerJpaRepository;

public class TestDataSourceConfig extends AbstractApplicationTest {
	
	@Autowired
	private BakerJpaRepository repository;
	
	private Baker baker;
	
	@Before
	public void initBaker(){
		Baker source = new Baker(1L);
		source.setUsername("daesungkim");
		source.setFirstname("kim");
		source.setLastname("daesung");
		this.baker = repository.save(new Baker(1L));
	}
	
	@Test
	public void test(){
		Baker result = repository.findOne(1L);
		assertEquals(baker, result);
	}
}
