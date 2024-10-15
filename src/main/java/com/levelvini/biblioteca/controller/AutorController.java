package com.levelvini.biblioteca.controller;

import com.levelvini.biblioteca.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AutorController {

    @Autowired
    AutorService autorService;
}
