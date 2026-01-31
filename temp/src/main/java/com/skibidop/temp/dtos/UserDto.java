package com.skibidop.temp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto {
    // public class Message {
    // @JsonProperty("body")
    // private String content;  // รับค่า จาก field "body" ไปใส่ content
    
    // @JsonProperty("sender")
    // private String sender;   // รับค่า จาก field "sender" ไปใส่ sender
    // }
    
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;

    public UserDto(){

    }
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
