package ro.fasttrackit.curs21.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.curs21.model.Approval;

public interface ApprovalRepository extends JpaRepository<Approval, Integer> {
}
