package com.installfuturecase.InstallFutureBackendCase.DataAccess.Transaction;

import com.installfuturecase.InstallFutureBackendCase.Entities.Transactions;

import java.util.List;

public interface TransactionDAL {

    String add(Transactions transaction);
    String update(Transactions transaction);
    String delete(Transactions transaction);
    Transactions getById(int id);
    List<Transactions> getAll();
}
