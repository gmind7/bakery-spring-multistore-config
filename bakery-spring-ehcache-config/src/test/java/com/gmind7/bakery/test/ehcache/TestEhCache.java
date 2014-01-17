package com.gmind7.bakery.test.ehcache;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.gmind7.bakery.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@TransactionConfiguration(defaultRollback = true)
@ActiveProfiles("loc")
public class TestEhCache {
	
	@Autowired
	private TestEhCacheService service;
	
	private Baker baker;
	
	@Before
	public void before(){
		Baker baker = new Baker();
		baker.setId(1L);
		baker.setUsername("gmind7");
		this.baker = baker;
	}
	
	@Test
	public void test(){
		service.setCahce(this.baker);
		assertEquals(this.baker, service.getCache(this.baker.getId()));
		assertTrue(service.deleteCache(this.baker.getId()));
	}
}
