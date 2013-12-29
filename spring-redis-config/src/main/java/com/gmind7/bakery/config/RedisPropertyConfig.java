package com.gmind7.bakery.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class RedisPropertyConfig {

	@Configuration
	@Profile("loc")
	@PropertySource("classpath:properties/env_redis_loc.properties")
	static class redisLocalProp {
	}
	
	@Configuration
	@Profile("dev")
	@PropertySource("classpath:properties/env_redis_dev.properties")
	static class redisDevProp {
	}
	
	@Configuration
	@Profile("live")
	@PropertySource("classpath:properties/env_redis_live.properties")
	static class redisLiveProp {
	}
	
}
