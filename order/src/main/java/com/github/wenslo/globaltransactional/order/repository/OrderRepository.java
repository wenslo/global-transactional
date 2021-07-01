package com.github.wenslo.globaltransactional.order.repository;

import com.github.wenslo.globaltransactional.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author wenhailin
 */
@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    
}
