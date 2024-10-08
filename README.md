# Night Bar Application

## Table of Contents
- [Project Overview](#project-overview)
- [Technologies Used](#technologies-used)
- [Application Structure](#application-structure)
- [Strategy Pattern](#strategy-pattern)
- [Using Postman](#using-postman)
- [API Endpoints](#api-endpoints)

## Project Overview

The Night Bar application is a simple RESTful API that manages drinks and orders for a night bar. It utilizes a strategy pattern to implement different pricing strategies based on the time of day. Users can add drinks, create orders, and calculate total bills efficiently.

## Technologies Used

- **Java**: The primary programming language used for backend development.
- **Spring Boot**: Framework for building the RESTful API, providing features like dependency injection, web development, and more.
- **JPA/Hibernate**: For object-relational mapping (ORM) and database interaction.
- **Postman**: A tool for testing API endpoints.
- **Maven**: Build automation tool used for managing project dependencies.

## Application Structure

The application is organized into the following main packages:

- **controller**: Contains REST controllers that handle incoming HTTP requests and return responses.
- **model**: Defines the data models for drinks and orders.
- **repository**: Interfaces for data access, typically extending Spring Data JPA repositories.
- **service**: Contains the business logic, including order creation and drink management.

## Strategy Pattern

The application employs the **Strategy Pattern** to manage different pricing strategies for drinks based on the time of day. This pattern allows the application to encapsulate different algorithms (in this case, pricing strategies) and make them interchangeable:

- **NormalPricingStrategy**: Applies a regular pricing scheme.
- **DiscountedPricingStrategy**: Applies a discount during specific hours.

By using this pattern, the code remains clean, and the logic for pricing can be modified or extended without altering the core business logic.

## Using Postman

Postman is a powerful tool for testing and interacting with APIs. To use Postman with the Night Bar application:

1. **Install Postman**: Download and install Postman from [Postman's official website](https://www.postman.com/downloads/).
2. **Start the Application**: Run your Spring Boot application (default port: `8080`).
3. **Create Requests**:
   - Open Postman and create a new request.
   - Set the HTTP method (GET, POST, etc.) and the request URL.

### Example Requests

#### 1. Add a Drink

- **Method**: POST
- **URL**: `http://localhost:8080/api/v1/drinks`
- **Body** (JSON):
  ```json
  {
      "name": "Coke",
      "normalPrice": 2.5
  }
``

#### 2. Create an Order

- **Method**: POST
- **URL**: `http://localhost:8080/api/v1/orders`
- **Body** (JSON):
```json
{
    "drinkIds": [1, 2, 3]
}
```
#### 3. Get All Orders

- **Method**: GET
- **URL**: `http://localhost:8080/api/v1/orders`

## API Endpoints

Here’s a summary of the main API endpoints available:

- **GET /api/v1/drinks**: Retrieve a list of all drinks.
- **POST /api/v1/drinks**: Add a new drink to the menu.
- **POST /api/v1/orders**: Create a new order by specifying drink IDs.
- **GET /api/v1/orders**: Retrieve a list of all orders.

  [See the presentation](https://www.canva.com/design/DAGS_dPh3h8/xwfY3t7wLDEiY4FtCkwPHw/edit?utm_content=DAGS_dPh3h8&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton)

