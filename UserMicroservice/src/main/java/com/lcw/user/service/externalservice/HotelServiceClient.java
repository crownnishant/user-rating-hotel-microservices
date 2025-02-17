package com.lcw.user.service.externalservice;

import com.lcw.user.service.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="HOTELSERVICE")
public interface HotelServiceClient {

    @GetMapping("/hotels/{hotelId}")
    Hotel getHotel(@PathVariable String hotelId);

}
