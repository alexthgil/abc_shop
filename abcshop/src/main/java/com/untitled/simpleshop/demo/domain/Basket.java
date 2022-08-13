package com.untitled.simpleshop.demo.domain;

import org.hibernate.annotations.Table;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Basket {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "basket", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<BasketItem> itemSet;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userOwner;

    public User getUserOwner() {
        return userOwner;
    }

    public void setUserOwner(User userOwner) {
        this.userOwner = userOwner;
    }

    public Basket(User userOwner, String name, String description) {
        this.userOwner = userOwner;
        this.name = name;
        this.description = description;
    }

    public Basket() {
    }

    public void addItem(BasketItem item) {
        if (itemSet == null) {
            itemSet = new HashSet<BasketItem>();
        }

        itemSet.add(item);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<BasketItem> getItemSet() {
        return itemSet;
    }

    public void setItemSet(Set<BasketItem> itemSet) {
        this.itemSet = itemSet;
    }

    public Iterable<Product> content() {

        List<Product> productslist = new ArrayList<Product>();

        for (BasketItem item : getItemSet()) {
            productslist.add(item.getProduct());
        }

        return productslist;
    }
}
