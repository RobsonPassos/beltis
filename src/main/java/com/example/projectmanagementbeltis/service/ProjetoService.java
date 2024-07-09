package com.example.projectmanagementbeltis.service;

import com.example.projectmanagementbeltis.dao.ProjetoDAO;
import com.example.projectmanagementbeltis.model.Projeto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoDAO projetoDAO;

    @Transactional
    public void salvar(Projeto projeto) {
        if (projeto.getId() == null) {
            projetoDAO.salvar(projeto);
        } else {
            projetoDAO.atualizar(projeto);
        }
    }

    @Transactional
    public void atualizar(Projeto projeto) {
        projetoDAO.atualizar(projeto);
    }

    @Transactional
    public void remover(Long id) {
        projetoDAO.remover(id);
    }

    @Transactional(readOnly = true)
    public Projeto encontrarPorId(Long id) {
        return projetoDAO.encontrarPorId(id);
    }

    @Transactional(readOnly = true)
    public List<Projeto> listarTodos() {
        return projetoDAO.listarTodos();
    }
}
