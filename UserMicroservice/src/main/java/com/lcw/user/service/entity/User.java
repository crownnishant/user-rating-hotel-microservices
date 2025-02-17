package com.lcw.user.service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="micro_users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name="ID")
    private String userId;

    @Column(name="NAME")
    private String name;

    @Column(name="EMAIL")
    private String email;

    @Column(name="ABOUT")
    private String about;

    //Add new field to get list of rating given by Users
    //This field won't be saved to the database, JPA will ignore saving it
    @Transient
    private List<Rating> ratings =new ArrayList<>();

}
