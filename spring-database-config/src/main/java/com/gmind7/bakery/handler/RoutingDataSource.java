package com.gmind7.bakery.handler;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.gmind7.bakery.handler.DataSourceContextHolder;

public class RoutingDataSource extends AbstractRoutingDataSource {
	
	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceContextHolder.getDataSourceType();
	}
	
}
