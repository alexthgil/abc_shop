package com.untitled.simpleshop.demo.repos;

import com.untitled.simpleshop.demo.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
