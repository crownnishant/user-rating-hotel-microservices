package com.lcw.user.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lcw.user.service.entity.Hotel;
import com.lcw.user.service.entity.Rating;
import com.lcw.user.service.entity.User;
import com.lcw.user.service.exception.ResourceNotFoundException;
import com.lcw.user.service.externalservice.HotelServiceClient;
import com.lcw.user.service.repository.UserRepository;
import com.lcw.user.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final  UserRepository userRepository;

    //adding RestTemplate for inter-service communication between user and rating

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelServiceClient hotelServiceClient;

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);

    }

    @Override
    public List<User> getAllUser() {

        //Implement rating service call using Rest Template
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        //get user from DB with the help of user repository
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with given id on server:" + userId));
        //fetch rating of the above user from Rating Service
        Rating[] ratingOfUser = restTemplate.getForObject("http://RATINGMICROSERVICE/ratings/users/"+user.getUserId(), Rating[].class);

        List<Rating> ratings = Arrays.stream(ratingOfUser).toList();

    //Api call to hotel service to get the hotel
//http://localhost:8082/hotels/b10b555f-b638-4b75-9e54-9b15cf87bde2
        List<Rating> ratingList = ratings.stream().map(rating -> {

        //ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotels/" + rating.getHotelId(), Hotel.class);
//We can also use getForObject method from resttemplate to make api call, then no need .getbody method

//Hotel hotel = restTemplate.getForObject("http://localhost:8082/hotels/"+rating.getHotelId(), Hotel.class);
        //Hotel hotel = forEntity.getBody();

            Hotel hotel=hotelServiceClient.getHotel(rating.getHotelId());
            //set the hotel
            rating.setHotel(hotel);

            //return rating
            return rating;
        }).collect(Collectors.toList());


        user.setRatings(ratingList);
        return user;

    }
}
