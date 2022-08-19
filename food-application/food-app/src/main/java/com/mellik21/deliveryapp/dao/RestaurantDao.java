package com.mellik21.deliveryapp.dao;

import com.mellik21.deliveryapp.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantDao extends JpaRepository<Restaurant, Long> {

}
