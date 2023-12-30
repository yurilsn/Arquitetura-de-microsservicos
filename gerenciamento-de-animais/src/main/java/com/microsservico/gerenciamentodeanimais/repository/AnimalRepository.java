package com.microsservico.gerenciamentodeanimais.repository;

import com.microsservico.gerenciamentodeanimais.domain.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
