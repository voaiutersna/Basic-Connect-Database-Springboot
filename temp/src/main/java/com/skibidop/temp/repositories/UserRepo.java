package com.skibidop.temp.repositories;

//จำลองว่าเป็น orm

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.skibidop.temp.models.UserData;

@Repository
public class UserRepo {
    //list users array (Example database)
    private List<UserData> users = new ArrayList<>(
        List.of(
            new UserData("0","skibidop","example1@gmail.com","12345"),
            new UserData("1","winmorsight","example2@gmail.com","6789")
        )
    );
    
    public List<UserData> getUsers(){
        return users;
    }



    public void addUser(UserData user){
        users.add(user);
    }


    public void editUser(String id,String name,String email,String password){
        for(int i=0;i<users.size();i++){
            if(users.get(i).getId().equals(id)){
                users.get(i).setName(name);
                users.get(i).setEmail(email);
                users.get(i).setPassword(password);
            }
        }
    }

    public void removeUser(UserData user){
        users.remove(user);
    }

}
