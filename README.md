
# Spring Boot REST API with PostgreSQL
This project is a backend service built with Spring Boot that connects to a PostgreSQL database running in Docker. 
It has a REST APIs, uses Spring Data JPA for database access, and runs the database inside a Docker container.

> Built to practice building backend services with Java, Spring Boot, and PostgreSQL using Docker for easy setup.

## Technologies
* Java 21
* Spring Boot 3.5.3
* Maven
* Docker & Docker Compose
* PostgreSQL
* Spring Data JPA

## Usage
### Installation
1. Clone the project.
2. Make sure Docker and Docker Compose are installed.
3. Start the database: `docker-compose up -d`
4. Build the project: `./mvnw clean install` or `mvn clean install`

### Running the app
- Run the Spring Boot app: `./mvnw spring-boot:run`.  
- The API will be available at `http://localhost:8080`. 
- Use Postman or curl to test the API.

### Stopping the database
When done, stop the database container: `docker-compose down`

## API Endpoints
See [api-endpoints.md](./api-endpoints.md)
