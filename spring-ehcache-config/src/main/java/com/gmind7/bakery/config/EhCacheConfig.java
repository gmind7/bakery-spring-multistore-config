package com.gmind7.bakery.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching
public class EhCacheConfig {

	@Bean(name = "ehcache")
	public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
	    EhCacheManagerFactoryBean bean = new EhCacheManagerFactoryBean();
	    bean.setConfigLocation(new ClassPathResource("META-INF/ehcache.xml"));
	    bean.setShared(true);
	    return bean;
	}
	
	@Bean(name = "cacheManager")
    public EhCacheCacheManager cacheManager() {
    	EhCacheCacheManager ehCacheCacheManager = new EhCacheCacheManager();
    	ehCacheCacheManager.setCacheManager(ehCacheManagerFactoryBean().getObject());
        return ehCacheCacheManager;
    }
	
}