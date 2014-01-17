package com.gmind7.bakery.support;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareOperations implements AuditorAware<Object> {

	private Object auditor;

	public void setAuditor(Object auditor) {
		this.auditor = auditor;
	}

	@Override
	public Object getCurrentAuditor() {
		return auditor;
	}

}