package com.skibidop.temp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserDto {
    // public class Message {
    // @JsonProperty("body")
    // private String content;  // รับค่า จาก field "body" ไปใส่ content
    
    // @JsonProperty("sender")
    // private String sender;   // รับค่า จาก field "sender" ไปใส่ sender
    // }
    
    //ใช้ในการรับ REQ
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    @NotBlank(message="Email cannot be null")
    @Email(message="Email is not valid format")
    private String email;
    
    @JsonProperty("password")
    private String password;

    public UserDto(){

    }

    //ใช้ในการส่ง RES
    public UserDto(String name,String email,String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public UserDto(String id,String name,String email,String password){
        this.id = id;
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

// Hibernate validators provide the following annotations that are very helpful for software development.

// @NotNull: @NotNull ensures that a field is not null but allows empty values (e.g., an empty string or an empty collection).
// @NotEmpty: @NotEmpty ensures that a field is not null and also not empty, meaning it must contain at least one element (for collections) or at least one character (for strings).
// @NotBlank: @NotBlank applies only to strings and ensures they are not null, not empty and contain at least one non-whitespace character (i.e., spaces alone are not allowed).
// @Min: Given Minimum value has to be satisfied
// @Max: Given Maximum value has to be satisfied
// @Size: Field size should be less than or greater than the specified field size
// @Email: Email can be validated with this
// @Pattern: Given the RegEx Pattern has to be satisfied.