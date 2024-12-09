# Tickets API

## Local development

1. Clone this repository and cd into it

    ```
    https://github.com/waldo2810/tickets.git
    cd tickets
    ```

2. Setup postgres database

    ```
    docker compose up
    ```

3. Run the server

    ```
    ./gradlew tasks bootRun
    ```

4. Test the API

4.1 Create a ticket

    curl -X POST http://localhost:8080/api/tickets -H 'Content-Type: application/json' -d '{"user": "user1"}'

4.2 List tickets

    curl -X GET http://localhost:8080/api/tickets?page=0&size=10

## List of endpoints

### **GitHub User Endpoints**

#### 1. **Search GitHub Users**
- **Endpoint:** `GET /api/github-users`
- **Query Parameters:**
  - `name` (required): The name or query to search GitHub users.
- **Response:**  
  Returns a list of `GithubUser` objects.

### **Ticket Endpoints**

#### 1. **Create a Ticket**
- **Endpoint:** `POST /api/tickets`
- **Request Body:**
  ```json
  {
    "user": "string" // (required) The user associated with the ticket
  }
  ```
- **Response:**
  ```json
  {
    "message": "created!"
  }
  ```

#### 2. **Delete a Ticket**
- **Endpoint:** `DELETE /api/tickets/{id}`
- **Path Parameters:**
  - `id` (required): The ID of the ticket to delete.
- **Response:**
  ```json
  {
    "message": "deleted!"
  }
  ```

---

#### 3. **Update a Ticket**
- **Endpoint:** `PUT /api/tickets/{id}`
- **Path Parameters:**
  - `id` (required): The ID of the ticket to update.
- **Response:**
  ```json
  {
    "message": "updated!"
  }
  ```

#### 4. **Get All Tickets (with optional pagination and filtering)**
- **Endpoint:** `GET /api/tickets`
- **Query Parameters:**
  - `page` (required): The page number (starting from 0).
  - `size` (required): The number of tickets per page.
  - `status` (optional): Filter tickets by status (`OPEN` or `CLOSED`).
- **Response:**
  Returns a `PaginatedResponse` object containing:
  ```json
  {
    "content": [ /* List of tickets */ ],
    "totalPages": 1,
    "totalElements": 10,
    "currentPage": 0,
    "nextPage": 1
  }
  ```
