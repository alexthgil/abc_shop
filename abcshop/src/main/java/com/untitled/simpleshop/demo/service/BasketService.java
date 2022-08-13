package com.untitled.simpleshop.demo.service;

import com.untitled.simpleshop.demo.domain.Basket;
import com.untitled.simpleshop.demo.domain.Product;
import com.untitled.simpleshop.demo.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface BasketService {
    Iterable<Product> allSelectedProductsFor(User user);
    public void save(User user, Product product);
}