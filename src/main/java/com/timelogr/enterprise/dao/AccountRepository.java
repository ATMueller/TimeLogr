package com.timelogr.enterprise.dao;

import com.timelogr.enterprise.dto.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {
    @Query(value = "SELECT * FROM account a WHERE a.email = ?1", nativeQuery = true)
    Account findAccountByEmail(String email);
}
