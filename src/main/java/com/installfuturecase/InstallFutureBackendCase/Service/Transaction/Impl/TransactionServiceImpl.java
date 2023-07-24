package com.installfuturecase.InstallFutureBackendCase.Service.Transaction.Impl;

import com.installfuturecase.InstallFutureBackendCase.DataAccess.Transaction.TransactionDAL;
import com.installfuturecase.InstallFutureBackendCase.DataAccess.TransactionCalculationRepository.TransactionRepository;
import com.installfuturecase.InstallFutureBackendCase.Entities.Transactions;
import com.installfuturecase.InstallFutureBackendCase.Service.Transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionDAL transactionDAL;
    private TransactionRepository  transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionDAL transactionDAL){
        this.transactionDAL = transactionDAL;
    }

    @Override
    public String add(Transactions transaction) {
        return this.transactionDAL.add(transaction);
    }

    @Override
    public String update(Transactions transaction) {
        return this.transactionDAL.update(transaction);
    }

    @Override
    public String delete(Transactions transaction) {
        return this.transactionDAL.delete(transaction);
    }

    @Override
    public Transactions getById(int id) {
        return this.transactionDAL.getById(id);
    }

    @Override
    public List<Transactions> getAll() {
        return this.transactionDAL.getAll();
    }


}
