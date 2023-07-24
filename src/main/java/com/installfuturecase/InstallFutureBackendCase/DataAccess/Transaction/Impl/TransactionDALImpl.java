package com.installfuturecase.InstallFutureBackendCase.DataAccess.Transaction.Impl;

import com.installfuturecase.InstallFutureBackendCase.DataAccess.Transaction.TransactionDAL;
import com.installfuturecase.InstallFutureBackendCase.Entities.Transactions;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TransactionDALImpl implements TransactionDAL {


    private EntityManager entityManager;

    @Autowired
    public TransactionDALImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public TransactionDALImpl() {
    }


    @Override
    @Transactional
    public List<Transactions> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<Transactions> transactionsList = session.createQuery("from transactions", Transactions.class).getResultList();
        return transactionsList;
    }

    @Override
    @Transactional
    public String add(Transactions transaction) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(transaction);
        return transaction.getTransactiondescription() + " is saved to Database ";
    }

    @Override
    @Transactional
    public String update(Transactions transaction) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(transaction);
        return transaction.getTransactiondescription() + " is updated.";
    }

    @Override
    @Transactional
    public String delete(Transactions transaction) {
        Session session = entityManager.unwrap(Session.class);
        Transactions transactionToDelete = session.get(Transactions.class, transaction.getTransactionID());
        session.delete(transactionToDelete);
        return transaction.getTransactiondescription() + " is deleted.";
    }

    @Override
    @Transactional
    public Transactions getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Transactions transaction = session.get(Transactions.class, id);
        return transaction;
    }


}
