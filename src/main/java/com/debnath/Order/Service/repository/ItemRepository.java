package com.debnath.Order.Service.repository;

import com.debnath.Order.Service.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {

//      Optional<Item> findByName();
//
//    Optional<Item> findByCategory();
}
