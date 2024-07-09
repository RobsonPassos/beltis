package com.example.projectmanagementbeltis.service;

import com.example.projectmanagementbeltis.dao.TarefaDAO;
import com.example.projectmanagementbeltis.model.Tarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaDAO tarefaDAO;


    @Transactional
    public void salvar(Tarefa tarefa) {
        if (tarefa.getId() == null) {
            tarefaDAO.salvar(tarefa);
        } else {
            tarefaDAO.atualizar(tarefa);
        }
    }

    @Transactional
    public void atualizar(Tarefa tarefa) {
        tarefaDAO.atualizar(tarefa);
    }

    @Transactional
    public void remover(Long id) {
        tarefaDAO.remover(id);
    }

    @Transactional(readOnly = true)
    public Tarefa encontrarPorId(Long id) {
        return tarefaDAO.encontrarPorId(id);
    }

    @Transactional(readOnly = true)
    public List<Tarefa> listarTodos() {
        return tarefaDAO.listarTodos();
    }
}
