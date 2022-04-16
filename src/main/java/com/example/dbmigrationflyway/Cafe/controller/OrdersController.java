package com.example.dbmigrationflyway.Cafe.controller;


import com.example.dbmigrationflyway.Cafe.dto.OrdersDto;
import com.example.dbmigrationflyway.Cafe.entity.Cakes;
import com.example.dbmigrationflyway.Cafe.entity.Customers;
import com.example.dbmigrationflyway.Cafe.entity.Drinks;
import com.example.dbmigrationflyway.Cafe.entity.Orders;
import com.example.dbmigrationflyway.Cafe.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    public final OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }
    @GetMapping
    public List<Orders> getOrders(){
        return ordersService.getOrders();
    }
    @GetMapping("/{id}")
    public Optional<Orders> getOrder(@PathVariable Long id){
        return ordersService.getOrder(id);
    }
    @PostMapping("/add")
    public Orders addOrder(@RequestBody OrdersDto order){
        return ordersService.addOrder(order);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id){
        return ordersService.deleteOrder(id);
    }
    @PutMapping("/update/{id}")
    public Orders updateOrder(@PathVariable Long id,
                              @RequestParam(required = false) Customers customerId,
                              @RequestParam(required = false) Cakes cakeId,
                              @RequestParam(required = false) Drinks drinkId,
                              @RequestParam LocalDateTime date){
        return ordersService.updateOrder(id, customerId, cakeId, drinkId, date);
    }
}
