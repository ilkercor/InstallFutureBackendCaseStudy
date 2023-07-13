package com.installfuturecase.InstallFutureBackendCase.DataAccess.Transaction;

import com.installfuturecase.InstallFutureBackendCase.Entities.transactions;

import java.util.List;

public interface TransactionDAL {

    String add(transactions transaction);
    String update(transactions transaction);
    String delete(transactions transaction);
    transactions getById(int id);
    List<transactions> getAll();
}
