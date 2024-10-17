package com.levelvini.biblioteca.service;

import com.levelvini.biblioteca.entities.Livro;
import com.levelvini.biblioteca.exceptions.ResourseNotFoundException;
import com.levelvini.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    LivroRepository livroRepository;

    public List<Livro> buscartodos(){
        return livroRepository.findAll();
    }

    public Livro buscarPorId(Long id){
        return livroRepository.findById(id).orElseThrow(()->new ResourseNotFoundException("Livro não encontrado!!"));
    }
    public Livro save(Livro livro){
        return livroRepository.save(livro);
    }

    public Livro atualizar(Long id, Livro livroAtualizado) {
        Livro livro = buscarPorId(id);
        livro.setName(livroAtualizado.getName());
        livro.setAutor(livroAtualizado.getAutor());
        livro.setCategoria(livroAtualizado.getCategoria());
        return livroRepository.save(livro);
    }

    public void deletar(Long id) {
        Livro livro = buscarPorId(id);
        livroRepository.delete(livro);
    }
}
