package com.example.projectmanagementbeltis.dao;

import com.example.projectmanagementbeltis.model.Tarefa;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TarefaDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void salvar(Tarefa tarefa) {
        entityManager.persist(tarefa);
    }

    public void atualizar(Tarefa tarefa) {
        entityManager.merge(tarefa);
    }

    public void remover(Long id) {
        Tarefa tarefa = entityManager.find(Tarefa.class, id);
        if (tarefa != null) {
            entityManager.remove(tarefa);
        }
    }

    public Tarefa encontrarPorId(Long id) {
        return entityManager.find(Tarefa.class, id);
    }

    public List<Tarefa> listarTodos() {
        String jpql = "SELECT t FROM Tarefa t JOIN FETCH t.projeto";
        TypedQuery<Tarefa> query = entityManager.createQuery(jpql, Tarefa.class);
        return query.getResultList();
    }
}
