package com.example.demo.model;

import com.example.demo.strategy.PricingStrategy;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;


public class Order {
    @JsonProperty("drinks")
    private final List<Drink> drinks;
    private final PricingStrategy pricingStrategy;

    public Order(@NonNull PricingStrategy pricingStrategy) {
        this.drinks = new ArrayList<>();
        this.pricingStrategy = pricingStrategy;
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public double calculateTotal() {
        double total = 0;
        for (Drink drink : drinks) {
            total += pricingStrategy.calculatePrice(drinks);
        }
        return total;
    }
}
