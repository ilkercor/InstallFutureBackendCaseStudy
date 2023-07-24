package com.installfuturecase.InstallFutureBackendCase.Service.User;

import com.installfuturecase.InstallFutureBackendCase.Entities.Users;

import java.util.List;

public interface UserService {

    String add(Users user);
    String update(Users user);
    String delete(Users user);
    Users getById(int id);
    List<Users> getAll();
}
