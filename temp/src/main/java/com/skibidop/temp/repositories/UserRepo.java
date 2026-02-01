package com.skibidop.temp.repositories;

//Jpa
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skibidop.temp.models.UserData;

@Repository
public interface UserRepo extends JpaRepository<UserData, String> {
    Optional<UserData> findByemail(String email);
    Optional<UserData> findByname(String name);
}

// สร้างชื่อ function ตัว Jpa ก็จะ parse เป็นคำสั่ง SQL สุดเท่ให้ได้เลย โคตรดี
// findByemail(String email)
// ^^^^  ^^^^^
// |     |
// |     └── ชื่อ field ใน Entity class (UserData.email)
// └── keyword ของ Spring Data (= SELECT ... WHERE)
// มันจะไปดูว่า UserRepo extends JpaRepository<UserData, String> ดังนั้น Entity คือ UserData แล้วไปหา field ชื่อ email ใน UserData.java:18 ซึ่งมีอยู่จริง จากนั้นมันจะ generate SQL ให้เป็น:


// SELECT * FROM users WHERE email = ?
