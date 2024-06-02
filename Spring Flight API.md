# Spring Flight API

Essa api tem a funcionalidade de realizar o controle de passagem, passageiros, aviões e aviões.

## Models

### Passenger

- Id: Long
- Name: String
- CPF: String
- PassportNumber: String
- Email: String
- Fights: Ticket n..n

### Flight

- Id: Long
- Origin: String
- Destination: String
- Departure: LocalDate
- Arrival: LocalDate
- Passengers: Ticket n..n

## Rotas

### Passenger

| Método | Rota           | Descrição                               |
| ------ | -------------- | --------------------------------------- |
| GET    | /passenger     | Listar todos os passageiros cadastrados |
| POST   | /passenger     | Criar um usuário                        |
| GET    | /passenger/:id | Busca usuário pelo Id                   |
| PUT    | /passenger/:id | Atualizar os dados                      |
| DELETE | /passenger/:id | Deletar usuário                         |

### Flight

| Método | Rota        | Descrição                        |
| ------ | ----------- | -------------------------------- |
| GET    | /flight     | Listar todos os voos cadastrados |
| POST   | /flight     | Criar um voo                     |
| GET    | /flight/:id | Busca voo pelo Id                |
| PUT    | /flight/:id | Atualizar os dados               |
| DELETE | /flight/:id | Deletar voo                      |

# Ticket

| Método | Rota        | Descrição                             |
| ------ | ----------- | ------------------------------------- |
| GET    | /ticket     | Listar todos as passagens cadastrados |
| POST   | /ticket     | Criar uma passagem                    |
| GET    | /flight/:id | Busca passagem pelo Id                |
| PUT    | /flight/:id | Atualizar os dados                    |
| DELETE | /flight/:id | Deletar passagem                      |
