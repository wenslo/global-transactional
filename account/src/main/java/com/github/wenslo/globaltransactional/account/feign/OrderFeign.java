package com.github.wenslo.globaltransactional.account.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wenhailin
 */
@Component
@FeignClient("order")
@RequestMapping("order")
public interface OrderFeign {
    @RequestMapping("order")
    String order(@RequestParam("accountId") Long accountId, @RequestParam("accountName") String accountName);
}
