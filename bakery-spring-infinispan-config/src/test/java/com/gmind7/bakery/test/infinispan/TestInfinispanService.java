package com.gmind7.bakery.test.infinispan;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class TestInfinispanService {
	
	@Cacheable(value = "default")
	public Baker getCache(long id) {
		return null;
	}
	
	@CachePut(value = "default", key = "#baker.id")
	public Baker setCahce(Baker baker){
		return baker;
	}
	
	@CacheEvict(value = "default")
	public boolean deleteCache(long id){
		return true;
	}
	
}
