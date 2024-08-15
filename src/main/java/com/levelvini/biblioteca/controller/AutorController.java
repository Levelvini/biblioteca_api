package com.levelvini.biblioteca.controller;

import com.levelvini.biblioteca.domain.Autor;
import com.levelvini.biblioteca.service.Autorservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(name = "/autor")
public class AutorController {

    @Autowired
    Autorservice autorService = new Autorservice();

    @GetMapping
    public List<Autor> listarTodos() {
        return autorService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscarPorId(@PathVariable Integer id) {
        AutorController livroService;
        return autorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Autor salvar(@RequestBody Autor autor) {
        return autorService.salvar(autor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarPorId(@PathVariable Integer id) {
        AutorController livroService;
        return autorService.buscarPorId(id).map(livro -> {
            autorService.deletarPorId(id);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
