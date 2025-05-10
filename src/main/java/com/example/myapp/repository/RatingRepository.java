package com.example.myapp.repository;

import com.example.myapp.dto.AlbumRatingDTO;
import com.example.myapp.entity.Rating;
import com.example.myapp.entity.RatingId;
import com.example.myapp.entity.Album;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, RatingId> {

    @Query("SELECT new com.example.myapp.dto.AlbumRatingDTO(a, AVG(r.rating)) " +
            "FROM Rating r JOIN Album a ON r.idAlbum = a.id_album " +
            "GROUP BY a.id_album ORDER BY AVG(r.rating) DESC")
    List<AlbumRatingDTO> findTopAlbumsByAvgRating(Pageable pageable);

    @Query("SELECT new com.example.myapp.dto.AlbumRatingDTO(a, AVG(r.rating)) " +
            "FROM Album a LEFT JOIN Rating r ON r.idAlbum = a.id_album " +
            "GROUP BY a.id_album ORDER BY a.relYear DESC")
    List<AlbumRatingDTO> findLatestAlbums(Pageable pageable);




    List<Rating> findByIdUser(int idUser);
}


