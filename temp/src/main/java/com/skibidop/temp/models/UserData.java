package com.skibidop.temp.models;

//จำลอง database เก็บข้อมูล table User

public class UserData {
    private String id;
    private String name;
    private String email;
    private String password;

    public UserData(){
        this.id = "0";
        this.name = "";
        this.email = "";
        this.password = "";
    }

    public UserData(String name,String email,String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserData(String id,String name,String email,String password){
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
