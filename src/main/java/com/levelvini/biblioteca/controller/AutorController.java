package com.levelvini.biblioteca.controller;

import com.levelvini.biblioteca.entities.Autor;
import com.levelvini.biblioteca.exceptions.ResourseNotFoundException;
import com.levelvini.biblioteca.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/autor")
public class AutorController {

    @Autowired
    AutorService autorService;

    public List<Autor> takeAllAuthors(){
        List<Autor> autor = autorService.buscartodos();
        if (autor == null || autor.isEmpty()){
            throw new ResourseNotFoundException("ainda não existem autores cadastrados");
        } return autor;
    }

    @GetMapping(value = "/{id}")
    public Autor takeById(@PathVariable Long id){
    return autorService.buscarPorId(id);
    }

    public ResponseEntity<Autor> save(@RequestBody Autor autor){
        Autor novoAutor = autorService.save(autor);
        return ResponseEntity.status(HttpStatus.CREATED).body(autor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> authorUpdate(@PathVariable Long id, @RequestBody Autor autorAtualizado){
        Autor autor = autorService.buscarPorId(id);
        return ResponseEntity.ok(autor);
    }

    public ResponseEntity<Void> delete(@PathVariable Long id){
        autorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
