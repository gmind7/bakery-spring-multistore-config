package com.gmind7.bakery.support;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareOperations implements AuditorAware<Object> {

	private Object currentAuditor;

	public void setCurrentAuditor(Object currentAuditor) {
		this.currentAuditor = currentAuditor;
	}

	@Override
	public Object getCurrentAuditor() {
		return currentAuditor;
	}

}