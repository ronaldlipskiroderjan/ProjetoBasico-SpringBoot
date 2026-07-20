# Categorizador

Uma aplicação RESTful desenvolvida em Spring Boot para gerenciar categorias e eventos, permitindo organizar e categorizar eventos de forma eficiente.

## 📋 Sobre o Projeto

O Categorizador é uma API backend que fornece funcionalidades para:
- Criar, ler, atualizar e deletar categorias
- Criar, ler, atualizar e deletar eventos
- Associar eventos com suas categorias
- Retornar dados estruturados através de DTOs especializados

## 🛠️ Tecnologias Utilizadas

### Backend
- **Java 21** - Linguagem de programação
- **Spring Boot 4.1.0** - Framework web e IoC
- **Spring Data JPA** - Camada de persistência e ORM
- **Hibernate** - Implementação de JPA
- **PostgreSQL** - Banco de dados relacional

### Ferramentas de Desenvolvimento
- **Maven** - Gerenciador de dependências e build
- **Lombok** - Geração automática de getters, setters e construtores
- **JUnit** - Framework de testes unitários

## 📦 Estrutura do Projeto

```
src/
├── main/
│   ├── java/com/Ronald/Categorizador/
│   │   ├── controller/           # Endpoints REST
│   │   ├── service/              # Lógica de negócio
│   │   ├── database/
│   │   │   ├── model/            # Entidades JPA
│   │   │   └── repository/       # Acesso a dados
│   │   └── dto/                  # Data Transfer Objects
│   │       ├── Request/          # DTOs para requisições
│   │       └── Response/         # DTOs para respostas
│   └── resources/
│       └── application.yaml      # Configurações da aplicação
└── test/                         # Testes automatizados
```

## 🚀 Como Executar

### Pré-requisitos

- Java 21+
- Maven 3.6+
- PostgreSQL 12+

### Configuração do Banco de Dados

1. Crie um banco de dados PostgreSQL:
```sql
CREATE DATABASE categorizador;
```

2. Configure as variáveis de ambiente com suas credenciais:
```bash
export DATABASE_USERNAME=seu_usuario
export DATABASE_PASSWORD=sua_senha
```

### Executar a Aplicação

1. Clone ou navegue até o diretório do projeto
2. Compile e execute com Maven:
```bash
mvn clean install
mvn spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`

## 📚 Endpoints da API

### Categorias
- `GET /categorias` - Listar todas as categorias
- `POST /categorias` - Criar nova categoria
- `GET /categorias/{id}` - Buscar categoria por ID
- `PUT /categorias/{id}` - Atualizar categoria
- `DELETE /categorias/{id}` - Deletar categoria

### Eventos
- `GET /eventos` - Listar todos os eventos
- `POST /eventos` - Criar novo evento
- `GET /eventos/{id}` - Buscar evento por ID
- `PUT /eventos/{id}` - Atualizar evento
- `DELETE /eventos/{id}` - Deletar evento

## 🏗️ Arquitetura

O projeto segue uma arquitetura em camadas:

- **Controller Layer** - Recebe as requisições HTTP e as encaminha para a service
- **Service Layer** - Contém a lógica de negócio da aplicação
- **Repository Layer** - Gerencia o acesso aos dados no banco de dados
- **Entity/Model Layer** - Define as estruturas de dados (entidades do banco)
- **DTO Layer** - Transfer objects para requisições e respostas da API

## 📝 Propriedades de Configuração

As propriedades principais no `application.yaml`:

```yaml
server:
  port: 8080                              # Porta da aplicação

spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/categorizador
    username: ${DATABASE_USERNAME}        # Variável de ambiente
    password: ${DATABASE_PASSWORD}        # Variável de ambiente
  jpa:
    hibernate:
      ddl-auto: update                   # Auto-criar/atualizar schema
```

## 🧪 Testes

Execute os testes com:
```bash
mvn test
```

## 📄 Licença

Este projeto é de uso pessoal e educacional.

## 👨‍💻 Autor

Ronald Roderjan

