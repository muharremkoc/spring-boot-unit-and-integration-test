package com.example.springbootunitvsintegrationtest.repository;

import com.example.springbootunitvsintegrationtest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User,Integer> {


}
