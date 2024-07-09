package com.example.projectmanagementbeltis.model;

public enum Prioridade {
    MUITO_ALTA("Muito Alta"),
    ALTA("Alta"),
    MEDIA("Média"),
    BAIXA("Baixa"),
    MUITO_BAIXA("Muito Baixa");

    private String label;

    Prioridade(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
