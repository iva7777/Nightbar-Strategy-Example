package com.example.demo.strategy;

import com.example.demo.model.Drink;

import java.util.List;

public class DiscountedPricingStrategy implements PricingStrategy{
    @Override
    public double calculatePrice(List<Drink> drinks) {
        return drinks.stream()
                .mapToDouble(drink -> drink.getNormalPrice() * 0.9) // 10% discount
                .sum();
    }
}
