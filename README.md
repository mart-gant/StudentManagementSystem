# Student Management System

## Overview

The Student Management System is a web-based application developed using Spring Boot. It allows for the management of student information, including creating, reading, updating, and deleting (CRUD) student records. The application exposes a RESTful API for interaction with the backend.
## Features

- **CRUD Operations**: Manage student records with full Create, Read, Update, and Delete functionality.
- **Validation**: Input data is validated using Hibernate Validator annotations to ensure data integrity.
- **Exception Handling**: Custom exception handling to manage errors effectively.
- **Testing**: Unit tests are implemented using JUnit and Mockito to ensure reliability.
- **Database Integration**: Data is persisted using Hibernate with MySQL as the database.

## Technologies Used

- **Java 17**
- **Spring Boot 3**
- **Hibernate**
- **MySQL**
- **Maven**
- **JUnit 5**
- **Mockito**
- **Spring Data JPA**

## Getting Started

### Prerequisites

- Java 17 or later
- Maven 3.6+
- MySQL

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/yourusername/student-management-system.git
    cd student-management-system
    ```

2. Set up the MySQL database:

    - Create a database named `student_management`.
    - Update the `src/main/resources/application.properties` file with your MySQL credentials:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/student_management
    spring.datasource.username=your_mysql_username
    spring.datasource.password=your_mysql_password
    ```

3. Build and run the application:

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

4. Access the application:

    The API will be available at `http://localhost:8080`.

### API Endpoints

- **GET /students** - Retrieve all students
- **GET /students/{id}** - Retrieve a specific student by ID
- **POST /students** - Create a new student
- **PUT /students/{id}** - Update an existing student
- **DELETE /students/{id}** - Delete a student by ID

### Testing

Unit tests are provided to ensure the correctness of the service layer. To run the tests, use the following Maven command:

```bash
mvn test
