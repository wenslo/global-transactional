package com.github.wenslo.globaltransactional.account.facade;

import com.github.wenslo.globaltransactional.account.entity.Account;
import com.github.wenslo.globaltransactional.account.feign.OrderFeign;
import com.github.wenslo.globaltransactional.account.repository.AccountRepository;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wenhailin
 */
@Slf4j
@RestController
@RequestMapping("account")
public class AccountFacade {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private OrderFeign orderFeign;

    @RequestMapping("save")
    @GlobalTransactional(timeoutMills = 3000, name = "account-order-tx")
    public String save(Account account) {
        log.info("invoke account save--------------------------");
        Account saved = accountRepository.save(account);
        log.info("invoke order save--------------------------");
        String order = orderFeign.order(saved.getId(), saved.getName());
        log.info("order result is {}", order);
        return "SUCCESS";
    }
}
