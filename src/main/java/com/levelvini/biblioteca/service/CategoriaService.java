package com.levelvini.biblioteca.service;

import com.levelvini.biblioteca.entities.Categoria;
import com.levelvini.biblioteca.exceptions.ResourseNotFoundException;
import com.levelvini.biblioteca.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public List<Categoria> buscartodos(){
        return categoriaRepository.findAll();
    }

    public Categoria buscarPorId(Long id){
        return categoriaRepository.findById(id).orElseThrow(()->new ResourseNotFoundException("Livro não encontrado!!"));
    }
    public Categoria save(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public Categoria atualizar(Long id, Categoria categoriaAtualizado) {
        Categoria categoria = buscarPorId(id);
        categoria.setName(categoriaAtualizado.getName());
        return categoriaRepository.save(categoria);
    }

    public void deletar(Long id) {
        Categoria categoria = buscarPorId(id);
        categoriaRepository.delete(categoria);
    }
}
