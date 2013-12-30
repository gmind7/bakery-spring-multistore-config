package com.gmind7.bakery.test;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface BakerJpaRepository extends PagingAndSortingRepository<Baker, Long> {

}