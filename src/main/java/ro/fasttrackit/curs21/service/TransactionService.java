package ro.fasttrackit.curs21.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.curs21.model.Transaction;
import ro.fasttrackit.curs21.repository.TransactionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<Transaction> getTransactions() {
        return repository.findAll();
    }

    public Optional<Transaction> replace(int id, Transaction transaction) {
        return repository.findById(id)
                .map(dbTransaction -> replaceTransaction(dbTransaction, transaction));
    }

    private Transaction replaceTransaction(Transaction dbTransaction, Transaction transaction) {
        dbTransaction.setAmount(transaction.getAmount());
        dbTransaction.setType(transaction.getType());
        return repository.save(dbTransaction);
    }

    public Optional<Transaction> patch(int id, Transaction transaction) {
        return repository.findById(id)
                .map(dbTransaction -> patchTransaction(dbTransaction, transaction));
    }

    private Transaction patchTransaction(Transaction dbTransaction, Transaction transaction) {
        if (transaction.getAmount() != 0) {
            dbTransaction.setAmount(transaction.getAmount());
        }
        if (transaction.getType() != null) {
            dbTransaction.setType(transaction.getType());
        }

        return repository.save(dbTransaction);
    }

}
