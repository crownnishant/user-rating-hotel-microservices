package com.lcw.hotel.Impl;

import com.lcw.hotel.entity.Hotel;
import com.lcw.hotel.exception.ResourceNotFoundException;
import com.lcw.hotel.repository.HotelRepository;
import com.lcw.hotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        String hotelID = UUID.randomUUID().toString();
        hotel.setId(hotelID);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getSingleHotel(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("hotel with given id not found"));
    }
}
