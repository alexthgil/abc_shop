package com.untitled.simpleshop.demo.repos;

import com.untitled.simpleshop.demo.domain.Basket;
import com.untitled.simpleshop.demo.domain.Product;
import com.untitled.simpleshop.demo.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface BasketRepository extends CrudRepository<Basket, Integer> {
    Basket findByUserOwnerId(Long id);
}
