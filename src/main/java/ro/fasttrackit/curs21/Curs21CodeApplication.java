package ro.fasttrackit.curs21;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.curs21.model.*;
import ro.fasttrackit.curs21.repository.AccountRepository;
import ro.fasttrackit.curs21.repository.ApprovalRepository;
import ro.fasttrackit.curs21.repository.CategoryRepository;
import ro.fasttrackit.curs21.repository.TransactionRepository;

import java.util.List;

import static ro.fasttrackit.curs21.model.TransactionType.BUY;
import static ro.fasttrackit.curs21.model.TransactionType.SELL;

@SpringBootApplication
public class Curs21CodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(Curs21CodeApplication.class, args);
    }

    @Bean
    CommandLineRunner atStartup(TransactionRepository repository,
                                ApprovalRepository approvalRepository,
                                AccountRepository accountRepository,
                                CategoryRepository categoryRepository) {
        return args -> {

            Category haine = categoryRepository.save(new Category("haine"));
            Category discount = categoryRepository.save(new Category("discount"));
            Category online = categoryRepository.save(new Category("online"));
            Account economii = accountRepository.save(new Account("economii", "bani de economisit"));
            Account curent = accountRepository.save(new Account("curent", "cont curent"));

            Approval ceaiApprove = approvalRepository.save(new Approval("Ana", "ceaiu-i bun"));
            Approval pixApprove = approvalRepository.save(new Approval("Mihai", "good price"));
            repository.saveAll(List.of(
                    new Transaction(curent, "ceai", BUY, 210, ceaiApprove)
                    , new Transaction(economii, "lavanda", SELL, 13, null, List.of(
                            new Note("Ana", "miroase bine")
                            , new Note("Beni", "pret bun")
                            , new Note("Cosmin", "ok")),
                            List.of(haine, discount, online))
                    , new Transaction(curent, "monitor", BUY, 50)
                    , new Transaction(curent, "pix", SELL, 240, pixApprove, List.of(), List.of(discount, online))
                    , new Transaction(economii, "apa", BUY, 21)
            ));

        };
    }
}