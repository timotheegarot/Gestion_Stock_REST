package com.example.demo.repo;

import com.example.demo.model.Product;
import com.example.demo.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo extends JpaRepository <Transaction, Long>{

}
