package com.installfuturecase.InstallFutureBackendCase.DataAccess.Transaction.Impl;

import com.installfuturecase.InstallFutureBackendCase.DataAccess.Transaction.TransactionDAL;
import com.installfuturecase.InstallFutureBackendCase.Entities.transactions;
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
    public TransactionDALImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public TransactionDALImpl() {
    }


    @Override
    @Transactional
    public List<transactions> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<transactions> transactionsList = session.createQuery("from transactions", com.installfuturecase.InstallFutureBackendCase.Entities.transactions.class).getResultList();
        return transactionsList;
    }

    @Override
    @Transactional
    public String add(transactions transaction) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(transaction);
        return transaction.getTransactiondescription()+" is saved to Database ";
    }

    @Override
    @Transactional
    public String update(transactions transaction) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(transaction);
        return transaction.getTransactiondescription()+" is updated.";
    }

    @Override
    @Transactional
    public String delete(transactions transaction) {
        Session session = entityManager.unwrap(Session.class);
        transactions transactionToDelete = session.get(transactions.class, transaction.getTransactionID());
        session.delete(transactionToDelete);
        return transaction.getTransactiondescription()+" is deleted.";
    }
    @Override
    @Transactional
    public transactions getById(int id) {
        Session session =  entityManager.unwrap(Session.class);
        transactions transaction = session.get(transactions.class, id);
        return transaction;
    }
}
