package com.gmind7.bakery.config;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.code.ssm.Cache;
import com.google.code.ssm.CacheFactory;
import com.google.code.ssm.spring.SSMCache;
import com.gmind7.bakery.config.AbstractSSMSpringCacheConfig;
import com.gmind7.bakery.handler.SSMCacheConfigurationFactory;

@Configuration
public class TestSSMCacheConfig implements SSMCacheConfigurationFactory {

	@Inject
	private AbstractSSMSpringCacheConfig ssmSpringCacheConfig;
	
	@Override
	public Set<SSMCache> ssmCaches() throws Exception {
		
		Set<SSMCache> cacheMap = new HashSet<SSMCache>();
		// 3600(60minutes)*24(hour)*7(day) , @CacheEvict(..., "allEntries" = true) doesn't work
		cacheMap.add(new SSMCache(testCache(), 3600*24*7, false));
		
		return cacheMap;
	}
	
	@Bean(name="testCache")
	public Cache testCache() throws Exception{
		
		CacheFactory cacheFactory = new CacheFactory();
		cacheFactory.setCacheName("test");
		cacheFactory.setCacheClientFactory(ssmSpringCacheConfig.cacheClientFactory());
		cacheFactory.setAddressProvider(ssmSpringCacheConfig.addressProvider());
		cacheFactory.setConfiguration(ssmSpringCacheConfig.configuration());	
		
		return cacheFactory.getObject();
		
	}
	
}
