package com.installfuturecase.InstallFutureBackendCase.Controller.Transaction;

import com.installfuturecase.InstallFutureBackendCase.DataAccess.TransactionCalculationRepository.TransactionRepository;
import com.installfuturecase.InstallFutureBackendCase.Entities.transactions;
import com.installfuturecase.InstallFutureBackendCase.Service.Transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private TransactionService transactionService;

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionController(TransactionService transactionService, TransactionRepository transactionRepository){
        this.transactionService = transactionService;
        this.transactionRepository = transactionRepository;
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