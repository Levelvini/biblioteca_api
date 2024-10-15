package com.levelvini.biblioteca.service;

import com.levelvini.biblioteca.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CateroriaService {

    @Autowired
    CategoriaRepository categoriaRepository;
}
