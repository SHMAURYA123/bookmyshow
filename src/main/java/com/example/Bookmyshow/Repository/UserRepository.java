package com.example.Bookmyshow.Repository;

import com.example.Bookmyshow.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
