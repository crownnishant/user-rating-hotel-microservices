package com.lcw.rating.repository;

import com.lcw.rating.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, String> {

    //custom finder methods
    List<Rating> findByUserId(String userId);

    List<Rating> findByHotelId(String hotelId);

}
