package com.levelvini.biblioteca.controller;

import com.levelvini.biblioteca.entities.Categoria;
import com.levelvini.biblioteca.exceptions.ResourseNotFoundException;
import com.levelvini.biblioteca.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value ="/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> takeAll(){
        List<Categoria> categorias = categoriaService.buscartodos();
       if (categorias == null || categorias.isEmpty()){
           throw new ResourseNotFoundException("sem categorias cadastradas");
       }
       return categorias;
    }

    @GetMapping(value = "/{id}")
    public Categoria takeByid(@PathVariable Long id){
        return categoriaService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Categoria> save(@RequestBody Categoria novaCategoria){
    Categoria categoria = categoriaService.save(novaCategoria);
    return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Categoria> categoriaUpdate(@PathVariable Long id,@RequestBody Categoria categoriaAtualizada){
        Categoria categoria = categoriaService.atualizar(id,categoriaAtualizada);
        return ResponseEntity.ok(categoria);
    }

    public ResponseEntity<Void> delete(@PathVariable Long id){
        categoriaService.deletar(id);
        return ResponseEntity.noContent().build();
    }


}
