package com.installfuturecase.InstallFutureBackendCase.Service.Transaction;

import com.installfuturecase.InstallFutureBackendCase.Entities.transactions;

import java.util.List;

public interface TransactionService {

    String add(transactions transaction);
    String update(transactions transaction);
    String delete(transactions transaction);
    transactions getById(int id);
    List<transactions> getAll();

}
