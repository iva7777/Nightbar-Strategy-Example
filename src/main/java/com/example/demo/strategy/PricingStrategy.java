package com.example.demo.strategy;

import com.example.demo.model.Drink;

import java.util.List;

public interface PricingStrategy {
    double calculatePrice(List<Drink> drinks);
}
