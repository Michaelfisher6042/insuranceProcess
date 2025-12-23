# Insurance Product Management System

## 📋 Project Description

A RESTful API system for managing insurance clients and products. The system enables client creation, authentication,
product purchases, and product status updates.

## 🏗️ Architecture
Diagram:
![img.png](img.png)

The system is built on Spring Boot and uses **In-Memory** storage (no database required).

### Layer Structure:

- **Models** - Data entities (Client, Product, ClientProduct)
- **Repositories** - In-memory storage using ConcurrentHashMap
- **Services** - Business logic
- **Controllers** - REST API endpoints
- **DTOs** - Data Transfer Objects

## 📊 ERD (Entity Relationship Diagram)

```
┌─────────────────┐
│     Client      │
├─────────────────┤
│ id (PK)         │
│ name            │
│ contactMethod   │
│ Type            │
│ contactMethod   │
│ Value           │
│ createdAt       │
└────────┬────────┘
         │
         │ 1:N
         │
         ▼
┌─────────────────┐
│ ClientProduct   │
├─────────────────┤
│ product         │──────┐
│ assignmentDate  │      │
│ status          │      │ N:1
└─────────────────┘      │
                         ▼
                 ┌───────────────┐
                 │    Product    │
                 ├───────────────┤
                 │ id (PK)       │
                 │ name          │
                 │ description   │
                 └───────────────┘
```

## 🔑 Design Principles

1. **Client** - Identified by ID and authenticated using:
    - ID
    - Contact Method Type (EMAIL/PHONE/SMS/WHATSAPP)
    - Contact Method Value

2. **Product** - Identified by ID

3. **Each client can have each product only once**

4. **In-Memory Storage** - No database required

## 🚀 API Endpoints

The system provides **only 4 endpoints**:

### 1. Create New Client

```http
POST /api/client/new
Content-Type: application/json

Request Body:
{
  "name": "John Doe",
  "contactMethodType": "EMAIL",
  "contactMethodValue": "john@example.com"
}

Response: 201 Created
{
  "id": "1",
  "name": "John Doe",
  "contactMethodType": "EMAIL",
  "contactMethodValue": "john@example.com",
  "createdAt": "2024-12-23T10:30:00",
  "clientProducts": []
}
```

### 2. Existing Client Authentication & Get Products

```http
POST /api/client/existing
Content-Type: application/json

Request Body:
{
  "clientId": "1",
  "contactMethodType": "EMAIL",
  "contactMethodValue": "john@example.com"
}

Response: 200 OK
[
  {
    "productId": "1",
    "productName": "Life Insurance",
    "productDescription": "Comprehensive coverage",
    "assignmentDate": "2024-12-20T14:20:00",
    "status": "ACTIVE"
  }
]
```

### 3. Buy Product

```http
POST /api/product/buy
Content-Type: application/json

Request Body:
{
    "clientId":"21e1332",
    "productId":"P001",
    "newName":"policy-ab",
    "status":"ACTIVE"
}

Response: 200 OK
"Product purchased successfully"
```

### 4. Update Product Status

```http
PUT /api/product/update
Content-Type: application/json

Request Body:
{
  "clientId": "1",
  "productId": "1",
  "status": "SUSPENDED"
}

Response: 200 OK
"Product status updated successfully"
```

## 📦 Project Structure



## 🛠️ Technologies

- **Java 17+**
- **Spring Boot 3.x**
- **Lombok** - for reducing boilerplate code
- **In-Memory Storage** - ConcurrentHashMap

## ⚙️ Installation & Running

### Prerequisites:

- JDK 17 or higher
- Maven 3.6+

### Steps:

1. **Clone the project**

```bash
git clone <repository-url>
cd insurance-system
```

2. **Build**

```bash
mvn clean install
```

3. **Run**

```bash
mvn spring-boot:run
```

4. **Server will start on:**

```
http://localhost:8080
```


## 🔒 Product Status Options

```java

```

## 📝 Validation Rules



Common errors:

- `Authentication failed` - Invalid authentication details
- `Client not found` - Client doesn't exist
- `Product not found` - Product doesn't exist
- `Client already has this product` - Attempt to purchase existing product
- `Contact method already exists` - Contact method already in use

## 🎯 What's Missing from the Original Instructions?

The following gaps were identified in the requirements analysis:

1. **Security & Authentication**:
    - No Token/Session management mechanism
    - No password encryption (if applicable)
    - No Authorization management

2. **Validation**:
    - Valid format for contact methods (Email validation, Phone format)
    - Additional business rules

3. **Product Creation**:
    - No endpoint for creating products (products must exist beforehand)

4. **Detailed Error Handling**:
    - HTTP Status Codes
    - Detailed error messages

## 📄 License

MIT License

## 👨‍💻 Author

Insurance System - Spring Boot Assignment