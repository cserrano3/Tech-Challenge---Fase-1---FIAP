# Tech Challenge - FIAP - Fase 1

## Requerimentos

1) Open JDK 22 - [[https://openjdk.org/projects/jdk/22/]] 
2) Maven 4 - [[https://maven.apache.org/ref/4.0.0-alpha-13/]]
3) PostgreSQL 16 - https://www.postgresql.org/download/
4) Intellij  2024.1.1 ou versão mais estável do Eclipse

## Executando o projeto localmente

O arquivo `application.properties` já está configurado para se conectar ao banco de dados utilizando o usuário padrão do postgreSQL, `postgres`.

1) Após instalar os softwares acima, crie um banco de dados através do seguinte comando através do shell ou bash:
   `psql -U postgres -c "CREATE DATABASE patasamigas;"`
2) Em seguida, abra o projeto em alguma IDE de sua preferência, Intellij ou Eclipse e execute a aplicação.


## Documentação da API

### Criação de usuário

```http
  POST /users/signup
```

Todos os campos são obrigatórios

| Field        | Expected Type | 
|--------------|---------------|
| Email        | String        |
| Password     | String        |
| Role         | String        |
| Name         | String        |
| Last Name    | String        |
| CPF          | String        |
| City         | String        |
| State        | String        |
| Zip          | String        |
| Number       | Integer       |
| Complement   | String        |
| Country      | String        |


#### Exemplo de payload: 

```
{
    "email": "janedoe@example.com",
    "password": "securepassword123",
    "role": "ROLE_USER",
    "name": "Jane",
    "lastName": "Doe",
    "CPF": "123.456.789-10",
    "address": {
        "city": "ExampleCity",
        "state": "ExampleState",
        "zip": "67890-123",
        "number": 456,
        "complmement": "Apt 101",
        "country": "ExampleLand"
    }
}
```


### Autenticação do usuário

Todos os campos são obrigatórios.

```http
  POST /users/login
```
| Field    | Expected Type |
|----------|---------------|
| Email    | String        |
| Password | String        |


#### Exemplo de payload

```
{
    "email": "fuliano@gmail.com",
    "password": "whatever"
}
```


### Cadastro de pet

Todos os campos são obrigatórios.

```http
  POST /pets
```
| Field      | Expected Type |
|------------|---------------|
| Name       | String        |
| Age        | Integer       |
| Pet Species| String        |


#### Exemplo de payload
```

{
    "name": "Noodles",
    "age": 3,
    "petSpecies": "CAT"
}

```
