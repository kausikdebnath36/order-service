package com.debnath.Order.Service.repository;

import com.debnath.Order.Service.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Long> {

//    Optional<Orders> findById();


}
