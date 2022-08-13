package com.untitled.simpleshop.demo.service.impl;

import com.untitled.simpleshop.demo.domain.Basket;
import com.untitled.simpleshop.demo.domain.BasketItem;
import com.untitled.simpleshop.demo.domain.Product;
import com.untitled.simpleshop.demo.domain.User;
import com.untitled.simpleshop.demo.repos.BasketRepository;
import com.untitled.simpleshop.demo.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Service
public class BasketServiceImpl implements BasketService {

    private final BasketRepository basketRepository;

    @Autowired
    public BasketServiceImpl(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public void save(User user, Product product) {
        Basket b = basketRepository.findByUserOwnerId(user.getId());
        if (b == null) {
            b = new Basket(user, "", "");
            basketRepository.save(b);
        }

        BasketItem bItem = new BasketItem(product, 1, b);
        b.addItem(bItem);
        basketRepository.save(b);
    }

    public Iterable<Product> allSelectedProductsFor(User user) {
        Basket b = basketRepository.findByUserOwnerId(user.getId());
        if (b != null) {
            return b.content();
        }

        return new ArrayList<Product>();
    }
}
