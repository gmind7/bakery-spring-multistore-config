package com.gmind7.bakery.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class DefaultInfinispanPropertyConfig {
	
	@Configuration
	@Profile("loc")
	@PropertySource("classpath:environment/infinispan_loc.properties")
	static class infinispanLocalProp {
	}
	
}
