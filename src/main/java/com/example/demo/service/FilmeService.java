package com.example.demo.service;

import com.example.demo.model.Filme;
import com.example.demo.repository.FilmeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {


    private FilmeRepository repository;
    public FilmeService(FilmeRepository filmeRepository){
        this.repository = filmeRepository;
    }

    public void insert(Filme filme){
        repository.save(filme);
    }

    public List<Filme> findAll(){
        return repository.findAll();

    }

    public void update(Filme filme){
        repository.saveAndFlush(filme);
    }

    public Filme findById(Long id){
        Optional<Filme> filme = repository.findById(id);
        if(filme.isPresent()){
            return filme.get();
        }else{
            return null;
        }

    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
