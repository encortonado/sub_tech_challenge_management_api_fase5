# 🚗 Sistema de Cadastro de Veículos - Tech Challenge

Este projeto é uma aplicação desenvolvida em **Spring Boot** com **Java** e **Maven**. O sistema implementa funcionalidades de cadastro de veículos, com o objetivo de atender à Avaliação Substitutiva de Fase do Tech Challenge da FIAP.

## 📑 Índice

1. [📋 Sobre o Projeto](#-sobre-o-projeto)
   - [🛠️ Tecnologias Utilizadas](#-tecnologias-utilizadas)
4. [🗂 Pré-requisitos](#-pré-requisitos)
5. [🔧 Estrutura do Projeto](#-estrutura-do-projeto)
6. [🚀 Como Executar a Aplicação](#-como-executar-a-aplicação)
7. [🧪 Testes](#-executando-os-testes)
   - [Como Executar os Testes](#para-rodar-os-testes)
8. [🔗 Endpoints da API](#-endpoints-da-api)
   - [🚗 Veículos](#-veículos)
   - [🛒 Compra de Automóvel](#-compra-de-automóvel)
9. [📚 Referências e Recursos Úteis](#-referências-e-recursos-úteis)



## 📋 Sobre o Projeto

A aplicação oferece uma API para cadastro de veículos e clientes, além de funcionalidades relacionadas à venda de veículos. A estrutura foi projetada para ser escalável e de fácil manutenção, utilizando as melhores práticas de desenvolvimento em **Spring Boot** e integração contínua.

### 🛠️ Tecnologias Utilizadas

- **Java** (JDK 17)
- **Spring Boot**
- **Maven**
- **JUnit** (Testes Unitários)
- **Docker** & **Docker Compose**

## 🛠 Pré-requisitos

### Para rodar o projeto:
- **Docker**
- **Docker Compose**

### Para desenvolvimento:
- **JDK 17**
- **Docker**
- **Docker Compose**
- **Maven**

## 📁 Estrutura do Projeto

- `src/main/java`: Contém o código-fonte da aplicação.
- `src/test/java`: Contém as classes de testes unitários.

## 🚀 Como Executar a Aplicação

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/encortonado/sub_tech_challenge_management_api_fase4.git
   ```

2. **Rode os Comandos abaixo para executar** o banco de dados localmente:
   ```bash
   ./run-sh db
   ```

   ps. Caso for rodar as duas aplicações simultaneamente, rode apenas uma instância de banco de dados

3. **Execute a aplicação** localmente:
   ```bash
   ./run-sh app
   ```


## 🧪 Executando os Testes

Os testes unitários seguem as boas práticas de **Test-Driven Development (TDD)** e estão organizados para garantir a consistência das funcionalidades da aplicação.

### Para rodar os testes:

1. Na pasta raiz do projeto, execute:
   ```bash
   mvn test
   ```

## 🔗 Endpoints da API

A aplicação expõe os seguintes endpoints para cadastro e venda de veículos:

### 🚗 Veículos

- **GET /api/vehicle**  
  Retorna a lista de veículos disponíveis para venda, ordenados por preço (do menor para o maior).

- **POST /api/vehicle**  
  Cadastra um novo veículo para venda.  
  **Body (JSON):**
  ```json
  {
    "brand": "Toyota",
    "model": "Corolla",
    "color": "White",
    "year": 2021,
    "price": 85000.00
  }

- **PUT /api/vehicle**  
  Atualiza um veículo para venda.  
  **Body (JSON):**
  ```json
  {
    "brand": "Toyota",
    "model": "Corolla",
    "color": "White",
    "year": 2021,
    "price": 85000.00
  }


## 📚 Referências e Recursos Úteis

- [Collection Postman](./Tech%20Challenge%20Fase%204.postman_collection.json)
- [Documentação oficial do Spring](https://docs.spring.io)
- [Jakarta Bean Validations](https://beanvalidation.org/)
- [Cucumber](https://cucumber.io)
- [AssertJ](https://assertj.github.io/doc/)
- [RestAssured](https://rest-assured.io/)
- [JSON Schema](https://jsonschema.net/app/schemas/390701)

---

Este README foi criado para fins acadêmicos como parte da Avaliação Substitutiva de Fase do curso de Pós-Graduação em Tech da **FIAP**.

--- 

