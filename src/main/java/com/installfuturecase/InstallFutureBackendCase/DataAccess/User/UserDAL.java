package com.installfuturecase.InstallFutureBackendCase.DataAccess.User;

import com.installfuturecase.InstallFutureBackendCase.Entities.Users;

import java.util.List;

public interface UserDAL {

    String add(Users user);
    String update(Users user);
    String delete(Users user);
    Users getById(int id);
    List<Users> getAll();
}
