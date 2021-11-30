# Flights API Repository

This repository holds the source code for the Flights API built in Spring Boot. 

The program is intended to run in a Docker container. If not using Docker or docker-compose to run the code, several environment variables must be defined for the database connection:
* spring.datasource.url (mysql url endpoint)
* spring.datasource.username (mysql admin account username)
* spring.datasource.password (mysql admin account password)
These variables must also be passed as environment variables to any Docker container created manually.

## Docker

This code is compiled into a Docker image held at amattsonsm/flights-api

## API

Current Endpoints:
```sh
/api/v1/flights
               /      GET, POST
               /{id}  GET, POST, PUT, DELETE
/api/v1/airports
                /      GET, POST
                /{id}  GET, POST, PUT, DELETE
/api/v1/routes
              /      GET, POST
              /{id}  GET, POST, PUT, DELETE
/api/v1/airplane_types
                      /      GET, POST
                      /{id}  GET, POST, PUT, DELETE
/api/v1/airplanes
                 /      GET, POST
                 /{id}  GET, POST, PUT, DELETE
```
