package mybank_be.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mybank_be.rest.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    // ...
}
