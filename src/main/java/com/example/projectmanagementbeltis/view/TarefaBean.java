package com.example.projectmanagementbeltis.view;

import com.example.projectmanagementbeltis.model.Prioridade;
import com.example.projectmanagementbeltis.model.Projeto;
import com.example.projectmanagementbeltis.model.Tarefa;
import com.example.projectmanagementbeltis.service.ProjetoService;
import com.example.projectmanagementbeltis.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@ViewScoped
public class TarefaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private TarefaService tarefaService;
    @Autowired
    private ProjetoService projetoService;

    private List<Tarefa> tarefas;

    private List<Projeto> projetos;
    private Tarefa tarefa;

    @PostConstruct
    public void init() {
        tarefa = new Tarefa();
        tarefa.setProjeto(new Projeto());
        tarefas = tarefaService.listarTodos();
        projetos = projetoService.listarTodos();

    }

    public String salvar() {
        try {
            Projeto projeto = projetoService.encontrarPorId(tarefa.getProjeto().getId());
            tarefa.setProjeto(projeto);
            tarefaService.salvar(tarefa);
            tarefa = new Tarefa();
            tarefas = tarefaService.listarTodos();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tarefa salva com sucesso!"));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar a tarefa", e.getMessage()));
            return null;
        }
        return "listarTarefa";
    }

    public String editar(Long id) {
        setTarefa(tarefaService.encontrarPorId(id));
        return "editarTarefa";
    }

    public String excluir(Long id) {
        try {
            tarefaService.remover(id);
            tarefas = tarefaService.listarTodos();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tarefa excluída com sucesso!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao excluir a tarefa", e.getMessage()));
        }
        return "listarTarefa";
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public List<SelectItem> getPrioridades() {
        return Stream.of(Prioridade.values())
                .map(p -> new SelectItem(p, p.getLabel()))
                .collect(Collectors.toList());
    }

    public List<SelectItem> getProjetosSelectItems() {
        return projetos.stream()
                .map(projeto -> new SelectItem(projeto.getId(), projeto.getTitulo()))
                .collect(Collectors.toList());
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }
    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }
    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }
}
