package com.levelvini.biblioteca.repository;

import com.levelvini.biblioteca.domain.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor,Integer> {
}
