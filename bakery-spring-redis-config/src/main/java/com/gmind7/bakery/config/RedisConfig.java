package com.gmind7.bakery.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;

import com.gmind7.bakery.handler.RedisNode;
import com.gmind7.bakery.handler.RedisSourceTemplate;

@Configuration
public class RedisConfig {

	@Inject
	private Environment environment;
	
	@Bean
	public RedisConnectionFactory redisDefaultConnectionFactory() {
		JedisConnectionFactory redis = new JedisConnectionFactory();
		redis.setHostName(environment.getRequiredProperty("redis1.host"));
		redis.setPort(environment.getRequiredProperty("redis1.port", Integer.class));
		redis.setPoolConfig(jedisPoolConfig());
		redis.setUsePool(true);
		return redis;
	}
	
	@Bean
	public RedisConnectionFactory redis1ConnectionFactory() {
		JedisConnectionFactory redis = new JedisConnectionFactory();
		redis.setHostName(environment.getRequiredProperty("redis1.host"));
		redis.setPort(environment.getRequiredProperty("redis1.port", Integer.class));
		redis.setPoolConfig(jedisPoolConfig());
		redis.setUsePool(true);
		return redis;
	}
	
	@Bean
	public RedisConnectionFactory redis2ConnectionFactory() {
		JedisConnectionFactory redis = new JedisConnectionFactory();
		redis.setHostName(environment.getRequiredProperty("redis2.host"));
		redis.setPort(environment.getRequiredProperty("redis2.port", Integer.class));
		redis.setPoolConfig(jedisPoolConfig());
		redis.setUsePool(true);
		return redis;
	}
	
	@Bean
	public JedisPoolConfig jedisPoolConfig(){
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxActive(environment.getRequiredProperty("redis.maxactive", Integer.class));
		jedisPoolConfig.setMaxIdle(environment.getRequiredProperty("redis.maxidle", Integer.class));		
		jedisPoolConfig.setMaxWait(environment.getRequiredProperty("redis.maxwait", Integer.class));
		jedisPoolConfig.setTimeBetweenEvictionRunsMillis(environment.getRequiredProperty("redis.timebetweenevictionrunsmillis", Integer.class));
		jedisPoolConfig.setTestWhileIdle(environment.getRequiredProperty("redis.testwhileidle", Boolean.class));
		return jedisPoolConfig;
	}
	
	public RedisTemplate<String, Object> serializerRedisTemplate() {
		
        RedisTemplate<String, Object> template =  new RedisTemplate<String, Object>();
        
        template.setKeySerializer(new StringRedisSerializer());
        //template.setValueSerializer(new StringRedisSerializer());
      
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        //template.setHashValueSerializer(new JacksonJsonRedisSerializer<App>(App.class));
        
        return template;
    }
	
	@Bean(name="defaultRedisTemplate")
    public RedisTemplate<String, Object> defaultRedisTemplate() {
		
        RedisTemplate<String, Object> template =  serializerRedisTemplate();
        template.setConnectionFactory(redisDefaultConnectionFactory());
          
        return template;
    }
	
	@Bean(name="redis1Template")
    public RedisTemplate<String, Object> redis1Template() {
		
        RedisTemplate<String, Object> template = serializerRedisTemplate();
        template.setConnectionFactory(redis1ConnectionFactory());
        
        return template;
    }
	
	@Bean(name="redis2Template")
    public RedisTemplate<String, Object> redis2Template() {
		
        RedisTemplate<String, Object> template = serializerRedisTemplate();
        template.setConnectionFactory(redis2ConnectionFactory());
        
        return template;
    }
	
	@Bean
	public RedisSourceTemplate redisTemplate() {
		RedisSourceTemplate routingRedisTemplate = new RedisSourceTemplate();
		routingRedisTemplate.putRedisTemplate(true, RedisNode.BAKERY0xx, redis1Template());
		routingRedisTemplate.putRedisTemplate(true, RedisNode.BAKERY1xx, redis1Template());
		routingRedisTemplate.putRedisTemplate(true, RedisNode.BAKERY2xx, redis1Template());
		routingRedisTemplate.putRedisTemplate(true, RedisNode.BAKERY3xx, redis1Template());
		routingRedisTemplate.putRedisTemplate(true, RedisNode.BAKERY4xx, redis1Template());
		routingRedisTemplate.putRedisTemplate(true, RedisNode.BAKERY5xx, redis2Template());
		routingRedisTemplate.putRedisTemplate(true, RedisNode.BAKERY6xx, redis2Template());
		routingRedisTemplate.putRedisTemplate(true, RedisNode.BAKERY7xx, redis2Template());
		routingRedisTemplate.putRedisTemplate(true, RedisNode.BAKERY8xx, redis2Template());
		routingRedisTemplate.putRedisTemplate(true, RedisNode.BAKERY9xx, redis2Template());
		routingRedisTemplate.putRedisTemplate(false, RedisNode.DEFAULT, defaultRedisTemplate());
		return routingRedisTemplate;
	}
	
}
