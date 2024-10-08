package com.example.demo.repository;

import com.example.demo.model.BarClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<BarClient, Long> {
}
