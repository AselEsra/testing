package com.example.dbmigrationflyway.Cafe.repository;

import com.example.dbmigrationflyway.Cafe.entity.Drinks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DrinkRepository extends JpaRepository<Drinks, Long> {
}
