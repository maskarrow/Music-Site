package com.example.myapp.controller;

import com.example.myapp.entity.Rating;
import com.example.myapp.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.myapp.entity.Review; // or Rating
import com.example.myapp.repository.ReviewRepository; // or RatingRepository

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingRepository repo;
    @Autowired
    private RatingRepository ratingRepository;

    @GetMapping
    public List<Rating> getAll() {
        return repo.findAll();
    }
    @PostMapping("/ratings/add")
    public String addRating(@RequestParam int id_user, @RequestParam int id_album, @RequestParam int rating) {
        Rating r = new Rating();
        r.setIdUser(id_user);
        r.setIdAlbum(id_album);
        r.setRating(rating);
        ratingRepository.save(r);
        return "redirect:/albums/" + id_album;
    }

}
