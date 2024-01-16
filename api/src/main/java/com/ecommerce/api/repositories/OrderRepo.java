package com.ecommerce.api.repositories;

import com.ecommerce.api.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderRepo extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {
}
