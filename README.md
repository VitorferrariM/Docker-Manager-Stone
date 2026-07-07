# 🚀 Stone Backend Challenge - Docker Manager API

![Java](https://img.shields.io/badge/Java-21-red?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green?style=for-the-badge&logo=springboot)
![Docker](https://img.shields.io/badge/Docker-API-blue?style=for-the-badge&logo=docker)
![Postman](https://img.shields.io/badge/Postman-Tested-orange?style=for-the-badge&logo=postman)
![Maven](https://img.shields.io/badge/Maven-Build-red?style=for-the-badge&logo=apachemaven)

# 💚 Stone Backend Challenge

Este projeto foi desenvolvido como solução para o **Desafio Backend da Stone**, utilizando **Java + Spring Boot** para criar uma API REST capaz de gerenciar containers Docker através da Docker Engine API.

O objetivo foi desenvolver uma aplicação organizada, escalável e de fácil manutenção, seguindo boas práticas do ecossistema Spring.

---


# 🎯 Objetivo do desafio

Criar uma API que permitisse:

- ✅ Listar containers
- ✅ Listar todos os containers (inclusive parados)
- ✅ Iniciar containers
- ✅ Parar containers
- ✅ Remover containers
- ✅ Comunicação direta com a Docker Engine

Tudo isso através de endpoints REST.

---

# 🛠 Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Web
- Maven
- Docker Java API
- Docker Desktop
- Postman
- IntelliJ IDEA
- Git
- GitHub

---

# 📚 O que aprendi durante esse projeto

Esse projeto foi um divisor de águas no meu aprendizado com Spring Boot.

Durante o desenvolvimento pude aprender diversos conceitos importantes como:

### Spring Boot

- Estruturação de APIs REST
- Controllers
- Services
- Injeção de Dependência
- Configurações com @Configuration
- Beans
- Tratamento de exceções
- Organização em camadas

### Docker

- Docker Engine API
- Docker Java Client
- Containers
- Start
- Stop
- Delete
- Comunicação entre aplicação Java e Docker Desktop

### Desenvolvimento

- Resolução de problemas de compatibilidade entre versões
- Configuração do Docker Client
- Debug
- Testes de endpoints
- Boas práticas de organização do código

---

# 📂 Estrutura do Projeto

```
src
 ├── config
 │     └── DockerClientConfig.java
 │
 ├── controller
 │     └── ContainerController.java
 │
 ├── service
 │     └── DockerService.java
 │
 ├── dto
 │
 ├── model
 │
 └── DockerManagerApplication.java
```

---

# ⚙ Como executar o projeto

## 1 Clone o repositório

```bash
git clone https://github.com/SEU-USUARIO/docker-manager-api.git
```

---

## 2 Entre na pasta

```bash
cd docker-manager-api
```

---

## 3 Abra o Docker Desktop

Antes de iniciar a aplicação, certifique-se de que o Docker Desktop está em execução.

Verifique:

```
docker ps
```

Se listar seus containers, está tudo certo.

---

## 4 Execute a aplicação

Pelo IntelliJ:

```
Run DockerManagerApplication
```

ou

```bash
mvn spring-boot:run
```

---

# 🚀 Endpoints

## Listar containers ativos

```
GET /api/containers
```

---

## Listar todos os containers

```
GET /api/containers?showAll=true
```

---

## Iniciar container

```
POST /api/containers/{id}/start
```

---

## Parar container

```
POST /api/containers/{id}/stop
```

---

## Remover container

```
DELETE /api/containers/{id}
```

---

# 🧪 Testando com Postman

Exemplo:

```
GET

http://localhost:8080/api/containers
```

ou

```
GET

http://localhost:8080/api/containers?showAll=true
```

Iniciar um container

```
POST

http://localhost:8080/api/containers/{id}/start
```

Parar

```
POST

http://localhost:8080/api/containers/{id}/stop
```

Excluir

```
DELETE

http://localhost:8080/api/containers/{id}
```

---

# 💡 Principais desafios encontrados

Durante o desenvolvimento encontrei alguns problemas interessantes que me ajudaram a aprender bastante.

- Compatibilidade entre versões da Docker Java API
- Configuração do DockerClient
- Integração entre Spring Boot e Docker Desktop
- Tratamento de erros HTTP
- Diferença entre containers ativos e todos os containers
- Ajustes na comunicação utilizando Named Pipes no Windows

Esses desafios foram fundamentais para entender melhor como aplicações Java podem se comunicar com serviços externos.

---

# 📈 Próximos passos

Algumas melhorias que pretendo implementar:

- Autenticação com Spring Security
- Testes Unitários (JUnit + Mockito)
- Documentação com Swagger/OpenAPI
- Logs utilizando SLF4J
- Tratamento global de exceções
- Docker Compose
- Deploy da aplicação
- CI/CD com GitHub Actions

---

# 👨‍💻 Autor

**Vitor Ferrari Mendes**

Apaixonado por desenvolvimento Backend utilizando Java e Spring Boot.

Atualmente estudando:

- Java
- Spring Boot
- Docker
- Spring Security
- Testes Unitários
- Microsserviços

Sempre buscando evoluir através de projetos práticos e desafios reais.

---

# ⭐ Gostou do projeto?

Se esse projeto foi útil ou interessante, deixe uma ⭐ no repositório.

Feedbacks e sugestões são sempre bem-vindos!
