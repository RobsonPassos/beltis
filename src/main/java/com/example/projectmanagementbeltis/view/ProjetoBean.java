package com.example.projectmanagementbeltis.view;

import com.example.projectmanagementbeltis.model.Projeto;
import com.example.projectmanagementbeltis.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class ProjetoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private ProjetoService projetoService;

    private List<Projeto> projetos;
    private Projeto projeto;

    @PostConstruct
    public void init() {
        projetos = projetoService.listarTodos();
        projeto = new Projeto();
    }

    public String salvar() {
        try {
            projetoService.salvar(projeto);
            projeto = new Projeto();
            projetos = projetoService.listarTodos();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Projeto salvo com sucesso!"));

            return "listarProjeto";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar o projeto", e.getMessage()));
            return null;
        }
    }

    public String editar(Long id) {
        setProjeto(projetoService.encontrarPorId(id));
        return "editarProjeto";
    }

    public String excluir(Long id) {
        try {
            projetoService.remover(id);
            projetos = projetoService.listarTodos();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Projeto excluído com sucesso!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao excluir o projeto", e.getMessage()));
        }
        return "listarProjeto";
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
}
