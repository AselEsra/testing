package com.example.dbmigrationflyway.Cafe.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "cakes")
public class Cakes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name_")
    private String name;
    @Column(name = "flavour")
    private String flavour;
    @Column(name = "frosting")
    private String frosting;
    @Column(name = "price")
    private Double price;

    public Cakes(String name, String flavour, String frosting, Double price) {
        this.name = name;
        this.flavour = flavour;
        this.frosting = frosting;
        this.price = price;
    }
}
