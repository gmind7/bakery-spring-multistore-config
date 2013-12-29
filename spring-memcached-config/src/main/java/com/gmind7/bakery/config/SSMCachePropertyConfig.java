package com.gmind7.bakery.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class SSMCachePropertyConfig {

	@Configuration
	@Profile("loc")
	@PropertySource("classpath:properties/env_ssm_loc.properties")
	static class ssmLocalProp {
	}
	
	@Configuration
	@Profile("dev")
	@PropertySource("classpath:properties/env_ssm_dev.properties")
	static class ssmDevProp {
	}
	
	@Configuration
	@Profile("live")
	@PropertySource("classpath:properties/env_ssm_live.properties")
	static class ssmLiveProp {
	}
	
}
