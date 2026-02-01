package com.skibidop.temp.repositories;

//Jpa
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skibidop.temp.models.UserData;

@Repository
public interface UserRepo extends JpaRepository<UserData, String> {
    
}
