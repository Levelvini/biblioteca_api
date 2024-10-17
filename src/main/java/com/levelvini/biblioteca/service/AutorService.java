package com.levelvini.biblioteca.service;

import com.levelvini.biblioteca.entities.Autor;
import com.levelvini.biblioteca.exceptions.ResourseNotFoundException;
import com.levelvini.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    AutorRepository autorRepository;

    public List<Autor> buscartodos(){
        return autorRepository.findAll();
    }

    public Autor buscarPorId(Long id){
        return autorRepository.findById(id).orElseThrow(()->new ResourseNotFoundException("autor não encontrado!!"));
    }
    public Autor save(Autor autor){
        return autorRepository.save(autor);
    }

    public Autor atualizar(Long id, Autor autorAtualizado) {
        Autor autor = buscarPorId(id);
        autor.setName(autorAtualizado.getName());
        autor.setName(autorAtualizado.getName());
        autor.setAge(autorAtualizado.getAge());
        return autorRepository.save(autor);
    }

    public void deletar(Long id) {
        Autor autor = buscarPorId(id);
        autorRepository.delete(autor);
    }
}
