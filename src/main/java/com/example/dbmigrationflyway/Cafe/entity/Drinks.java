package com.example.dbmigrationflyway.Cafe.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "drinks")
public class Drinks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name_")
    private String name;
    @Column(name = "is_sugar")
    private Boolean isSugar;
    @Column(name = "is_hot")
    private Boolean isHot;
    @Column(name = "price")
    private Double price;

    public Drinks(String name, Boolean isSugar, Boolean isHot, Double price) {
        this.name = name;
        this.isSugar = isSugar;
        this.isHot = isHot;
        this.price = price;
    }
}
