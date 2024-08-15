package com.levelvini.biblioteca.controller;

import com.levelvini.biblioteca.domain.Categoria;
import com.levelvini.biblioteca.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(name = "/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService = new CategoriaService();

    @GetMapping
    public List<Categoria> listarTodos() {
        return categoriaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Integer id) {
        return categoriaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Categoria salvar(@RequestBody Categoria categoria) {
        return categoriaService.salvar(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarPorId(@PathVariable Integer id) {
        return categoriaService.buscarPorId(id).map(livro -> {
            categoriaService.deletarPorId(id);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
