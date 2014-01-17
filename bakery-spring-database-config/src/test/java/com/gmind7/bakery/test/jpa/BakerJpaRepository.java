package com.gmind7.bakery.test.jpa;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BakerJpaRepository extends PagingAndSortingRepository<Baker, Long>, QueryDslPredicateExecutor<Baker>, BakerJpaRepositoryCustom {

}