package com.lcw.hotel.service;

import com.lcw.hotel.entity.Hotel;

import java.util.List;

public interface HotelService {

    //create
    Hotel create(Hotel hotel);

    //getall
    List<Hotel> getAllHotels();

    //get single
    Hotel getSingleHotel(String id);
}
