# HTTP API endpoints for restAPI
## Base URL
```
http://localhost:8080/api/v2
```

## Endpoints
### GET `/software-engineers`
Returns a list of all software engineers.
```
/software-engineers
```

### GET `/software-engineers/{id}`
Path parameter:
* `id` (integer) — ID of the software engineer.  
Returns the software engineer with the given ID.  
Returns `404 Not Found` if the ID does not exist.

### POST `/software-engineers`
Adds a new software engineer and returns the created object with an assigned ID.  
**Request body (JSON):**
```json
{
  "name": "string",
  "techStack": "string"
}
```

### PUT `/software-engineers/{id}`
Updates the software engineer with the given ID and returns the updated object.  
**Request body (JSON):**
```json
{
  "name": "string",
  "techStack": "string"
}
```
Returns an error if the ID does not exist.

### DELETE `/software-engineers/{id}`
Deletes the software engineer with the given ID.  
Returns a confirmation message or a `404 Not Found` status if the ID does not exist.

## **NOT IMPLEMENTED YET**
### PATCH `/software-engineers/{id}`

Partially updates the software engineer’s data (e.g., only techStack).  
**Request body (JSON):**
```json
{
  "techStack": "string"
}
```
Returns the updated object.

### HEAD `/software-engineers/{id}`
Returns headers only (no body), useful to check if a resource exists.

### OPTIONS `/software-engineers` or `/software-engineers/{id}`
Returns allowed HTTP methods for this endpoint.

### Health Check
**GET** `/health`
Returns basic status to indicate if the service is up.

### GET `/software-engineers`
Supports optional query parameters for filtering, sorting, and pagination:
```
/software-engineers?techStack=java&page=1&size=10&sort=name,asc
```