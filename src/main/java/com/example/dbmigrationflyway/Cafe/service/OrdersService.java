package com.example.dbmigrationflyway.Cafe.service;

import com.example.dbmigrationflyway.Cafe.dto.OrdersDto;
import com.example.dbmigrationflyway.Cafe.entity.Cakes;
import com.example.dbmigrationflyway.Cafe.entity.Customers;
import com.example.dbmigrationflyway.Cafe.entity.Drinks;
import com.example.dbmigrationflyway.Cafe.entity.Orders;
import com.example.dbmigrationflyway.Cafe.repository.CakeRepository;
import com.example.dbmigrationflyway.Cafe.repository.CustomerRepository;
import com.example.dbmigrationflyway.Cafe.repository.DrinkRepository;
import com.example.dbmigrationflyway.Cafe.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CakeRepository cakeRepository;

    @Autowired
    private DrinkRepository drinkRepository;

    @Autowired
    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public List<Orders> getOrders(){
        return ordersRepository.findAll();
    }

    public Optional<Orders> getOrder(Long id){
        return ordersRepository.findById(id);
    }

    public Orders addOrder(OrdersDto dto){
        Orders order = new Orders();
        order.setCustomerId(customerRepository.findById(dto.getCustomer_id()).orElseThrow(
                ()-> new IllegalStateException("Customer with id = " + dto.getCustomer_id() + "doesn't exist")
        ));
        order.setCakeId(cakeRepository.findById(dto.getCake_id()).orElseThrow(
                () -> new IllegalStateException("Cake with id = " + dto.getCake_id() + "doesn't exist")
        ));
        order.setDrinkId(drinkRepository.findById(dto.getDrink_id()).orElseThrow(
                ()-> new IllegalStateException("Drink with id = " + dto.getDrink_id() + "doesn't exist")
        ));
        LocalDateTime now = LocalDateTime.now();
        order.setDate(now);
        return ordersRepository.save(order);
    }

    public String deleteOrder(Long id){
        boolean exists = ordersRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("order with id: " + id + " doesn't exist");
        }
        ordersRepository.deleteById(id);
        return "order with id: "+ id + " deleted";
    }

    public Orders updateOrder(Long id, Customers customerId, Cakes cakeId, Drinks drinkId, LocalDateTime localDateTime){
        Orders order = ordersRepository.findById(id).orElseThrow(
                () ->new IllegalStateException("order with id: " + id + "doesn't exist"));
        order.setCustomerId(customerId);
        order.setCakeId(cakeId);
        order.setDrinkId(drinkId);
        if (localDateTime != null) {
            order.setDate(localDateTime);
        }
        return ordersRepository.save(order);
    }
}
