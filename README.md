# 📌 To-Do List API - CRUD with Spring Boot and Kotlin

A task management API REST (To-Do List) developed using **Spring Boot and Kotlin**.
Allows to create, read, update and delete tasks with validations.

## Technologies used

- 🌱 **Spring Boot 3** - Main framework.
- 📝 **Kotlin** - Programming language.
- 🗄️ **Spring Data JPA** - Database management.
- 🐘 **PostgreSQL** - Database.
- 📖 **SpringDoc OpenAPI** - Swagger documentation.
- 🚀 **Docker** - Containerization.
- ✅ **JUnit & Mockito** - Unit testing.

# API Usage

### Get all tasks
**GET** `/tasks`

### Create a task
**POST** `/tasks`
```json
{
    "title": "Learn Spring Boot",
    "description": "Finished API REST application",
    "dueDate": "2025-03-01T12:00:00.000Z",
    "state": 1
}
```

### Update a task
**POST** `/tasks`
```json
{
    "id": 1,
    "title": "Learn Spring Boot",
    "description": "Finished API REST application",
    "dueDate": "2025-03-01T12:00:00.000Z",
    "state": 2
}
```

### Delete a task
**DELETE** `/tasks/{id}`

## 📌 Author
👤 **Jhoan Rangel**  
📧 Contact: [jhoanrangels2@gmail.com](mailto:jhoanrangels2@gmail.com)  
🔗 GitHub: [github.com/RangelJhoan](https://github.com/RangelJhoan)
