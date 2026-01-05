# Product Catalog Microservice - Enterprise Architecture

A complete enterprise-grade Spring Boot application demonstrating layered architecture, model segregation, and isolation patterns.

## 🏗️ Architecture Overview

This project implements a **layered enterprise architecture** with:

- **API Layer** - REST controllers with Swagger documentation
- **Service Layer** - Business logic orchestration
- **Isolation Layer** - Database & external API isolation
- **Data Layer** - JPA entities and repositories

## 🎯 Key Features

### Architecture Patterns
- ✅ **Layered Architecture** with clean separation of concerns
- ✅ **Model Segregation** (API, Internal, Accessor models)
- ✅ **Isolation Pattern** for database and external APIs
- ✅ **MapStruct Integration** for type-safe mapping
- ✅ **Constructor Injection** throughout
- ✅ **Optional<T>** for null safety

### Technologies
- **Java 21**
- **Spring Boot 3.2.1**
- **MapStruct 1.5.5.Final** - Compile-time code generation
- **Spring Data JPA** - Database access
- **H2 Database** - In-memory database
- **WebClient** - External API calls
- **Swagger/OpenAPI 3** - API documentation
- **Maven** - Build tool

## 📁 Project Structure

```
src/main/java/com/enterprise/catalog/
├── ProductCatalogApplication.java          # Main Spring Boot application
├── api/product/                           # API Layer
│   ├── ProductController.java             # REST endpoints
│   ├── mappeur/                           # API ↔ Internal mappers
│   │   ├── ProductApiParametreMapper.java
│   │   └── ProductApiReponseMapper.java
│   └── modele/
│       └── ProductApi.java                # API model (external contract)
├── service/product/                       # Service Layer
│   ├── ProductService.java               # Business logic orchestration
│   └── modele/
│       ├── Product.java                  # Internal business model
│       └── Review.java                   # Internal review model
├── isolation/                            # Isolation Layer
│   ├── database/                         # Database isolation
│   │   ├── ProductIsolationManager.java
│   │   ├── ProductRepository.java
│   │   ├── mappeur/                      # Internal ↔ Database mappers
│   │   │   ├── ProductParametreAccesseurMapper.java
│   │   │   └── ProductReponseAccesseurMapper.java
│   │   └── modele/
│   │       └── ProductEntity.java        # JPA entity
│   └── rest/                            # External API isolation
│       ├── ReviewIsolationManager.java
│       ├── ReviewRestClient.java
│       ├── mappeur/
│       │   └── ReviewReponseAccesseurMapper.java
│       └── modele/
│           └── ReviewAccesseur.java      # External API model
└── noyau/                               # Core interfaces
    ├── mappeur/                         # Mapper interfaces
    │   ├── Mappeur.java
    │   ├── MappeurParametreApi.java
    │   ├── MappeurReponseApi.java
    │   ├── MappeurParametreAccesseur.java
    │   └── MappeurReponseAccesseur.java
    └── modele/                          # Model marker interfaces
        ├── ModeleApi.java
        ├── ModeleInterne.java
        └── ModeleAccesseur.java
```

## 🚀 Getting Started

### Prerequisites
- Java 21
- Maven 3.6+

### Running the Application

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd SOL\ V1
   ```

2. **Compile and generate MapStruct code**
   ```bash
   mvn clean compile
   ```

3. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

4. **Access the application**
   - API Base URL: `http://localhost:8080/api/v1/products`
   - Swagger UI: `http://localhost:8080/swagger-ui/index.html`
   - H2 Console: `http://localhost:8080/h2-console`

## 🧪 API Endpoints

### Products
- `GET /api/v1/products` - Get all products
- `GET /api/v1/products/{id}` - Get product by ID (with reviews)
- `POST /api/v1/products` - Create new product
- `GET /api/v1/products/category/{category}` - Get products by category
- `GET /api/v1/products/expensive` - Get expensive products (>$100)
- `DELETE /api/v1/products/{id}` - Delete product

### Example Usage

**Create a product:**
```bash
curl -X POST http://localhost:8080/api/v1/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "iPhone 15 Pro",
    "description": "Latest iPhone with titanium design",
    "price": "999.99",
    "category": "Electronics"
  }'
```

**Get all products:**
```bash
curl -X GET http://localhost:8080/api/v1/products
```

## 🏛️ Architecture Concepts

### Model Segregation
- **ProductApi** - External API contract (REST layer)
- **Product** - Internal business model (Service layer)
- **ProductEntity** - Database representation (Data layer)
- **ReviewAccesseur** - External API format (Isolation layer)

### Data Flow
```
HTTP JSON → ProductApi → Product → ProductEntity → Database
Database → ProductEntity → Product → ProductApi → HTTP JSON
External API → ReviewAccesseur → Review → Business Logic
```

### Isolation Pattern
- **ProductIsolationManager** - Isolates database operations
- **ReviewIsolationManager** - Isolates external API calls
- **Service Layer** - Never directly touches database entities or external models

## 🗺️ MapStruct Mappers

The project uses MapStruct for compile-time code generation:

- **ProductApiParametreMapper** - ProductApi → Product
- **ProductApiReponseMapper** - Product → ProductApi  
- **ProductParametreAccesseurMapper** - Product → ProductEntity
- **ProductReponseAccesseurMapper** - ProductEntity → Product
- **ReviewReponseAccesseurMapper** - ReviewAccesseur → Review

Generated implementations are in `target/generated-sources/annotations/`

## 🔧 Configuration

### Database
- **H2 in-memory database** for development
- **Auto-creates tables** from JPA entities
- **Console available** at `/h2-console`

### External API
- **Mock external API** using JSONPlaceholder
- **Graceful error handling** for network issues
- **WebClient** for reactive HTTP calls

## 🎓 Learning Objectives

This project demonstrates:
- ✅ Enterprise layered architecture
- ✅ Dependency injection best practices
- ✅ Model segregation and mapping strategies
- ✅ Isolation patterns for external dependencies
- ✅ Type-safe code generation with MapStruct
- ✅ REST API design with proper HTTP status codes
- ✅ Business logic separation and testing strategies
- ✅ Error handling and graceful degradation

## 📚 Key Concepts Covered

- **Constructor Injection** vs Field Injection
- **Optional<T>** for null safety
- **Business Methods** in domain models
- **Isolation Managers** for external dependencies
- **MapStruct** compile-time code generation
- **Spring Data JPA** repository patterns
- **WebClient** for external API calls
- **Swagger/OpenAPI** documentation
- **Layered architecture** principles

---

Built with ❤️ as a learning project for enterprise Java architecture patterns.
