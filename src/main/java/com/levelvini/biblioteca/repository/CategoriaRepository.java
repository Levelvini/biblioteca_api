package com.levelvini.biblioteca.repository;

import com.levelvini.biblioteca.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
}
