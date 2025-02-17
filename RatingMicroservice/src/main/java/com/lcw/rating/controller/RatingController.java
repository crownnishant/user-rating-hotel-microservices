package com.lcw.rating.controller;

import com.lcw.rating.entity.Rating;
import com.lcw.rating.repository.RatingRepository;
import com.lcw.rating.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
@RequiredArgsConstructor
public class RatingController {

    private final RatingService ratingService;

    //create ratings

    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }
    //get all ratings
    @GetMapping
    public ResponseEntity<List<Rating>> getRatings(){
        return ResponseEntity.ok(ratingService.getRatings());
    }

    //get all ratings by userid
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId){
        return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
    }

    //get all ratings by Hotelid
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }

}
