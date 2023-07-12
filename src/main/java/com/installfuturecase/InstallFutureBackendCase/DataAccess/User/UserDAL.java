package com.installfuturecase.InstallFutureBackendCase.DataAccess.User;

import com.installfuturecase.InstallFutureBackendCase.Entities.users;

import java.util.List;

public interface UserDAL {

    String add(users user);
    String update(users user);
    String delete(users user);
    users getById(int id);
    List<users> getAll();
}
