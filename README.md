# Flight Manager API

A API Flight Manager foi desenvolvida como um projeto de estudo utilizando Java e Spring Boot. Esta API gerencia passageiros e voos, permitindo criar, listar, obter detalhes, ativar e desativar passageiros, assim como criar, listar e obter detalhes de voos.
## Tecnologias Utilizadas

- **Java**
- **Spring Boot**
- **PostgreSQL**
- **Docker**

## Técnicas Utilizadas

- **Tratamento de Erros**: Utilizando o padrão `ProblemDetail`
- **Controle de Regras de Negócios**: Implementado com exceções personalizadas

## Endpoints

### Passageiros

| Método | URL                                   | Descrição                                          |
|--------|---------------------------------------|---------------------------------------------------|
| POST   | `/passengers?includeInactive=boolean` | Cria um novo passageiro                           |
| GET    | `/passengers`                         | Lista todos os passageiros ativos por padrão      |
| PATCH  | `/passengers/{id}/deactivate`         | Desativa um passageiro                            |
| PATCH  | `/passengers/{id}/activate`           | Ativa um passageiro                               |

### Voos

| Método | URL                                        | Descrição                         |
|--------|--------------------------------------------|-----------------------------------|
| POST   | `/flights`                                 | Cria um novo voo                  |
| GET    | `/flights`                                 | Lista todos os voos               |
| POST   | `/flights/{flightId}/remove/{passengerId}` | Remove um passageiro de um voo    |
| POST   | `/flights/{flightId}/add/{passengerId}`    | Adicionar um passageiro de um voo |
