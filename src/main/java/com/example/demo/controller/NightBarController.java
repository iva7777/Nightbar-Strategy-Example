package com.example.demo.controller;

import com.example.demo.model.Drink;
import com.example.demo.model.Order;
import com.example.demo.service.NightBarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class NightBarController {
    private final NightBarService nightBarService;

    public NightBarController(NightBarService nightBarService) {
        this.nightBarService = nightBarService;
    }

    @GetMapping("/drinks")
    public List<Drink> getAllDrinks() {
        return nightBarService.getAllDrinks();
    }

    @PostMapping("/drinks")
    public ResponseEntity<Drink> addDrink(@RequestBody Drink drink) {
        nightBarService.addDrink(drink);
        return ResponseEntity.ok(drink);
    }


    @PostMapping("/orders")
    public ResponseEntity<Double> createOrder(@RequestBody List<Long> drinkIds) {
        Order order = nightBarService.createOrder();
        for (Long drinkId : drinkIds) {
            nightBarService.getAllDrinks().stream()
                    .filter(d -> d.getId().equals(drinkId))
                    .findFirst().ifPresent(order::addDrink);
        }
        double total = nightBarService.calculateBill(order);
        nightBarService.saveOrder(order);
        return ResponseEntity.ok(total);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = nightBarService.getAllOrders();
        return ResponseEntity.ok(orders);
    }
}
