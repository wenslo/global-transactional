package com.github.wenslo.globaltransactional.order.facade;

import com.github.wenslo.globaltransactional.order.entity.Order;
import com.github.wenslo.globaltransactional.order.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author wenhailin
 */
@Slf4j
@RestController
@RequestMapping("order")
public class OrderFacade {
    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping("order")
    public String order(Long accountId, String accountName) {
        log.info("order's order invoked, accountId is {}, accountName is {}", accountId, accountName);
        for (int i = 0; i < 20; i++) {
            Order order = new Order();
            order.setOrderAccountId(accountId);
            order.setOrderAccountName(accountName);
            order.setOrderTime(LocalDateTime.now());
            order.setOrderType("Video");
            orderRepository.save(order);
            if (i == 16) {
                throw new RuntimeException("Order has been fail");
            }
        }
        return "SUCCESS";
    }
}
