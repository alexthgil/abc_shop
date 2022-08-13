package com.untitled.simpleshop.demo.controller;

import com.untitled.simpleshop.demo.domain.Product;
import com.untitled.simpleshop.demo.domain.User;
import com.untitled.simpleshop.demo.repos.ProductRepository;
import com.untitled.simpleshop.demo.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/basket")
public class BasketController {

    @Autowired
    private BasketService basketService;

    @GetMapping
    public String basketContent(@AuthenticationPrincipal User user, Map<String, Object> model) {
        Iterable<Product> products = basketService.allSelectedProductsFor(user);
        model.put("products", products);
        return "basket";
    }

    @GetMapping("{product}")
    public String addProductToBusket(@AuthenticationPrincipal User user,@PathVariable Product product, Map<String, Object> model) {
        basketService.save(user, product);
        return "redirect:/product";
    }
}
