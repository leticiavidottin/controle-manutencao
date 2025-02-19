# Controle de Manutenção

Este projeto é um sistema para gerenciamento de ordens de serviço e seus acompanhamentos, permitindo o registro de atualizações ao longo do tempo.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **H2**
- **Lombok**

## Configuração do Ambiente

### 1. Clonar o repositório

```bash
git clone https://github.com/leticiavidottin/cmanut
cd controle_manutencao
```

### 2. Executar a aplicação

#### Usando Maven:

```bash
mvn spring-boot:run
```

#### Usando um IDE (IntelliJ, Eclipse, VS Code):

- Execute a classe `ControleManutencaoApplication.java`

## Endpoints da API

### Ordem de Serviço

| Método | Rota           | Descrição                        |
| ------ | -------------- | -------------------------------- |
| GET    | `/ordens`      | Lista todas as ordens de serviço |
| GET    | `/ordens/{id}` | Obtém detalhes de uma ordem      |
| POST   | `/ordens`      | Cria uma nova ordem de serviço   |
| PUT    | `/ordens/{id}` | Atualiza uma ordem existente     |
| DELETE | `/ordens/{id}` | Remove uma ordem de serviço      |

### Acompanhamento

| Método | Rota                         | Descrição                          |
| ------ | ---------------------------- | ---------------------------------- |
| GET    | `/acompanhamentos/{ordemId}` | Lista acompanhamentos de uma ordem |
| POST   | `/acompanhamentos/{ordemId}` | Adiciona um acompanhamento         |

## Exemplos de Uso

### Criar uma Ordem de Serviço

**Request (POST **``**)**

```json
{
  "descricao": "Manutenção preventiva do equipamento X"
}
```

### Adicionar um Acompanhamento

**Request (POST **``**)**

```json
"Serviço interrompido por falta de peça. Aguardando reposição."
```

### Listar Acompanhamentos de uma Ordem

**Request (GET **``**)**

### *Collection Postman
//todo