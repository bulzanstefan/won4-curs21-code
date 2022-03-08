package ro.fasttrackit.curs21.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.curs21.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
