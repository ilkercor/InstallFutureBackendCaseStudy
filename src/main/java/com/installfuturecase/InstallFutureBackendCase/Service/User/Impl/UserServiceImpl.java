package com.installfuturecase.InstallFutureBackendCase.Service.User.Impl;

import com.installfuturecase.InstallFutureBackendCase.DataAccess.User.UserDAL;
import com.installfuturecase.InstallFutureBackendCase.Entities.users;
import com.installfuturecase.InstallFutureBackendCase.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAL userDAL;

    @Autowired
    public UserServiceImpl(UserDAL userDAL){
        this.userDAL = userDAL;
    }

    @Override
    public String add(users user) {
        return this.userDAL.add(user);
    }

    @Override
    public String update(users user) {
        return this.userDAL.update(user);
    }

    @Override
    public String delete(users user) {
        return this.userDAL.delete(user);
    }

    @Override
    public users getById(int id) {
        return this.userDAL.getById(id);
    }

    @Override
    public List<users> getAll() {
        return this.userDAL.getAll();
    }
}