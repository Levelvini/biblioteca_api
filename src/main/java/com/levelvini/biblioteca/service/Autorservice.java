package com.levelvini.biblioteca.service;

import com.levelvini.biblioteca.domain.Autor;
import com.levelvini.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Autorservice {

    @Autowired
    private AutorRepository autorRepository;


    public List<Autor> listarTodos() {
        return autorRepository.findAll();
    }

    public Optional<Autor> buscarPorId(Integer id) {
        return autorRepository.findById(id);
    }

    public Autor salvar(Autor autor) {
        return autorRepository.save(autor);
    }

    public void deletarPorId(Integer id) {
        autorRepository.deleteById(id);
    }
}
