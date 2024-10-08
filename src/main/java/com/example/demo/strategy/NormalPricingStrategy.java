package com.example.demo.strategy;

import com.example.demo.model.Drink;

import java.util.List;

public class NormalPricingStrategy implements PricingStrategy{
    @Override
    public double calculatePrice(List<Drink> drinks) {
        return drinks.stream()
                .mapToDouble(Drink::getNormalPrice)
                .sum();
    }
}
