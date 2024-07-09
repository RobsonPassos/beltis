# Projeto de Gerenciamento de Projetos e Tarefas

Este projeto é uma aplicação web desenvolvida como parte de um desafio técnico para gerenciamento de projetos e tarefas.

## Tecnologias Utilizadas

- **Java Server Faces (JSF):** Utilizado para a camada de apresentação.
- **Spring Boot 2.1.0.RELEASE:** Utilizado para a camada de negócio e injeção de dependência.
- **Java 8**
- **RichFaces 4.5.17.Final:** Componentes ricos para a interface do usuário.
- **WildFly 18.0.1.Final:** Servidor de aplicação utilizado.
- **Hibernate 5.4.21.Final:** Mapeamento objeto-relacional (ORM).
- **PostgreSQL 15:** Banco de dados relacional utilizado.

## Configuração do Banco de Dados

Para criar a base de dados, execute o script localizado em `src/main/resources/db/migration/V1__Create_tables.sql`.

## Execução Local

1. **Clone o repositório do projeto.**
2. **Importe o projeto em sua IDE IntelliJ.**
3. **Crie o banco de dados PostgreSQL.**
4. **Faça o download do WildFly 18.0.1.Final.**
5. **Copie o arquivo `standalone.xml` da raiz do projeto para o caminho do seu servidor de aplicação:**
6. **No diretório `C:\Users\robso\Dev\serverapp\wildfly-18.0.1.Final\modules\system\layers\base\org\postgresql\main`:**
- Faça o download da lib `postgresql-42.3.6.jar` e adicione nesse diretório.
- Crie um arquivo `module.xml` com o seguinte conteúdo:
  ```xml
  <module xmlns="urn:jboss:module:1.9" name="org.postgresql">
    <resources>
      <resource-root path="postgresql-42.3.6.jar"/>
    </resources>
    <dependencies>
      <module name="javax.api"/>
      <module name="javax.transaction.api"/>
    </dependencies>
  </module>
  ```
7. **Configure o WildFly no IntelliJ.**
8. **No terminal do IntelliJ, execute o seguinte comando:**
9. **Faça o build do seu `.war`.**
10. **Execute a aplicação como um aplicativo web.**
11. **Acesse o sistema no navegador:** [http://localhost:8080/project-management-beltis-0.0.1-SNAPSHOT](http://localhost:8080/project-management-beltis-0.0.1-SNAPSHOT)

