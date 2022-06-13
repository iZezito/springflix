package com.example.demo.service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void insert(Usuario usuario){
        userRepository.save(usuario);
    }

    public List<Usuario> findAll(){
        return userRepository.findAll();
    }
    public Usuario findById(Long id){
        Optional<Usuario> usuario = userRepository.findById(id);
        if(usuario.isPresent()){
            return usuario.get();
        }else{
            return null;
        }
    }
    public void update(Usuario usuario){
        userRepository.saveAndFlush(usuario);
    }
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
}
