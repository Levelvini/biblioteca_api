package com.levelvini.biblioteca.controller;

import com.levelvini.biblioteca.service.Autorservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AutorController {

    @Autowired
    Autorservice autorservice = new Autorservice();
}
