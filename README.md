
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

## API endpoints

Sure! Here’s a simple list of the API endpoints based on your `SoftwareEngineerController`:

---

## API Endpoints
**GET** `/api/v1/software-engineers`
Returns a list of all software engineers.

**POST** `/api/v1/software-engineers`
Request body (JSON):
```json
{
  "name": "string",
  "techStack": "string"
}
```
Adds a new software engineer and returns the created object with an assigned ID.

**PUT** `/api/v1/software-engineers/{id}`
Path parameter:
* `id` (integer) — ID of the software engineer to update
  Request body (JSON):
```json
{
  "name": "string",
  "techStack": "string"
}
```
Updates the software engineer with the given ID and returns the updated object.
Returns an error if the ID does not exist.

**DELETE** `/api/v1/software-engineers/{id}`
Path parameter:
* `id` (integer) — ID of the software engineer to delete
  Deletes the software engineer with the given ID.
  Returns a message confirming deletion or not found status.