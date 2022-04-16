package com.example.dbmigrationflyway.Cafe.repository;


import com.example.dbmigrationflyway.Cafe.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customers, Long> { }
