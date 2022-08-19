package com.mellik21.deliveryapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Entity
@Data
@NoArgsConstructor
@Table(name = "\"restaurant\"")
@AllArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "restaurant_generator")
    @SequenceGenerator(name = "restaurant_generator", sequenceName = "\"restaurant_id_seq\"", allocationSize = 1)
    private Long id;

    @Column
    private String name;


}

