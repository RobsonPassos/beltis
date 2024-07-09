package com.example.projectmanagementbeltis.controller;

import com.example.projectmanagementbeltis.model.Projeto;
import com.example.projectmanagementbeltis.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public List<Projeto> listarProjetos() {
        return projetoService.listarTodos();
    }

    @PostMapping
    public void adicionarProjeto(@RequestBody Projeto projeto) {
        projetoService.salvar(projeto);
    }

    @PutMapping("/{id}")
    public void editarProjeto(@PathVariable Long id, @RequestBody Projeto projeto) {
        projeto.setId(id);
        projetoService.atualizar(projeto);
    }

    @DeleteMapping("/{id}")
    public void excluirProjeto(@PathVariable Long id) {
        projetoService.remover(id);
    }

    @GetMapping("/{id}")
    public Projeto obterProjeto(@PathVariable Long id) {
        return projetoService.encontrarPorId(id);
    }
}
