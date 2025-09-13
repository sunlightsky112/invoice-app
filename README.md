# Invoice Management System

A production-grade CRUD application built with **Java + Spring Boot** that manages invoices, line items, and payments. Designed for scalability, maintainability, and real-world deployment.

---

## Features

- **Create Invoices**: Add customer details and multiple line items (description, price).
- **Read/Search Invoices**: View all invoices or search by customer name.
- **Update Invoices**: Append new line items to existing invoices.
- **Mark as Paid**: Record payment details and update invoice status.
- **Swagger UI**: Fully documented REST API with interactive testing.

---

## Tech Stack

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **PostgreSQL (via Docker)**
- **Maven**
- **Swagger/OpenAPI**
- **JUnit + Mockito**

---

## Database Setup (Docker)

```yaml
postgres:
  image: postgres:14
  ports:
    - "5432:5432"
  environment:
    - POSTGRES_USER=postgres
    - POSTGRES_PASSWORD=postgres