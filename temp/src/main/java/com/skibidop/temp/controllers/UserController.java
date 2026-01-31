package com.skibidop.temp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skibidop.temp.dtos.UserDto;
import com.skibidop.temp.models.UserData;
import com.skibidop.temp.repositories.UserRepo;






//เป็นการบอกว่าไฟล์นี้ทำอะไร
@RestController
public class UserController {

    //ทำผ่าน Repo ไม่ดีเท่าไหรๆๆๆๆ ควรจะผ่านdtoก่อนreturnนะจ๊ะ
    @GetMapping("/user")
    public List<UserData> getUser(){
        UserRepo usersRepo = new UserRepo();
        //ถ้าใช้ userepo(ของauto wiredนะ) มันจะทำให้เวลาเรา add ไปแล้ว get ใหม่ข้อมูลยังอยู่เพราะเป็นการ reusesable คือมัน memory แต่ถ้า new ก็จะไม่มีเพราะมัน new
        return usersRepo.getUsers();

    }
    @GetMapping("/user-dto")  
    public List<UserDto> getMethodName() {
        UserRepo ListOfUsers = new UserRepo(); //มันมี attrivute เป็น List นะจะ map เพื่อไปทีละตัวของ list แล้ว สร้างเป็น list ใหม่ของ dto แล้ว return ก้ได้
        List<UserDto> ListUserDto = ListOfUsers.getUsers().stream().map(user-> new UserDto(user.getName(),user.getEmail(),user.getPassword())).toList();
        return ListUserDto;
    }
    @GetMapping("/user-dto/{id}") //ไม่ดีเราทำ auto wired เพื่อต้องสร้าง object ของ UserRepo ใหม่เพื่อเรียกใช้
    public UserDto getUserById(@PathVariable String id) {
        UserRepo users = new UserRepo();
        UserDto user = users.getUsers().stream()
        .filter(finduser -> finduser.getId().equals(id))
        .map(mapper-> new UserDto(mapper.getId(),mapper.getName(),mapper.getEmail(),mapper.getPassword()))
        .findFirst().orElse(null);
        return user;
    }
    
    //ประกาศตัวแทนที่เป็นตัวแทนของคลาส repository นั้นเพื่ไม่ต้องไปสร้าง new ใหม่
    @Autowired
    UserRepo userepo;

    @GetMapping("/user-dto-autowired")  
    public List<UserDto> getMethodNameMemmory() {
        List<UserDto> ListUserDto = userepo.getUsers().stream().map(user-> new UserDto(user.getId(),user.getName(),user.getEmail(),user.getPassword())).toList();
        return ListUserDto;
    }

    @GetMapping("/user-dto-autowired/{id}")
    public UserDto getUserByIdAutowired(@PathVariable String id) {
        UserDto user = userepo.getUsers().stream()
        .filter(finduser -> finduser.getId().equals(id))
        .map(mapper-> new UserDto(mapper.getId(),mapper.getName(),mapper.getEmail(),mapper.getPassword()))
        .findFirst().orElse(null);
        return user;
    }
    
    @PostMapping("/user-dto-autowired")
    public UserDto postUser(@RequestBody UserDto user){
        String id = String.valueOf(userepo.getUsers().size());
        //Add user
        userepo.addUser(new UserData(id,user.getName(),user.getEmail(),user.getPassword()));

        //Return ตัวที่ Add ล่าสุด
        UserDto LastUser = userepo.getUsers().stream()
        .filter(finduser -> finduser.getId().equals(id))
        .map(mapper-> new UserDto(mapper.getId(),mapper.getName(),mapper.getEmail(),mapper.getPassword()))
        .findFirst().orElse(null);
        return LastUser;
    }

    @PutMapping("/user-dto-autowired/{id}")
    public String putMethodName(@PathVariable String id, @RequestBody UserDto userDto) {
        userepo.editUser(id,userDto.getName(),userDto.getEmail(),userDto.getPassword());
        return "Update Successfully";
    }
    
    @DeleteMapping("/user-dto-autowired/{id}")
    public String deleteUser(@PathVariable String id){
        UserData userTodelete = userepo.getUsers().stream()
        .filter(user-> user.getId().equals(id))
        .findFirst()
        .orElse(null);
        if (userTodelete != null){
            userepo.removeUser(userTodelete);
            return "Successfully delete user";
        }
        return "user not found";
    }
}
