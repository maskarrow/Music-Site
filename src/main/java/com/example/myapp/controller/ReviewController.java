package com.example.myapp.controller;

import com.example.myapp.entity.Review;
import com.example.myapp.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewRepository repo;

    @GetMapping
    public List<Review> getAll() {
        return repo.findAll();
    }
}
