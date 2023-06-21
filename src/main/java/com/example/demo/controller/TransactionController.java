package com.example.demo.controller;

import com.example.demo.model.Transaction;
import com.example.demo.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("/*")
@RestController
public class TransactionController {

    @Autowired
    TransactionRepo transactionRepo;

    @GetMapping("/transaction")
    public List<Transaction> getTransactionList() {
        return transactionRepo.findAll();
    }

    @GetMapping("/transaction/{transactionId}")
    public Optional<Transaction> getTransactionById(@PathVariable(name = "transactionId") Long id) {
        return transactionRepo.findById(id);
    }

    @PostMapping("/transaction")
    public Transaction saveTransaction(@RequestBody Transaction Transaction) {
        return transactionRepo.save(Transaction);
    }

    @DeleteMapping("/transaction/{transactionId}")
    public void deleteTransaction(@PathVariable(name = "transactionId") Long id) {
        transactionRepo.deleteById(id);
    }
}
