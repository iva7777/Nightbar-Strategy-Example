package com.example.demo.service;

import com.example.demo.model.Drink;
import com.example.demo.model.Order;
import com.example.demo.repository.DrinkRepository;
import com.example.demo.strategy.DiscountedPricingStrategy;
import com.example.demo.strategy.NormalPricingStrategy;
import com.example.demo.strategy.PricingStrategy;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class NightBarService {
    private final DrinkRepository drinkRepository;
    private final List<Order> orders;
    public NightBarService(@NonNull DrinkRepository drinkRepository) {
        this.orders = new ArrayList<>();
        this.drinkRepository = drinkRepository;
    }

    public List<Drink> getAllDrinks() {
        return drinkRepository.findAll();
    }

    public void addDrink(Drink drink) {
        drinkRepository.save(drink);
    }

    public double calculateBill(Order order) {
        return order.calculateTotal();
    }

    public Order createOrder() {
        LocalTime now = LocalTime.now();
        PricingStrategy strategy;

        if (now.isAfter(LocalTime.of(8,0)) && now.isBefore(LocalTime.of(20, 0))) {
            strategy = new DiscountedPricingStrategy();
        } else {
            strategy = new NormalPricingStrategy();
        }

        return new Order(strategy);
    }

    public void saveOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getAllOrders() {
        return orders;
    }
}
