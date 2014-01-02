package com.gmind7.bakery.test.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.gmind7.bakery.test.jpa.Baker;

public interface BakerJpaRepository extends PagingAndSortingRepository<Baker, Long> {

}