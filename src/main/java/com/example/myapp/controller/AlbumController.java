package com.example.myapp.controller;

import com.example.myapp.entity.Album;
import com.example.myapp.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {
    @Autowired
    private AlbumRepository repo;

    @GetMapping
    public List<Album> getAll() {
        return repo.findAll();
    }
}
