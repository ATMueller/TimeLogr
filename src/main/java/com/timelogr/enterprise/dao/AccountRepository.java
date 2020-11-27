package com.timelogr.enterprise.dao;

import com.timelogr.enterprise.dto.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
}
