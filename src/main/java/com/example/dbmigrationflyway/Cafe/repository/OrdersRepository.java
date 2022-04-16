package com.example.dbmigrationflyway.Cafe.repository;

import com.example.dbmigrationflyway.Cafe.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
