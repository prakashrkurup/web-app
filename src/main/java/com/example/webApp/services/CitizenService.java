package com.example.webApp.services;

import com.example.webApp.entity.Citizen;
import com.example.webApp.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitizenService {
    @Autowired
    private CitizenRepository repository;

}
