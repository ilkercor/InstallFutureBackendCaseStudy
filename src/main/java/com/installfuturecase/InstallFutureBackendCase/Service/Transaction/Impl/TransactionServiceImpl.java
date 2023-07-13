package com.installfuturecase.InstallFutureBackendCase.Service.Transaction.Impl;

import com.installfuturecase.InstallFutureBackendCase.DataAccess.Transaction.TransactionDAL;
import com.installfuturecase.InstallFutureBackendCase.Entities.transactions;
import com.installfuturecase.InstallFutureBackendCase.Service.Transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionDAL transactionDAL;

    @Autowired
    public TransactionServiceImpl(TransactionDAL transactionDAL){
        this.transactionDAL = transactionDAL;
    }

    @Override
    public String add(transactions transaction) {
        return this.transactionDAL.add(transaction);
    }

    @Override
    public String update(transactions transaction) {
        return this.transactionDAL.update(transaction);
    }

    @Override
    public String delete(transactions transaction) {
        return this.transactionDAL.delete(transaction);
    }

    @Override
    public transactions getById(int id) {
        return this.transactionDAL.getById(id);
    }

    @Override
    public List<transactions> getAll() {
        return this.transactionDAL.getAll();
    }
}
