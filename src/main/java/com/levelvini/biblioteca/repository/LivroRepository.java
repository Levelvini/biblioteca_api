package com.levelvini.biblioteca.repository;

import com.levelvini.biblioteca.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro,Long>{
    /*
    @Override
    Optional<Livro> findById(Long aLong);
     */
}
