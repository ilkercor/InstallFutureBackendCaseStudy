package com.installfuturecase.InstallFutureBackendCase.Service.User;

import com.installfuturecase.InstallFutureBackendCase.Entities.users;

import java.util.List;

public interface UserService {

    String add(users user);
    String update(users user);
    String delete(users user);
    users getById(int id);
    List<users> getAll();
}
