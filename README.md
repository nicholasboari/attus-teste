# Attus Gerenciamento de Pessoas

## Diagrama UML

![UML.png](UML.png)

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.2.5
- Spring Data
- Dockerfile
- Docker Compose
- Swagger
- H2 Database

## Instalação

1. Clone o repositório:

   ```bash
   git clone git@github.com:nicholasboari/attus-teste.git
   
2. Entre no diretório do projeto:
    ```bash
   cd attus-teste
   
3. Inicie com Docker Compose
   ```bash
   docker compose up

Obs: O projeto é executado na porta 8080.

## Banco de dados

O banco de dados H2 é um banco em memória, para ter visualizar o sgbd acesse:
   ```bash
      http://localhost:8080/h2
```
Não é necessário senha.

## Cobertura de Testes
![TestCoverage.png](TestCoverage.png)

## Requisições

O arquivo Attus.postman_collection.json disponibiliza os endpoints do projeto.

## Documentação

![Swagger.png](Swagger.png)

# Autor

**Nome do Autor:** Nicholas Boari

**Contato:**
- E-mail: nicholasboari@gmail.com
- LinkedIn: https://www.linkedin.com/in/nicholasboari/
- GitHub: https://github.com/nicholasboari
