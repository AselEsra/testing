package com.example.dbmigrationflyway.Cafe.controller;


import com.example.dbmigrationflyway.Cafe.entity.Drinks;
import com.example.dbmigrationflyway.Cafe.service.DrinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/drinks")
public class DrinksController {


    private final DrinksService drinksService;

    @Autowired
    public DrinksController(DrinksService drinksService) {
        this.drinksService = drinksService;
    }

    @GetMapping
    public List<Drinks> getDrinks(){
        return drinksService.getDrinks();
    }
    @GetMapping("/{id}")
    public Optional<Drinks> getDrink(@PathVariable("id") Long id){
        return drinksService.getDrink(id);
    }

    @PostMapping("/add")
    public Drinks addDrink(@RequestBody Drinks drink){
        return drinksService.addDrink(drink);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDrink(@PathVariable Long id){
        return drinksService.deleteDrink(id);
    }

    @PutMapping("/update/{id}")
    public Drinks updateDrink(@PathVariable Long id,
                            @RequestParam(required = false) String name,
                            @RequestParam(required = false) Boolean isSugar,
                            @RequestParam(required = false) Boolean isHot,
                            @RequestParam(required = false) Double price){
        return drinksService.updateDrink(id, name, isSugar, isHot, price);
    }
}

