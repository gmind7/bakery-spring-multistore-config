package com.gmind7.bakery.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class DefaultDatabasePropertyConfig {

	@Configuration
	@Profile("loc")
	@PropertySource("classpath:environment/database_loc.properties")
	static class databaseLocalProp {
	}
	
//	@Configuration
//	@Profile("dev")
//	@PropertySource("classpath:environment/database_dev.properties")
//	static class databaseDevProp {
//	}
//	
//	@Configuration
//	@Profile("live")
//	@PropertySource("classpath:environment/database_live.properties")
//	static class databaseLiveProp {
//	}
	
}
