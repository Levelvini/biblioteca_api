package com.levelvini.biblioteca.controller;

import com.levelvini.biblioteca.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService = new CategoriaService();
}
