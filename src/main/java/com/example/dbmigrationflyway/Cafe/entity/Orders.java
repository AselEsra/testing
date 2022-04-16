package com.example.dbmigrationflyway.Cafe.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customers customerId;

    @ManyToOne
    @JoinColumn(name = "cake_id", referencedColumnName = "id")
    private Cakes cakeId;

    @ManyToOne
    @JoinColumn(name = "drink_id", referencedColumnName = "id")
    private Drinks drinkId;

    @Column(name = "date_")
    private LocalDateTime date;

    public Orders(Customers customerId, Cakes cakeId, Drinks drinkId) {
        this.customerId = customerId;
        this.cakeId = cakeId;
        this.drinkId = drinkId;
    }
}
