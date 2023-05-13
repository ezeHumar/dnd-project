# :dragon_face: DnD Project :dragon_face:

## Description
This is an API made with Java and Springboot that allow users to save all the information about a Dungeon and Dragons 
campaign and keep track of all the sessions.

## Prerequisites
To work on this project you must have:
- Java 17.0.6 or higher
- Maven 3.8.7 or higher
- Postgres 15.2 or higher

## Getting Started

Follow these steps for running the app locally.

This API works with a Postgres database, so you will need one. You can use a docker image to quickly mount one.

You can use this command:

```shell
docker run -e POSTGRES_DB=<db-name> -e POSTGRES_USER=<user> -e POSTGRES_PASSWORD=<password> -p 5432:5432-d postgres
```

You need to configure the **password**, **user** and **db-name** in the
[application-local.properties](./src/main/resources/application-local.properties) file.

```properties
spring.datasource.url=jdbc:postgresql://<domain-name>:5432/<db-name>
spring.datasource.username=<user>
spring.datasource.password=<password>
```


Now you can run the app with the following command

```shell
mvn spring-boot:run -Dspring-boot.run.profiles=local
```

The app uses [Flyway](https://flywaydb.org/documentation/) for the database initialization.
The migration files are located in [./src/main/resources/db/migration](./src/main/resources/db/migration)
