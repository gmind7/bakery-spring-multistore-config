package com.gmind7.bakery.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class DataBasePropertyConfig {

	@Configuration
	@Profile("loc")
	@PropertySource("classpath:properties/env_database_loc.properties")
	static class dataBaseLocalProp {
	}
	
	@Configuration
	@Profile("dev")
	@PropertySource("classpath:properties/env_database_dev.properties")
	static class dataBaseDevProp {
	}
	
	@Configuration
	@Profile("live")
	@PropertySource("classpath:properties/env_database_live.properties")
	static class dataBaseLiveProp {
	}
	
}
