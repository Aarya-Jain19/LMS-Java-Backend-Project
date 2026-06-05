# LMS Microservices Project (Spring Boot + Spring Cloud)

## Overview

This project is a **Learning Management System (LMS)** built using **Microservices Architecture**.

It consists of multiple independent services communicating via **REST APIs** and **Feign Clients**, with service discovery handled by **Eureka** and routing through an **API Gateway**.

---

## Architecture

* **Eureka Server** → Service Registry
* **API Gateway** → Central routing
* **User Service** → Manages users
* **Course Service** → Manages courses
* **Enrollment Service** → Handles enrollments

---

## Tech Stack

* Java 17
* Spring Boot
* Spring Cloud (Eureka, Gateway, OpenFeign)
* Spring Data JPA
* MySQL
* Maven

---

##  Microservices & Ports

| Service            | Port |
| ------------------ | ---- |
| Eureka Server      | 8761 |
| API Gateway        | 8084 |
| User Service       | 8081 |
| Course Service     | 8082 |
| Enrollment Service | 8083 |

---

## API Flow

Client → API Gateway → Microservices → Database

---

##  How to Run

1. Start Eureka Server
2. Start all services (User, Course, Enrollment)
3. Start API Gateway
4. Use Postman to test APIs via:

```
http://localhost:8084
```

---

## Sample APIs

### Create User

POST /users

### Create Course

POST /courses

### Enroll User

POST /enrollments

---

## Features

* Service Discovery (Eureka)
* Load Balancing
* Inter-service Communication (Feign)
* Centralized Routing (Gateway)
* Exception Handling
* Validation

---

## 📸 Screenshots

<img width="1022" height="677" alt="image" src="https://github.com/user-attachments/assets/5f92c583-db69-4eac-951d-79af442e467e" />

---

## Author

Arya Jain
