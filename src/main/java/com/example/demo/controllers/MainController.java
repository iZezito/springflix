package com.example.demo.controllers;

import com.example.demo.model.Filme;
import com.example.demo.model.Usuario;
import com.example.demo.service.FilmeService;
import org.jboss.jandex.Main;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {

    public FilmeService filmeService;

    public MainController(FilmeService filmeService){
        this.filmeService = filmeService;
    }

    @GetMapping(value = {"/", "/home"})
    public String doHome(Model model){
        List<Filme> filmes = filmeService.findAll();
        model.addAttribute("listFilmes", filmes);
        return "index";

    }
    @GetMapping("/cadastrar")
    public String doCadastrar(Model model){
        Filme filme = new Filme();
        model.addAttribute("filme", filme);

        return "cadastrar";

    }

    @PostMapping("/salvar")
    public String doSalvar(@ModelAttribute @Valid Filme filme, Errors errors){
        if(errors.hasErrors()){
            return "cadastrar";

        }else{
            filmeService.insert(filme);
            return "redirect:/";
        }
    }
    @GetMapping("/deletar/{id}")
    public String doDeletar(@PathVariable(name = "id") Long id){
        filmeService.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping("/editar/{id}")
    public String doEditar(@PathVariable (name = "id") Long id, Model model){

        Filme f = filmeService.findById(id);
        model.addAttribute("filme", f);
        return "cadastrar";
    }
}
