package com.gmind7.bakery.test.ehcache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class TestEhCacheService {
	
	@Cacheable(value = "sample")
	public Baker getCache(long id) {
		return null;
	}
	
	@CachePut(value = "sample", key = "#baker.id")
	public Baker setCahce(Baker baker){
		return baker;
	}
	
	@CacheEvict(value = "sample")
	public boolean deleteCache(long id){
		return true;
	}
	
}
