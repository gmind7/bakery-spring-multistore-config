package com.gmind7.bakery.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class InfinispanPropertyConfig {

	@Configuration
	@Profile("loc")
	@PropertySource("classpath:properties/env_infinispan_loc.properties")
	static class infinispanLocalProp {
	}
	
	@Configuration
	@Profile("dev")
	@PropertySource("classpath:properties/env_infinispan_dev.properties")
	static class infinispanDevProp {
	}
	
	@Configuration
	@Profile("live")
	@PropertySource("classpath:properties/env_infinispan_live.properties")
	static class infinispanLiveProp {
	}
	
}
