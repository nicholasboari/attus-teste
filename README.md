# Attus Gerenciamento de Pessoas

Este é um projeto back-end para gerenciamento de pessoas, como inserção, edição e atualização de dados.

### Sobre

O projeto foi desenvolvido no ambiente do Spring com Java, e para armazenamento dos dados, foi utilizado H2 database (em memória). Para simplificar a execução do projeto, foi criado um Dockerfile e um arquivo de configuração Docker compose.

## 📐 Diagrama UML

![UML.png](UML.png)

## 🛠️ Tecnologias Utilizadas

- Java 17
- Maven 3.9.6
- Spring Boot 3.2.5
- Spring Data
- Dockerfile
- Docker Compose
- Swagger
- H2 Database

## 🚀 Instalação

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

## 💿 Banco de dados

O banco de dados H2 é um banco em memória, para ter visualizar o sgbd acesse:
   ```bash
      http://localhost:8080/h2
```
Não é necessário senha.

## 🧪 Cobertura de Testes
![TestCoverage.png](TestCoverage.png)

## 🌐 Requisições

O arquivo Attus.postman_collection.json disponibiliza os endpoints do projeto.

- Criação de Pessoa:

![image](https://github.com/nicholasboari/attus-teste/assets/44304317/6f45116b-dc7b-4b79-982e-c51e9170cdb3)

- Criação de Endereço:

![image](https://github.com/nicholasboari/attus-teste/assets/44304317/0cc90b99-52fd-4a54-9aa4-78817079c295)

- Retorno de Endereços de uma Pessoa:

![image](https://github.com/nicholasboari/attus-teste/assets/44304317/5f8c0cd2-4db6-497c-9164-156a7efef464)

- Retorno de uma Pessoa cadastrada no sistema:

![image](https://github.com/nicholasboari/attus-teste/assets/44304317/680f2702-bc47-4ec5-bbec-b8a7bba94816)



## 📖 Documentação

![Swagger.png](Swagger.png)

# Autor

**Nome do Autor:** Nicholas Boari

**Contato:**
- E-mail: nicholasboari@gmail.com
- LinkedIn: https://www.linkedin.com/in/nicholasboari/
- GitHub: https://github.com/nicholasboari
