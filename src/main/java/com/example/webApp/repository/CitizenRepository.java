package com.example.webApp.repository;

import com.example.webApp.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitizenRepository extends JpaRepository<Citizen, Integer> {
//    Citizen findByName(String name);
}
