# ⚽ Sistema de Cadastro de Peneiras de Futebol (Aruan)

API REST desenvolvida em Java com Spring Boot para gerenciamento de clubes e treinadores em processos de peneira esportiva. Projeto desenvolvido no IFSP – São Carlos como atividade prática da disciplina de Desenvolvimento Web.

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Versão |
|---|---|
| Java | 21 |
| Spring Boot | 3.3.0 |
| Spring Data JPA | — |
| Lombok | 1.18.22 |
| Banco de Dados | H2 (em memória) |
| Build | Maven |

---

## 📁 Estrutura do Projeto

```
src/
└── main/
    └── java/br/ifsp/edu/dsw3/aruan/
        ├── controller/
        │   ├── ClubeController.java       # Endpoints REST de Clube
        │   └── TreinadorController.java   # Endpoints REST de Treinador
        ├── model/
        │   ├── dao/
        │   │   ├── ClubeDAO.java
        │   │   └── TreinadorDAO.java
        │   └── daomain/
        │       ├── Clube.java             # Entidade JPA
        │       └── Treinador.java         # Entidade JPA
        └── AruanApplication.java
```

---


## 📌 Endpoints Disponíveis

### Clube

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/clube/cadastrar` | Cadastra um novo clube |
| `GET` | `/clube/listar` | Lista todos os clubes |
| `GET` | `/clube/listar/nome/{nome}` | Busca clube pelo nome |
| `DELETE` | `/clube/deletar/{id}` | Remove um clube por ID |

### Treinador

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/treinador/cadastrar` | Cadastra um novo treinador |
| `GET` | `/treinador/listar` | Lista todos os treinadores |
| `DELETE` | `/treinador/deletar/{cpf}` | Remove um treinador pelo CPF |

---



## 👨‍💻 Autor

**Aron Costa da Silva Araujo**  
[![LinkedIn](https://img.shields.io/badge/LinkedIn-aron--araujo-blue?logo=linkedin)](https://linkedin.com/in/aron-araujo-48493530a)
[![GitHub](https://img.shields.io/badge/GitHub-AronAraujo-black?logo=github)](https://github.com/AronAraujo)
