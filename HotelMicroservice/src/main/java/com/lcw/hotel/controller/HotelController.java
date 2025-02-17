package com.lcw.hotel.controller;

import com.lcw.hotel.entity.Hotel;
import com.lcw.hotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    //create

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));

    }

    //get single hotel

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getSingle(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getSingleHotel(id));

    }

    //get all hotels

    @GetMapping
    public ResponseEntity<List<Hotel>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAllHotels());

    }
}
