package com.nriagudubem.search.repository;

import com.nriagudubem.search.model.Email;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface EmailRepository extends CrudRepository<Email, Long> {
}
