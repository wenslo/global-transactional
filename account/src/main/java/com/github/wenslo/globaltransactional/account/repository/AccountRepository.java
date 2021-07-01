package com.github.wenslo.globaltransactional.account.repository;

import com.github.wenslo.globaltransactional.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wenhailin
 */
@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

}
