package com.lcw.user.service.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//No need to @Entity, because we are not saving data from here, will create separate microservices.
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;

    private Hotel hotel;

}
