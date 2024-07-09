package com.example.projectmanagementbeltis.controller;

import com.example.projectmanagementbeltis.model.Tarefa;
import com.example.projectmanagementbeltis.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public List<Tarefa> listarTarefas() {
        return tarefaService.listarTodos();
    }

    @PostMapping
    public void adicionarTarefa(@RequestBody Tarefa tarefa) {
        tarefaService.salvar(tarefa);
    }

    @PutMapping("/{id}")
    public void editarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        tarefa.setId(id);
        tarefaService.atualizar(tarefa);
    }

    @DeleteMapping("/{id}")
    public void excluirTarefa(@PathVariable Long id) {
        tarefaService.remover(id);
    }

    @GetMapping("/{id}")
    public Tarefa obterTarefa(@PathVariable Long id) {
        return tarefaService.encontrarPorId(id);
    }
}
