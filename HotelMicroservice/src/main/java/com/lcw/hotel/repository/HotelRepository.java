package com.lcw.hotel.repository;

import com.lcw.hotel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, String> {
}
