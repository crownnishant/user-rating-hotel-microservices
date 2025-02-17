package com.lcw.rating.service;

import com.lcw.rating.entity.Rating;

import java.util.List;

public interface RatingService {

    //create rating

    Rating create(Rating rating);
    //get all ratings

    List<Rating> getRatings();
    //get all by userid

    List<Rating> getRatingByUserId(String userId);
    //get all by hotel

    List<Rating> getRatingByHotelId(String hotelId);
}
