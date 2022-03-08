package ro.fasttrackit.curs21.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.curs21.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
