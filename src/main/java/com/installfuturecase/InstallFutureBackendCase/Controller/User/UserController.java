package com.installfuturecase.InstallFutureBackendCase.Controller.User;

import com.installfuturecase.InstallFutureBackendCase.Entities.Users;
import com.installfuturecase.InstallFutureBackendCase.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/list")
    public List<Users> get(){
        return userService.getAll();
    }

    @PostMapping("/add")
    public String add(@RequestBody Users user){
        return userService.add(user);
    }

    @PostMapping("/update")
    public String update(@RequestBody Users user){
        return userService.update(user);
    }

    @PostMapping("/delete")
    public String delete(@RequestBody Users user){
        return userService.delete(user);
    }

    @GetMapping("/{id}")
    public Users getByID(@PathVariable int id){
        return userService.getById(id);
    }

}