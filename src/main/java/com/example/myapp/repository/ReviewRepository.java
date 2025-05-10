package com.example.myapp.repository;
import java.util.List;
import com.example.myapp.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByIdUser(int idUser);

}
