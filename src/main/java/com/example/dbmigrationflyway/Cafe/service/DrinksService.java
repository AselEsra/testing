package com.example.dbmigrationflyway.Cafe.service;

import com.example.dbmigrationflyway.Cafe.entity.Drinks;
import com.example.dbmigrationflyway.Cafe.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DrinksService {

    private final DrinkRepository drinkRepository;

    @Autowired
    public DrinksService(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public List<Drinks> getDrinks() {
        return drinkRepository.findAll();
    }

    public Optional<Drinks> getDrink(Long id) {
        return drinkRepository.findById(id);
    }

    public Drinks addDrink(Drinks drink) {
        return drinkRepository.save(drink);
    }

    public String deleteDrink(Long id) {
        boolean exists = drinkRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("drink with id: " + id + " doesn't exist");
        }
        drinkRepository.deleteById(id);
        return "drink with id: "+ id + " deleted";
    }

    @Transactional
    public Drinks updateDrink(Long id, String name, Boolean isSugar, Boolean isHot, Double price) {
        Drinks drink = drinkRepository.findById(id).orElseThrow(
                () ->new IllegalStateException("drink with id: " + id + "doesn't exist"));
        if (name != null && name.length() > 0){
            drink.setName(name);
        }
        if (isSugar != null) {
            drink.setIsSugar(isSugar);
        }
        if (isHot != null ) {
            drink.setIsHot(isHot);
        }
        if ( price != null && price > 0) {
            drink.setPrice(price);
        }
        return drinkRepository.save(drink);
    }
}
