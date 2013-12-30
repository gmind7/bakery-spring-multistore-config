package com.gmind7.bakery.config.handler;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.gmind7.bakery.config.handler.DataSourceContextHolder;

public class RoutingDataSource extends AbstractRoutingDataSource{
	
	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceContextHolder.getDataSourceType();
	}
	
}
