package com.nriagudubem.search.repository;

import com.nriagudubem.search.model.Search;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SearchRepository extends CrudRepository<Search, Long> {
}
