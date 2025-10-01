# 📌 PRAV – Plataforma de Registro e Avaliação de Serviços

## 📖 Sobre o projeto
O **PRAV** é um sistema web desenvolvido em **Java (Spring Boot)** com **PostgreSQL** como banco de dados.  
Ele permite o cadastro e gerenciamento de usuários, prestadores de serviços, serviços e solicitações de serviços, incluindo **aprovação e rejeição** de solicitações.  

Este projeto segue a arquitetura **em camadas (Controller → Service → Repository → Model)** e a metodologia **Ágil**, com entregas incrementais de funcionalidades.

---

## 🚀 Tecnologias utilizadas
- **Java 17+**
- **Spring Boot (Web, Data JPA)**
- **PostgreSQL**
- **Hibernate**
- **Maven**

---

## ⚙️ Estrutura do projeto
```
src/main/java/com/prav
  ├─ model          # Entidades (Usuario, PrestadorServico, Servico, SolicitacaoServico)
  ├─ repository     # Interfaces JPA para acesso ao banco
  ├─ service        # Regras de negócio
  └─ controller     # Endpoints REST (CRUD + operações especiais)
```

---

## 🛠️ Configuração do Banco
1. Criar o banco no PostgreSQL:
```sql
CREATE DATABASE prav;
```

2. Ajustar credenciais no arquivo `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/prav
spring.datasource.username=postgres
spring.datasource.password=SUA_SENHA
spring.jpa.hibernate.ddl-auto=update
```

---

## ▶️ Como rodar o projeto
1. Clone o repositório:
```bash
git clone https://github.com/seuusuario/prav.git
```

2. Entre na pasta do projeto:
```bash
cd prav
```

3. Rode com Maven:
```bash
mvn spring-boot:run
```

4. A API ficará disponível em:
```
http://localhost:8080
```

---

## 📌 Endpoints principais

### 👤 Usuários
- `GET /usuarios` → lista todos
- `POST /usuarios` → cria um novo
- `PUT /usuarios/{id}` → atualiza
- `DELETE /usuarios/{id}` → remove

### 🧑‍🔧 Prestadores
- `GET /prestadores`
- `POST /prestadores`
- `PUT /prestadores/{id}`
- `DELETE /prestadores/{id}`

### 🛠️ Serviços
- `GET /servicos`
- `POST /servicos`
- `PUT /servicos/{id}`
- `DELETE /servicos/{id}`

### 📑 Solicitações
- `GET /solicitacoes`
- `POST /solicitacoes`
- `PUT /solicitacoes/{id}`
- `DELETE /solicitacoes/{id}`
- `PUT /solicitacoes/{id}/aprovar` → aprova solicitação
- `PUT /solicitacoes/{id}/rejeitar` → rejeita solicitação

---

## 🧪 Exemplo de uso (JSON)

### Criar Usuário
```json
{
  "nome": "Maria da Silva",
  "email": "maria@mail.com",
  "senha": "123456",
  "tipoPerfil": "Cliente"
}
```

### Criar Serviço
```json
{
  "prestador": { "idPrestador": 1 },
  "tipoServico": "Pintura Residencial",
  "descricaoDetalhada": "Pintura em apartamento 2 quartos",
  "dataExecucao": "2025-10-15",
  "localExecucao": "Rua das Flores, 123",
  "valor": 1200.00
}
```

---

## 📂 Funcionalidades entregues (alta prioridade)
- ✅ Cadastro de serviços (RF01)  
- ✅ Cadastro e gerenciamento de prestadores (RF03)  
- ✅ Aprovação/Rejeição de solicitações de serviços (RF04)  
- ✅ Log automático de exclusão de usuários via **trigger no PostgreSQL**

---

## 🤝 Contribuição
Sinta-se à vontade para abrir issues e pull requests.  
Projeto desenvolvido com fins acadêmicos para disciplina de **Desenvolvimento Web I**.
