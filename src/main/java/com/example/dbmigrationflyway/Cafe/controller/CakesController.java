package com.example.dbmigrationflyway.Cafe.controller;


import com.example.dbmigrationflyway.Cafe.entity.Cakes;
import com.example.dbmigrationflyway.Cafe.service.CakesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/cakes")
public class CakesController {


    private final CakesService cakesService;

    @Autowired
    public CakesController(CakesService cakesService) {
        this.cakesService = cakesService;
    }

    @GetMapping
    public List<Cakes> getCakes(){
        return cakesService.getCakes();
    }
    @GetMapping("/{id}")
    public Optional<Cakes> getDessert(@PathVariable("id") Long id){
        return cakesService.getCake(id);
    }

    @PostMapping("/add")
    public Cakes addCake(@RequestBody Cakes cake){
        return cakesService.addCake(cake);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCake(@PathVariable Long id){
        return cakesService.deleteCake(id);
    }

    @PutMapping("/update/{id}")
    public Cakes updateCake(@PathVariable Long id,
                                    @RequestParam(required = false) String name,
                                    @RequestParam(required = false) String flavour,
                                    @RequestParam(required = false) String frosting,
                                    @RequestParam(required = false) Double price){
        return cakesService.updateCake(id, name, flavour, frosting, price);
    }
}

