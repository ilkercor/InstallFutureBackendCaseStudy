package com.installfuturecase.InstallFutureBackendCase.DataAccess.User.Impl;

import com.installfuturecase.InstallFutureBackendCase.DataAccess.User.UserDAL;
import com.installfuturecase.InstallFutureBackendCase.Entities.Users;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDALImpl implements UserDAL {

    private EntityManager entityManager;

    @Autowired
    public UserDALImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public UserDALImpl() {
    }


    @Override
    @Transactional
    public List<Users> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<Users> usersList = session.createQuery("from users", Users.class).getResultList();
        return usersList;
    }

    @Override
    @Transactional
    public String add(Users user) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(user);
        return user.getUsername()+" is saved to Database ";
    }

    @Override
    @Transactional
    public String update(Users user) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(user);
        return user.getUsername()+" is updated.";
    }

    @Override
    @Transactional
    public String delete(Users user) {
        Session session = entityManager.unwrap(Session.class);
        Users userToDelete = session.get(Users.class, user.getUserID());
        session.delete(userToDelete);
        return userToDelete.getUsername()+" is deleted.";
    }
    @Override
    @Transactional
    public Users getById(int id) {
        Session session =  entityManager.unwrap(Session.class);
        Users user = session.get(Users.class, id);
        return user;
    }

}