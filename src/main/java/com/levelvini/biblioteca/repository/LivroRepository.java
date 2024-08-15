package com.levelvini.biblioteca.repository;

import com.levelvini.biblioteca.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro,Integer> {
}
