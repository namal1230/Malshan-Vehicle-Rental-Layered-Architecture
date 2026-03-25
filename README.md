# Layered Architecture Project

![Java](https://img.shields.io/badge/Java-17-blue)
![Maven](https://img.shields.io/badge/Maven-3.8.0-orange)

---

## Overview

This project demonstrates the application of **Layered Architecture (N‑Tier)** to organize a Java application into separate logical layers.  
Instead of a single monolithic MVC structure, the code is separated into clear layers to improve **maintainability, testability, and separation of concerns**. :contentReference[oaicite:1]{index=1}

Layered architecture is a software design pattern in which parts of an application are structured into discrete layers, where each layer has a specific responsibility and depends only on the layer below it. It’s one of the most common ways to divide and organize software systems. :contentReference[oaicite:2]{index=2}

---

## Layers in this Project

This project follows a typical layered structure:

1. **Presentation Layer (UI / Controller)**  
   - Handles user interaction or incoming requests

2. **Service / Business Logic Layer**  
   - Contains application logic, validations, and business rules

3. **Data Access Layer (DAO / Repository)**  
   - Encapsulates database operations and persistence

4. **Model / DTO layer**  
   - Defines data structures passed between layers

Each layer depends only on the next lower one, making the system easier to maintain and scale. :contentReference[oaicite:3]{index=3}

---

## Features

- Clear separation of concerns (Layered Architecture)
- Modular and easy‑to‑navigate project structure
- Reusable business logic
- Easy to extend and maintain
- Prepared for future enhancements (e.g., service injection)

---

## Technologies Used

- **Java** (Core Java, OOP)
- **Maven** (Build & dependency management)
- N‑Tier / Layered Architecture design

---

## Project Structure (Example)

```text
Layered-Architecture-Project/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── controller/     # Presentation / UI layer
│   │   │   ├── service/        # Business logic layer
│   │   │   ├── dao/            # Data access layer
│   │   │   └── dto/            # Data transfer / models
│   │   └── resources/          # Config files (if any)
│
├── pom.xml                     # Maven config
├── README.md
└── .gitignore
````

---

## Setup Instructions

1. **Clone the repository**

```bash
git clone https://github.com/namal1230/Layered-Architecture-Project.git
```

2. **Open in your IDE**

   * Load the project in IntelliJ IDEA, Eclipse, or any Java IDE.

3. **Build the project**

```bash
mvn clean install
```

4. **Run the application**

* From your IDE: Run the main class
* From command line after building a runnable JAR (if configured):

```bash
java -jar target/<YourJar>.jar
```

---

## Why Layered Architecture?

Layered architecture is a widely used pattern that makes software easier to maintain and scale because each layer:

* Focuses on a single responsibility
* Can be tested independently
* Can be modified without affecting other layers

The dependency direction is typically top → bottom (presentation → logic → data). ([l-lin.github.io][2])

---

## License

This repository is open for learning and experimentation — feel free to fork and explore.

---

## References (MVC Architecture)

This project is an **enhanced version of the previous MVC-based project**, converted into a **Layered Architecture** for better separation of concerns and maintainability.

- [Malshan Vehicle Rent Shop Management System (Original MVC Project)](https://github.com/namal1230/MALSHAN-VEHICLE-RENT-SHOP-MANAGEMENT-SYSTEM)
