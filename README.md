## Installation

- Clone the repository

```console
git@github.com:datastaxdevs/spring-boot-astra-spring-data-cassandra.git
```

- 1. Create an account in Astra DB for free
https://astra.datastax.com/

- 2. Create a Database
https://docs.datastax.com/en/astra-db-serverless/databases/create-database.html

- 3. Create an Application token
https://docs.datastax.com/en/astra-db-serverless/administration/manage-application-tokens.html

- 4. Get you Secure Connect bundle from Astra
https://docs.datastax.com/en/astra-db-serverless/drivers/secure-connect-bundle.html
 
## Setup

- Open `application.propoerties` and change `spring.cassandra.password` with your token and `datastax.astra.secure-connect-bundle` pointing to your secure connect bundle

```ini
spring.cassandra.password=<change_me>
datastax.astra.secure-connect-bundle=<change_me>
```

## use the application

- Start the application (first start could take up a few seconds as the table is created for you)

```bash
mvn spring-boot:run
```

- List your todos (or in your browser [http://localhost:8080/todos](http://localhost:8080/todos))

```bash
curl -X GET http://localhost:8080/todos
```

- Create a todo

```bash
curl -X POST http://localhost:8080/todos \
     -H "Content-Type: application/json" \
     -d '{"title": "New Todo", "description": "Todo details", "completed": false}'
```

- You can go to the CQL Console in astra UI to see your data:


