package com.example.dbmigrationflyway.Cafe.service;

import com.example.dbmigrationflyway.Cafe.entity.Cakes;
import com.example.dbmigrationflyway.Cafe.repository.CakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CakesService {

    private final CakeRepository cakeRepository;

    @Autowired
    public CakesService(CakeRepository cakeRepository) {
        this.cakeRepository = cakeRepository;
    }

    public List<Cakes> getCakes() {
        return cakeRepository.findAll();
    }

    public Optional<Cakes> getCake(Long id) {
        return cakeRepository.findById(id);
    }

    public Cakes addCake(Cakes cake) {
        return cakeRepository.save(cake);
    }

    public String deleteCake(Long id) {
        boolean exists = cakeRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("cake with id: " + id + " doesn't exist");
        }
        cakeRepository.deleteById(id);
        return "cake with id: "+ id + " deleted";
    }

    @Transactional
    public Cakes updateCake(Long id, String name, String flavour, String frosting, Double price) {
        Cakes cake = cakeRepository.findById(id).orElseThrow(
                () ->new IllegalStateException("cake with id: " + id + "doesn't exist"));
        if (name != null && name.length() > 0){
            cake.setName(name);
        }
        if (flavour != null && flavour.length() > 0) {
            cake.setFlavour(flavour);
        }
        if (frosting != null && frosting.length() > 0) {
            cake.setFrosting(frosting);
        }
        if ( price != null && price > 0) {
            cake.setPrice(price);
        }
        return cakeRepository.save(cake);
    }
}
