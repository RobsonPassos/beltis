package com.example.projectmanagementbeltis.dao;

import com.example.projectmanagementbeltis.model.Projeto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProjetoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void salvar(Projeto projeto) {
        entityManager.persist(projeto);
    }

    public void atualizar(Projeto projeto) {
        entityManager.merge(projeto);
    }

    public void remover(Long id) {
        Projeto projeto = entityManager.find(Projeto.class, id);
        if (projeto != null) {
            entityManager.remove(projeto);
        }
    }

    public Projeto encontrarPorId(Long id) {
        return entityManager.find(Projeto.class, id);
    }

    public List<Projeto> listarTodos() {
        return entityManager.createQuery("FROM Projeto", Projeto.class).getResultList();
    }
}
