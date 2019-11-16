package com.nriagudubem.search.repository;

import com.nriagudubem.search.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByName(String name);
    Optional<Role> findById(Long Id);
}
