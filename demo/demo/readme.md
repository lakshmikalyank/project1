# 🌤️ Full-Stack Weather Application

A modern, full-stack Java web application that allows users to search, track, and manage real-time weather details for various cities. Built using the **Spring Boot (MVC)** architecture, it communicates securely with a persistent relational database and seamlessly renders a dynamic, responsive frontend dashboard.

---

## 🚀 Key Features

* **Real-Time Weather Lookup:** Search for current weather metrics (Temperature, Humidity, Wind Speed, Weather Conditions) by city name.
* **Persistent Dashboard:** Save favorite cities to a personalized dashboard to track their weather updates instantly.
* **Full CRUD Functionality:** Easily add new cities, view stored weather data, update notes/metrics, or remove cities from your tracker.
* **Automated Table Generation:** Utilizes Object-Relational Mapping to instantly build database layouts upon application startup.

---

## 🛠️ Tech Stack & Architecture

This project follows a decoupled **3-Tier Production Architecture**:

* **Frontend (Presentation Layer):** Built with **HTML5**, **CSS3**, and **Thymeleaf**. Thymeleaf dynamically binds backend Java models into the user interface layout.
* **Backend (Application Logic Layer):** Powered by **Java 21** and **Spring Boot**. Utilizes Spring Web MVC to manage request routing, services, and secure controllers.
* **Database (Storage Layer):** Managed via a local **MySQL** relational instance. Uses **Spring Data JPA (Hibernate)** as an Object-Relational Mapper to seamlessly translate Java entities into SQL records.

---

## 📦 Prerequisites

Ensure you have the following installed locally before launching the application:
* **Java Development Kit (JDK 17 or 21)**
* **MySQL Server** (Running locally on port 3306)
* An IDE (Visual Studio Code, IntelliJ IDEA, or Eclipse)
* **Maven** (For dependency management)

---

## ⚙️ Local Setup and Installation

### 1. Database Configuration
Log into your local MySQL terminal or workbench and initialize a fresh database container:
```sql
CREATE DATABASE weather_db;
spring.datasource.url=jdbc:mysql://localhost:8085/weather_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=YOUR_MYSQL_USERNAME
spring.datasource.password=YOUR_MYSQL_PASSWORD

# Hibernate properties to automatically update tables
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
# Compile and package the application
mvn clean install

# Spin up the embedded Tomcat server
mvn spring-boot:run
├── src
│   ├── main
│   │   ├── java/com/example/weatherapp
│   │   │   ├── controller/   # Web request routers & mappings
│   │   │   ├── model/        # Database Entity Blueprints (Java Objects)
│   │   │   ├── repository/   # Data Access Interfaces (JPA / SQL queries)
│   │   │   └── service/      # Core Business Rules & Math logic
│   │   └── resources
│   │       ├── templates/    # Thymeleaf HTML views
│   │       ├── static/       # CSS stylesheets and images
│   │       └── application.properties # Server & DB Configurations
└── pom.xml                   # Maven Dependency Management Sheet