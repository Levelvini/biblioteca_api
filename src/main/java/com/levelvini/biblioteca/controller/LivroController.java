package com.levelvini.biblioteca.controller;

import com.levelvini.biblioteca.entities.Livro;
import com.levelvini.biblioteca.exceptions.ResourseNotFoundException;
import com.levelvini.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/livro")
public class LivroController {

    @Autowired
    LivroService livroService;

    @GetMapping
    private List<Livro> takeAllBooks(){
        List<Livro> list = livroService.buscartodos();
        if (list == null || list.isEmpty()){
            throw new ResourseNotFoundException("ainda não existem livros cadastrados");
        }
        return list;
    }

    @GetMapping(value = "/{id}")
    private Livro takeById(@PathVariable Long id){
        return livroService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Livro> save(@RequestBody Livro livro) {
        Livro novoLivro = livroService.save(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoLivro);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Livro> bookUpdate(@PathVariable Long id, @RequestBody Livro livroAtualizado) {
        Livro livro = livroService.atualizar(id, livroAtualizado);
        return ResponseEntity.ok(livro);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
