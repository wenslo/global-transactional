package com.github.wenslo.globaltransactional.order.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author wenhailin
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "account_order")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    private Long orderAccountId;
    private String orderAccountName;
    private LocalDateTime orderTime;
    private String orderType;
}
