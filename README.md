# CustomerDetail 

**Description**

The CustomerDetail class is responsible for managing customers and Customer Service Representatives (CSRs) within an online shopping system. It provides functionalities such as viewing, deleting, updating, and logging in users.

**Features**

Customer Management:

View all customers

Delete a customer by ID

Customer login

**CSR Management:**

View all CSRs

Update CSR details

Delete a CSR by ID

**Ticket Management:**

Resolve customer tickets

Handle customer reviews

Prerequisites

**Before using this class, ensure that:**

Java Development Kit (JDK) is installed

MySQL database is configured with OnlineShopping schema

JDBC driver for MySQL is available

JPA is configured with an EntityManager

Custom exception handling (SomthingWentWrongException) is implemented

**Database Connection**

The class connects to a MySQL database with the following credentials:

URL: jdbc:mysql://localhost:3306/OnlineShopping

User: root

Password: Sunny@123

Note: Update database credentials before deploying the application to production.

Methods Overview

public static void Customers(Scanner sf) throws SomthingWentWrongException

**Manages customer operations:**

View all customers

Delete a customer by ID

public static void getallCustomer()

Retrieves and prints all customer details from the Customer_credential table.

public static void DeleteCustomer(int id) throws SomthingWentWrongException

Deletes a customer by ID using JPA. Throws an exception if the customer is not found.

public static void coustmerLogin(String email)

Fetches customer details based on their email from the Csr table.

public static void updateCsr(String email, Scanner sg) throws SomthingWentWrongException

Allows updating a CSR’s details such as name, email, mobile number, and password.

public static void Csr(Scanner sf) throws SomthingWentWrongException

**Manages CSR operations:**

View all CSRs

Delete a CSR by ID

public static void ViewAllCsrs()

Fetches and displays all CSRs from the Csr table.

public static void DeleteCsr(int id) throws SomthingWentWrongException

Deletes a CSR by ID using JPA. Throws an exception if the CSR is not found.

**How to Run**

Ensure the database is running and the necessary tables exist.

Compile and run the Java application.

Follow the menu options to manage customers and CSRs.

**Exception Handling**

SomthingWentWrongException is thrown when an operation fails (e.g., deleting a non-existent customer or CSR).

Database connection failures should be handled properly to avoid crashes.

**Notes**

Remove stm.execute(query); from coustmerLogin and ViewAllCsrs to prevent redundant execution.

Improve user input validation to prevent SQL injection vulnerabilities.

Consider using prepared statements for database queries to enhance security.

**Author**

This class is part of an online shopping system project aimed at simplifying customer and CSR management.
