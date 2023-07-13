package com.installfuturecase.InstallFutureBackendCase.DataAccess.User.Impl;

import com.installfuturecase.InstallFutureBackendCase.DataAccess.User.UserDAL;
import com.installfuturecase.InstallFutureBackendCase.Entities.users;
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
    public List<users> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<users> usersList = session.createQuery("from users", com.installfuturecase.InstallFutureBackendCase.Entities.users.class).getResultList();
        return usersList;
    }

    @Override
    @Transactional
    public String add(users user) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(user);
        return user.getUsername()+" is saved to Database ";
    }

    @Override
    @Transactional
    public String update(users user) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(user);
        return user.getUsername()+" is updated.";
    }

    @Override
    @Transactional
    public String delete(users user) {
        Session session = entityManager.unwrap(Session.class);
        users userToDelete = session.get(users.class, user.getUserID());
        session.delete(userToDelete);
        return userToDelete.getUsername()+" is deleted.";
    }
    @Override
    @Transactional
    public users getById(int id) {
        Session session =  entityManager.unwrap(Session.class);
        users user = session.get(users.class, id);
        return user;
    }

}