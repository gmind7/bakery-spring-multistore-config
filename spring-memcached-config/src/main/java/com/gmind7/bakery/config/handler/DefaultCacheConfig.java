package com.gmind7.bakery.config.handler;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.code.ssm.Cache;
import com.google.code.ssm.CacheFactory;
import com.google.code.ssm.spring.SSMCache;
import com.gmind7.bakery.config.SSMSpringCacheConfig;

@Configuration
public class DefaultCacheConfig implements CacheConfigurationFactory {

	@Inject
	private SSMSpringCacheConfig ssmSpringCacheConfig;
	
	@Override
	public Set<SSMCache> ssmCaches() throws Exception {
		
		Set<SSMCache> cacheMap = new HashSet<SSMCache>();
		// 3600(60minutes)*24(hour)*7(day) , @CacheEvict(..., "allEntries" = true) doesn't work
		cacheMap.add(new SSMCache(defaultCache(), 3600*24*7, false));
		
		return cacheMap;
	}
	
	@Bean(name="defaultCache")
	public Cache defaultCache() throws Exception{
		
		CacheFactory cacheFactory = new CacheFactory();
		cacheFactory.setCacheName("default");
		cacheFactory.setCacheClientFactory(ssmSpringCacheConfig.cacheClientFactory());
		cacheFactory.setAddressProvider(ssmSpringCacheConfig.addressProvider());
		cacheFactory.setConfiguration(ssmSpringCacheConfig.configuration());	
		
		return cacheFactory.getObject();
		
	}
	
}
