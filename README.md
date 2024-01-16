# E-Commerce API Project

## Overview

This project involves the development of a comprehensive RESTful API for an e-commerce platform using Spring Boot. The API provides essential functionality for managing products and orders.

## Technologies Used

- **Spring Boot:** A powerful framework for building Java-based enterprise applications, providing a robust foundation for the API.

- **MySQL:** A relational database management system used for storing and managing the application's data.

- **Jakarta Validation API:** Utilized for input validation, ensuring data integrity in the API.

- **Lombok:** A library used to reduce boilerplate code, enhancing code readability and maintainability.

## Functional Requirements

### 1. Product Management

#### 1.1 Create a Product

- **Endpoint:** `POST /api/products`
- **Request Payload:**
  ```json
  {
    "name": "Product Name",
    "description": "Product Description",
    "price": 29.99,
    "stockQuantity": 100
  }
  ```
- **Response:**
    - Successful Response (HTTP 201 Created):
      ```json
      {
        "id": 1,
        "name": "Product Name",
        "description": "Product Description",
        "price": 29.99,
        "stockQuantity": 100
      }
      ```

#### 1.2 Get All Products

- **Endpoint:** `GET /api/products`
- **Response:**
    - Successful Response (HTTP 200 OK):
      ```json
      [
        {
          "id": 1,
          "name": "Product Name",
          "description": "Product Description",
          "price": 29.99,
          "stockQuantity": 100
        },
        {
          "id": 2,
          "name": "Another Product",
          "description": "Another Description",
          "price": 39.99,
          "stockQuantity": 50
        }
      ]
      ```

#### 1.3 Get Product by ID

- **Endpoint:** `GET /api/products/{id}`
- **Response:**
    - Successful Response (HTTP 200 OK):
      ```json
      {
        "id": 1,
        "name": "Product Name",
        "description": "Product Description",
        "price": 29.99,
        "stockQuantity": 100
      }
      ```

### 2. Order Management

#### 2.1 Create an Order

- **Endpoint:** `POST /api/orders`
- **Request Payload:**
  ```json
  {
    "customerId": 1,
    "products": [
      {
        "productId": 1,
        "quantity": 2
      },
      {
        "productId": 2,
        "quantity": 1
      }
    ]
  }
  ```
- **Response:**
    - Successful Response (HTTP 201 Created):
      ```json
      {
        "id": 1,
        "customerId": 1,
        "orderDate": "2023-12-10T12:30:45",
        "totalAmount": 99.97,
        "orderItems": [
          {
            "productId": 1,
            "quantity": 2,
            "subtotal": 59.98
          },
          {
            "productId": 2,
            "quantity": 1,
            "subtotal": 39.99
          }
        ]
      }
      ```

#### 2.2 Get All Orders

- **Endpoint:** `GET /api/orders`
- **Response:**
    - Successful Response (HTTP 200 OK):
      ```json
      [
        {
          "id": 1,
          "customerId": 1,
          "orderDate": "2023-12-10T12:30:45",
          "totalAmount": 99.97,
          "orderItems": [
            {
              "productId": 1,
              "quantity": 2,
              "subtotal": 59.98
            },
            {
              "productId": 2,
              "quantity": 1,
              "subtotal": 39.99
            }
          ]
        }
      ]
      ```

#### 2.3 Get Order by ID

- **Endpoint:** `GET /api/orders/{id}`
- **Response:**
    - Successful Response (HTTP 200 OK):
      ```json
      {
        "id": 1,
        "customerId": 1,
        "orderDate": "2023-12-10T12:30:45",
        "totalAmount": 99.97,
        "orderItems": [
          {
            "productId": 1,
            "quantity": 2,
            "subtotal": 59.98
          },
          {
            "productId": 2,
            "quantity": 1,
            "subtotal": 39.99
          }
        ]
      }
      ```

## Setup Instructions

1. **Clone the Repository:**
   ```bash
   git clone <repository-url>
   ```

2. **Build and Run the Application:**
   ```bash
   cd <project-directory>
   ./mvnw clean install
   ./mvnw spring-boot:run
   ```

3. **Access the API:**
   The API will be accessible at `http://localhost:9090`. You can use tools like Postman or cURL to interact with the endpoints.

4. **Database Configuration:**
   Ensure that MySQL is installed and configured. Update the `application.properties` file with your database connection details.

## Conclusion

This README.md provides a comprehensive overview of the E-Commerce API project, outlining its functionality, technologies used, and setup instructions. Follow these instructions to set up and run the project locally, allowing for efficient development and testing.