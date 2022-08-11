package com.github.mellik21.model;

import com.github.foodapp.api.dto.CuisineType;
import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Data
@NoArgsConstructor
@Table(name = "\"order\"")
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "order_generator")
    @SequenceGenerator(name = "order_generator", sequenceName = "\"order_id_seq\"")
    private Long id;

    @Column(name = "restaurant_id")
    private Long restaurantId;

    @Column(name = "cuisine_type")
    @Enumerated(EnumType.STRING)
    private CuisineType cuisineType;

    @Column
    private String address;

    @Column
    private String comment;

}
