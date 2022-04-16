package com.example.dbmigrationflyway.Cafe.repository;

import com.example.dbmigrationflyway.Cafe.entity.Cakes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CakeRepository extends JpaRepository<Cakes, Long> {
}
