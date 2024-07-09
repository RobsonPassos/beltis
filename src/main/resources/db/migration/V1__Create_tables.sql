CREATE TABLE projeto (
                         id SERIAL PRIMARY KEY,
                         titulo VARCHAR(255) NOT NULL,
                         descricao TEXT,
                         data_inicio DATE
);

CREATE TABLE tarefa (
                        id SERIAL PRIMARY KEY,
                        titulo VARCHAR(255) NOT NULL,
                        descricao TEXT,
                        estimativa_horas INT,
                        prioridade VARCHAR(50),
                        projeto_id INT REFERENCES projeto(id)
);
