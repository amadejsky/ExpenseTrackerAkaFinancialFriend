# Expense Manager Application

![FinancialFriendApp](https://github.com/amadejsky/Resources/blob/main/Mockup/FinancialFriendApp.png?raw=true)

This Expense Manager application is built using Java Spring framework with Thymeleaf and Bootstrap for the frontend.

## Features

- **Add Expense**: Allows users to add new expenses with amount, category, and optional description.
- **View Report**: Provides a report of all expenses entered, displaying amount, category, and description.
- **Delete Expense**: Supports deletion of expenses from the report.

## Screenshots

### Landing Page
![FinancialFriendLandingPage](https://github.com/amadejsky/Resources/blob/main/Mockup/FinancialFriendLandingPage.png?raw=true)

### Report Page
![FinancialFriendReport](https://github.com/amadejsky/Resources/blob/main/Mockup/FinancialFriendReport.png?raw=true)

### Unit Tests Execution
![FinancialFriendUnitTests](https://github.com/amadejsky/Resources/blob/main/Mockup/FinancialFriendUnitTests.png?raw=true)

## Technologies Used

- **Java Spring Boot**: Backend framework for building robust Java applications.
- **Thymeleaf**: Server-side Java template engine for rendering HTML templates.
- **Bootstrap**: Frontend framework for building responsive and mobile-first websites.
- **JUnit**: Unit testing framework for Java.

## Getting Started

To run this application locally:

1. Clone this repository.
2. Make sure you have Java JDK and Maven installed.
3. Configure your database settings in `application.properties`.
4. Build and run the application using Maven: `mvn spring-boot:run`.
5. Access the application at `http://localhost:8080`.

## Testing

This application includes unit tests for different functionalities such as adding expenses, deleting expenses, and handling invalid data scenarios.

To run the unit tests:

```bash
mvn test
