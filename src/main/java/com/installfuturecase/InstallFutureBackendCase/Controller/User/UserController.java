package com.installfuturecase.InstallFutureBackendCase.Controller.User;

import com.installfuturecase.InstallFutureBackendCase.Entities.users;
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
    public List<users> get(){
        return userService.getAll();
    }

    @PostMapping("/add")
    public String add(@RequestBody users user){
        return userService.add(user);
    }

    @PostMapping("/update")
    public String update(@RequestBody users user){
        return userService.update(user);
    }

    @PostMapping("/delete")
    public String delete(@RequestBody users user){
        return userService.delete(user);
    }

    @GetMapping("/{id}")
    public users getByID(@PathVariable int id){
        return userService.getById(id);
    }

}