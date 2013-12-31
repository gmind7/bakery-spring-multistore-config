package com.gmind7.bakery.config;

import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

/**
 * Configuration, EnableCaching
 */
public abstract class AbstractEhCacheConfig {

	@Bean
	public EhCacheManagerFactoryBean ehCacheManagerFactory() {
	    EhCacheManagerFactoryBean bean = new EhCacheManagerFactoryBean();
	    String configLocation = getEhcacheConfigResource()==null ? "META-INF/ehcache.xml" : getEhcacheConfigResource();
	    bean.setConfigLocation(new ClassPathResource(configLocation));
	    bean.setShared(true);
	    return bean;
	}
	
    public EhCacheCacheManager ehCacheManager() {
    	EhCacheCacheManager ehCacheCacheManager = new EhCacheCacheManager();
    	ehCacheCacheManager.setCacheManager(ehCacheManagerFactory().getObject());
        return ehCacheCacheManager;
    }
	
	/**
	 * example : "META-INF/ehcache.xml"
	 */
	public abstract String getEhcacheConfigResource();
	
	
	/**
	 * Bean
	 * @return this.ehCacheManagerFactory();
	 */
	public abstract EhCacheCacheManager cacheManager();
	
}