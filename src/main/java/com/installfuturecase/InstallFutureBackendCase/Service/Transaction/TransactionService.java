package com.installfuturecase.InstallFutureBackendCase.Service.Transaction;

import com.installfuturecase.InstallFutureBackendCase.Entities.Transactions;

import java.util.List;

public interface TransactionService {

    String add(Transactions transaction);
    String update(Transactions transaction);
    String delete(Transactions transaction);
    Transactions getById(int id);
    List<Transactions> getAll();

}
