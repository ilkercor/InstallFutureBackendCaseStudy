package com.installfuturecase.InstallFutureBackendCase.Controller.Transaction;

import com.installfuturecase.InstallFutureBackendCase.Entities.transactions;
import com.installfuturecase.InstallFutureBackendCase.Service.Transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @GetMapping("/list")
    public List<transactions> get(){
        return transactionService.getAll();
    }

    @PostMapping("/add")
    public String add(@RequestBody transactions transaction){
        return transactionService.add(transaction);
    }

    @PostMapping("/update")
    public String update(@RequestBody transactions transaction){
        return transactionService.update(transaction);
    }

    @PostMapping("/delete")
    public String delete(@RequestBody transactions transaction){
        return transactionService.delete(transaction);
    }

    @GetMapping("/{id}")
    public transactions getByID(@PathVariable int id){
        return transactionService.getById(id);
    }

}