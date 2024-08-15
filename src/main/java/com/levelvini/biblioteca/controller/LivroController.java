package com.levelvini.biblioteca.controller;

import com.levelvini.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LivroController {

    @Autowired
    LivroService livroService = new LivroService();
}
