## Installation

- Clone the repository

```console
git@github.com:datastaxdevs/spring-boot-astra-spring-data-cassandra.git
```

- Create an account in Astra DB for free [here](https://astra.datastax.com/)

- Create a Database ( [documentation](https://docs.datastax.com/en/astra-db-serverless/databases/create-database.html))

- Create an Application token ([documentation](https://docs.datastax.com/en/astra-db-serverless/administration/manage-application-tokens.html))

- Get you Secure Connect bundle from Astra ([documentation](https://docs.datastax.com/en/astra-db-serverless/drivers/secure-connect-bundle.html))
 
## Setup

- Open `application.properties` and change those 2 properties:

```ini
# Replace with your token starting with AstraCS:...
spring.cassandra.password=<change_me>
# Replace with the path of your secure bundle
datastax.astra.secure-connect-bundle=<change_me>
```

## Use the application

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
![Screenshot 2025-02-17 at 12 05 08](https://github.com/user-attachments/assets/f6a6e9ac-e924-45a2-8d8a-b587687d064f)


