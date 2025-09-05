<hr></hr>
# 🍷 Vino Vibes - Wine & Tasting Management API

A robust REST API for managing users, wines, and tastings, built with **Spring Boot** and modern Java technologies. Perfect for platforms where users can explore, register, and manage wine experiences.

![Java](https://img.shields.io/badge/Java-17-blue?style=flat-square)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.4-brightgreen?style=flat-square)
![Maven](https://img.shields.io/badge/Maven-3.8.1-blue?style=flat-square)
![REST API](https://img.shields.io/badge/API-RESTful-orange?style=flat-square)

---

## 📋 Table of Contents

- [✨ Features](#-features)
- [🚀 Getting Started](#-getting-started)
- [⚙️ Installation](#-installation)
- [🏃‍♂️ Running the App](#-running-the-app)
- [📚 API Documentation](#-api-documentation)
- [🌐 Main Endpoints](#-main-endpoints)
- [🔧 Technologies](#-technologies)
- [📊 Architecture](#-architecture)
- [🤝 Contributing](#-contributing)



---

## ✨ Features

- 👤 User management (registration, login, roles)
- 🌍 Destination management
- 🔐 Security with Spring Security and JWT
- ✅ Custom validations with Bean Validation
- 🚨 Global exception handling
- 📖 API documentation with Postman

---

## 🚀 Getting Started

### Prerequisites

Make sure you have the following installed:

- Java 21
- Maven 3.8+
- MySQL 8+
- Git

## ✨ Features
```
git clone https://github.com/your-username/vino-vibes.git cd vino-vibes
```
Build the project
```
./mvnw clean install
```

Run the application
```
./mvnw spring-boot:run
```

The API will be available at:
http://localhost:8080

## ⚙️ Installation

### 1. Clone the Repository

```
git clone https://github.com/your-username/vino-vibes.git cd vino-vibes
```
### 2. Configure the database

Edit `src/main/resources/application.yaml` with your credentials or set environment variables:

```yaml
spring:
  datasource:
    url: ${DB_URL}
    username: ${DB_USERNAME}
    password: ${DB_PASSWORD}
  jpa:
    hibernate:
      ddl-auto: create-drop
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MySQLDialect
        format_sql: true
    show-sql: true
server:
  port: ${SERVER_PORT:8080}

### 3. Build the Project
```
./mvnw clean install
```
<hr></hr>
📚 API Documentation
API documentation and examples are available in Postman or by browsing the source code for each route.
<hr></hr>

🌐 Main Endpoints
🔓 Public (no authentication)

| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/register` | Register new users |
| `POST` | `/login` | User login and JWT generation |
| `GET`  | `/wines` | List all available wines |
| `GET`  | `/wines/region/{region}` | Filter by region |
| `GET`  | `/wines/type/{type}` | Filter by type |
| `GET`  | `/wines/type/{type}` | Filter by producer |
| `GET`  | `/wines/{id}` | View wine details |
| `GET`  | `/wines/{id}` | View wine details |
| `GET`  | `/tasting` | List all available tastings |
| `GET`  | `/tasting/region/{region}` | Filter by region |
| `GET`  | `/tasting/type/{type}` | Filter by type |
| `GET`  | `/tasting/type/{type}` | Filter by producer |
| `GET`  | `/tasting/{id}` | View tasting details |
| `GET`  | `/tasting/{id}` | View tasting details |

---

#### 🔐 Authenticated Users (Auth: User)
| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET`    | `/wines/user` | Get information about the authenticated user |
| `POST`   | `/wines` | Create a wine associated with the authenticated user |
| `PUT`    | `/wines/{id}` | Edit your own destination |
| `DELETE` | `/wines/{id}` | Delete your own destination |
| `GET`    | `/tasting/user` | Get information about the authenticated user |
| `POST`   | `/tasting` | Create a wine associated with the authenticated user |
| `PUT`    | `/tasting/{id}` | Edit your own tasting |
| `DELETE` | `/tasting/{id}` | Delete your own tasting |

---

#### 🛡️ Administrators (Auth: Admin)
| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET`  | `/users` | List all users |
| `PUT`  | `/admin/users/{id}` | Modify user data or role |
| `GET`  | `/users/{id}` | Get a user's wines |



## 🔧 Technologies

### Backend Stack
- **Java 21+** - Core programming language

- **Spring Boot 3.2.4+** - Application framework

- **Spring Data JPA** - Data persistence layer

- **Spring Security + JWT** - Provides authentication and authorization

- **Hibernate** - ORM framework

- **MySQL** - Database systems

### Development Tools

- **Postman** - API testing and documentation

- **Maven** - Build automation and dependency management tool

## 📊 Architecture

The project follows a clean 3-layer MVC architecture:

Controller → Service → Repository

### 📁 Project Structure
```
vino-vibes/
├── src/
│   ├── main/
│   │   ├── java/com/example/vino_vibes/
│   │   │   ├── controllers/
│   │   │   ├── dtos/
│   │   │   ├── exceptions/
│   │   │   ├── models/
│   │   │   ├── repositories/
│   │   │   ├── security/
│   │   │   ├── services/
│   │   │   └── VinoVibesApplication.java
│   │   └── resources/
│   │       ├── application.yaml
│   │       └── data.sql
│   └── test/
│       └── java/com/example/vino_vibes/
├── pom.xml
├── mvnw / mvnw.cmd
├── .gitignore
├── README.md
```

## 🤝 Contributing
We welcome contributions! Follow these steps:

1. Fork the repo

2. Create a new branch:
   git checkout -b feature/your-feature-name

3. Commit your changes:
   git commit -m "Add your feature name"

4. Push and open a Pull Request