package com.untitled.simpleshop.demo.domain;

import javax.persistence.*;

@Entity
public class BasketItem {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    private Integer quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "basket_id")
    private Basket basket;

    public BasketItem() {

    }

    public BasketItem(Product product, Integer quantity, Basket basket) {
        this.product = product;
        this.quantity = quantity;
        this.basket = basket;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasketId(Basket basket) {
        this.basket = basket;
    }
}
