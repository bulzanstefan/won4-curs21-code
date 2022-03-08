package ro.fasttrackit.curs21.controller;

import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.curs21.model.Transaction;
import ro.fasttrackit.curs21.service.TransactionService;

import java.util.List;

@RestController
@RequestMapping("transactions")
public class TransactionController {
    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @GetMapping
    List<Transaction> getTransactions() {
        return service.getTransactions();
    }

    @PutMapping("{id}")
    Transaction replaceTransaction(@PathVariable int id, @RequestBody Transaction transaction) {
        return service.replace(id, transaction)
                .orElseThrow(() -> new RuntimeException("Could not find transaction with id %s".formatted(id)));
    }

    @PatchMapping("{id}")
    Transaction patchTransaction(@PathVariable int id, @RequestBody Transaction transaction) {
        return service.patch(id, transaction)
                .orElseThrow(() -> new RuntimeException("Could not find transaction with id %s".formatted(id)));
    }
}
