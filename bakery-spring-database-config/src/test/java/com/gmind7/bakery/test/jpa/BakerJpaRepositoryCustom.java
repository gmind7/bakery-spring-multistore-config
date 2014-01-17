package com.gmind7.bakery.test.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

interface BakerJpaRepositoryCustom {
	
	Page<Baker> QFindByBaker(Pageable pageable);
	
}