package com.gmind7.bakery.test.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import com.mysema.query.SearchResults;
import com.mysema.query.jpa.JPQLQuery;


public class BakerJpaRepositoryImpl extends QueryDslRepositorySupport implements BakerJpaRepositoryCustom {
	
	public BakerJpaRepositoryImpl() {
		super(Baker.class);
	}
	
	@PersistenceContext 
	private EntityManager em;

	@Override
	public Page<Baker> QFindByBaker(Pageable pageable) {
		JPQLQuery query = from(QBaker.baker).where(QBaker.baker.id.eq(1L));
		query = super.getQuerydsl().applyPagination(pageable, query);
		SearchResults<Baker> entitys = query.listResults(QBaker.baker);
		return new PageImpl<Baker>(entitys.getResults(), pageable, entitys.getTotal());
	}
}
