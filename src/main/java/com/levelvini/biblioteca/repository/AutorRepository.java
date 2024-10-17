package com.levelvini.biblioteca.repository;

import com.levelvini.biblioteca.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor,Long> {
}
