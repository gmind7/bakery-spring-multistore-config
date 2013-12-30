package com.gmind7.bakery.handler;

import java.util.Set;

import org.apache.tomcat.jdbc.pool.DataSource;

public interface DataSourceConfigurationFactory {

	public Set<DataSource> dataSources() throws Exception;
	
}
