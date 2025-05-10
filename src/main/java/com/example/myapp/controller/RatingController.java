package com.example.myapp.controller;

import com.example.myapp.entity.Rating;
import com.example.myapp.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingRepository repo;

    @GetMapping
    public List<Rating> getAll() {
        return repo.findAll();
    }
}
