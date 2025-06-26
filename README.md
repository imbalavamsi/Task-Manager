# 🧑‍💻 Task Manager API

A Spring Boot 3.5.0 application for managing tasks. Built with Java 17, Spring Data JPA, H2 Database, and Docker.

---

## 🚀 Features

- CRUD operations on tasks
- Bulk create, update, and delete tasks
- DTO-based clean API layer
- H2 in-memory database support
- Dockerized for containerized deployment
- Swagger UI enabled for API documentation

---

## 📦 Tech Stack

- Java 17
- Spring Boot 3.5.0
- Spring Data JPA
- H2 Database
- Maven
- Docker
- Springdoc OpenAPI for Swagger

---

## 📂 Project Structure

```
src/main/java/com/practice/task/
├── controller      → REST API endpoints
├── dto             → TaskDto (record)
├── entity          → Task entity
├── exception       → Custom exception handling
├── mapper          → DTO <-> Entity conversion
├── repo            → JPA repository interface
├── service         → Business logic layer
```

---

## ▶️ Running the App Locally

### 1. Using Maven

```bash
./mvnw clean package
java -jar target/task-manager-app.jar
```

### 2. Using Docker

```bash
docker build -t task-manager-app .
docker run -p 8080:8080 task-manager-app
```

---

## 🌐 API Endpoints

| Method | Endpoint              | Description                  |
|--------|-----------------------|------------------------------|
| GET    | `/tasks`              | Get all tasks (with pagination) |
| GET    | `/tasks/{id}`         | Get task by ID               |
| POST   | `/tasks`              | Create a single task         |
| POST   | `/tasks/bulk`         | Create multiple tasks        |
| PUT    | `/tasks/{id}`         | Update task by ID            |
| PUT    | `/tasks/bulk`         | Update multiple tasks        |
| DELETE | `/tasks/{id}`         | Delete task by ID            |
| DELETE | `/tasks/bulk`         | Delete multiple tasks        |

---

## 🧪 API Testing

- Import the provided Postman collection:
    - `TaskManager_Full_Postman_Collection.json`
- Swagger UI:
    - Visit [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## 🗂 Sample Data

Use `data.sql` or Postman collection to insert sample tasks such as:

- "Attend Orientation"
- "Meet HR"
- "Setup Email"
- "Install Dev Tools"
- "Join Team Stand-up"

---

## 🤝 Contributing

Feel free to fork, enhance, and contribute to the project!

---

## 📄 License

This project is licensed under the MIT License.
