package com.example.webApp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.webApp.entity.Citizen;
import com.example.webApp.repository.CitizenRepository;

import java.util.Date;

@RestController
@RequestMapping("/citizens")
public class CitizenController {

    @Autowired
    private CitizenRepository citizenRepository;

    @PostMapping
    public ResponseEntity<Integer> createCitizen(@RequestBody Citizen citizen) {
        // Data validations
        if (citizen.getName() == null || citizen.getName().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        if (citizen.getAddress() == null || citizen.getAddress().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        if (citizen.getDateOfBirth().after(new Date())) {
            return ResponseEntity.badRequest().build();
        }

        // Save citizen and return the generated id
        int generatedId = saveCitizen(citizen);
        return ResponseEntity.status(HttpStatus.CREATED).body(generatedId);
    }

    private int saveCitizen(Citizen citizen) {
        Citizen savedCitizen = citizenRepository.save(citizen);
        return savedCitizen.getId();
    }
}
