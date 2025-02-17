package com.lcw.user.service.repository;

import com.lcw.user.service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    //we can add any custom method or query
}
