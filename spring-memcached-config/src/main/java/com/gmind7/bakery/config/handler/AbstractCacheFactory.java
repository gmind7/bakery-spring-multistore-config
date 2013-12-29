package com.gmind7.bakery.config.handler;

import java.util.Set;

import com.google.code.ssm.spring.SSMCache;

public interface AbstractCacheFactory {
	
	public abstract Set<SSMCache> ssmCaches() throws Exception;
	
}
