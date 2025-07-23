# Credit Card Service – FinalticaPro

The Credit Card Service is a Spring Boot microservice in the FinalticaPro platform. It manages user-defined credit card records, validates transactions, and tracks usage statistics. This service integrates with the Transaction Service to enforce credit limits before approving spending.

---

## Features

- Create and manage credit card details
- Update individual credit card fields (name, type, issuer, limit, billing date, etc.)
- Validate transactions before processing
- Delete credit card records
- Designed for microservice integration via API Gateway and FeignClient

---

## Technologies Used

- Java 17
- Spring Boot 3
- Spring Data JPA (PostgreSQL)
- Spring Web
- Jackson (for JSON handling)
- RESTful API Design
- Maven

---

## API Endpoints

| Method | Endpoint                            | Description                                |
|--------|-------------------------------------|--------------------------------------------|
| POST   | `/creditcard/create`                | Create a new credit card                   |
| GET    | `/creditcard/get/{id}`              | Retrieve card details by ID                |
| PATCH  | `/creditcard/update/{id}`           | Update credit card details via DTO         |
| DELETE | `/creditcard/delete/{id}`           | Delete a credit card                       |
| POST   | `/creditcard/validate`              | Validate a transaction request             |

---

## Controller Method Summary

### createCard(JsonNode data): CreditCard  
Creates a new credit card after checking for duplicate card numbers.

### getCard(Long id): CreditCard  
Fetches credit card details for a given ID.

### updateCard(Long id, UpdateCreditCardRequestDTO dto): CreditCard  
Updates credit card fields provided via DTO.

### validateTransaction(ValidateCardRequestDTO dto): boolean  
Validates whether a transaction is allowed based on credit limit and user association.

### deleteCard(Long id): boolean  
Deletes the credit card from the database if it exists.

---

## Swagger/OpenAPI

- The OpenAPI specification for this service is defined in `openapi.yaml`
- Available endpoints follow the `/creditcard` base path.
- Supports schema definitions for `CreditCard` and `ValidateCardRequestDTO`

---

## Notes

- Only the last four digits of the card number are stored for privacy.
- All validations are handled before any financial transaction is accepted.
- The service does not fetch or manage user data directly—`userId` is passed from external services.
- This service is not yet integrated with a service registry or gateway (to be added later).

---

## Getting Started

1. Clone the repository
2. Configure `application.yml` with your PostgreSQL DB
3. Build the project:
