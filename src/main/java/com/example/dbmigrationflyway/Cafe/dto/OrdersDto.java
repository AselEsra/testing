package com.example.dbmigrationflyway.Cafe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersDto {
    private LocalDateTime date;
    private Long customer_id;
    private Long cake_id;
    private Long drink_id;
}
