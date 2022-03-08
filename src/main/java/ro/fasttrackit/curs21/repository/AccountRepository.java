package ro.fasttrackit.curs21.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.curs21.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
