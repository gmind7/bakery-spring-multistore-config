package com.gmind7.bakery.handler;

import java.util.Set;

import com.google.code.ssm.spring.SSMCache;

public interface SSMCacheConfigurationFactory {

	public Set<SSMCache> ssmCaches() throws Exception;
	
}
