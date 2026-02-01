package com.skibidop.temp.models;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

//Table users
@Entity
@Table(name = "users")
public class UserData {
    @Id // <-- ตัวนี้บอก JPA ว่า field นี้คือ Primary key
    private String id;

    private String name;
    private String email;
    private String password;

    @PrePersist // <-- Auto gen UUID ก่อน save ลง DB
    public void generateId() {
        if (this.id == null) {
            this.id = UUID.randomUUID().toString();
        }
    }

    public UserData(){
    }

    //จริงๆใช้ Contructor ไปเลยไม่ต้องใช้ PrePersist ก็ได้
    public UserData(String name,String email,String password){
        // this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPassword(){
        return this.password;
    }
    public String getId(){
        return this.id;
    }
       

    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setId(String id){
        this.id = id;
    }
}

// JPA ใช้ annotation เป็นตัวกำหนดทุกอย่าง:

// Annotation	หน้าที่
// @Entity	บอกว่า class นี้คือ table
// @Table(name = "users")	กำหนดชื่อ table (ถ้าไม่ใส่จะใช้ชื่อ class)
// @Id	กำหนดว่า field ไหนเป็น Primary Key
// @GeneratedValue	กำหนดวิธี auto generate ค่า PK
