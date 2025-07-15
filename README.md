# FinalticaPro – Smart Expense and Investment Management System

FinalticaPro is a backend-focused fintech platform designed to help users efficiently manage personal finances. The system allows users to log income and expenses, define savings goals, and receive rule-based financial recommendations to meet those goals. 

Built using Spring Boot microservices with secure JWT-based authentication, FinalticaPro incorporates modular services for managing users, transactions, goals, reports, and financial guidance. It is suitable for digital banking, personal finance, or investment tracking platforms.

---

## Features

- User registration, login, and JWT-based authentication
- Logging and categorizing income and expenses
- Tracking progress toward custom financial goals
- Generating monthly reports in downloadable formats
- Providing financial suggestions through a rule-based advisory service
- Organized microservice architecture using Spring Cloud Gateway and Eureka
- Containerized deployment using Docker

---

## Technology Stack

### Backend Services
- Java 17
- Spring Boot 3
- Spring Security (JWT)
- Spring Data JPA (PostgreSQL)
- Spring Cloud Gateway and Eureka
- FastAPI (Python 3.10)

### Tools and Infrastructure
- Docker and Docker Compose
- PostgreSQL
- Swagger/OpenAPI for API documentation
- Maven

---

## Microservices Overview

1. **User Service**
   - Handles user registration, login, authentication, and role management
   - Secured with Spring Security and JWT

2. **Transaction Service**
   - Records user income and expenses with category and timestamp
   - Provides filtered views by date and category for tracking

3. **Goal Service**
   - Manages financial goals for users
   - Calculates savings rate and tracks goal completion progress

4. **Report Service**
   - Generates monthly financial summary reports
   - Outputs reports in downloadable formats (e.g., PDF)

5. **Advisor Service** (FastAPI)
   - Provides rule-based financial recommendations based on user data
   - Simulates advisory logic found in financial planning tools

6. **API Gateway**
   - Central access point for routing all API requests
   - Handles request forwarding and security token validation
