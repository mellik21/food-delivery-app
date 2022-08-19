package com.mellik21.deliveryapp.service;

import com.mellik21.deliveryapp.api.dto.RestaurantDto;
import com.mellik21.deliveryapp.dao.RestaurantDao;
import com.mellik21.deliveryapp.model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantDao restaurantDao;

    public RestaurantService(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
    }

    public List<Restaurant> getRestaurantsList() {
        return restaurantDao.findAll();
    }

    public Restaurant getRestaurant(Long restaurantId) {
        return restaurantDao.findById(restaurantId).orElseThrow(
                () -> new RuntimeException("Restaurant with id=" + restaurantId + "doesn't exist"));
    }

    public Restaurant createRestaurant(Restaurant restaurant) {
       return restaurantDao.save(restaurant);
    }

    public void updateRestaurant(Restaurant restaurant) {
        restaurantDao.save(restaurant);
    }

    public void deleteRestaurant(Long id) {
        restaurantDao.deleteById(id);
    }
}
