# Loan Management System

This project is a simple Loan Management System implemented in Java using Hibernate for ORM and Oracle as the database.

## Project Structure

The project is structured into different packages:

- `com.arpit.model`: Contains the entity classes `LoanAgreement`, `LoanProduct`, and the enum `LoanStatus`.
- `com.arpit.question3`: Contains the DAO classes `LoanAgreementDao` and `LoanProductDao` for performing CRUD operations on the `LoanAgreement` and `LoanProduct` entities respectively. It also contains the `TestMain` class which is the entry point of the application.

### LoanAgreement

This class represents a loan agreement in the system. It contains details about the loan such as the loan product, loan amount, tenure, rate of interest, loan status, EMI per month, loan disbursal date, and repayment frequency. It also contains methods to calculate EMI, generate a repayment schedule, calculate late penalty, and calculate loan-to-value ratio.

### LoanProduct

This class represents a loan product in the system. It contains details about the product such as the product name.

### LoanStatus

This is an enum that represents the status of a loan. It can be PENDING, APPROVED, REJECTED, ACTIVE, or CLOSED.

### LoanAgreementDao

This class provides the CRUD operations for `LoanAgreement` entities. It uses Hibernate to interact with the database.

### LoanProductDao

This class provides the CRUD operations for `LoanProduct` entities. It uses Hibernate to interact with the database.

### TestMain

This is the entry point of the application. It demonstrates the usage of the `LoanAgreementDao` and `LoanProductDao` classes by performing various operations such as creating, reading, updating, and deleting `LoanAgreement` and `LoanProduct` entities.

## Setup

1. Clone the repository to your local machine.
2. Open the project in your preferred IDE (The project is set up with Maven for dependency management).
3. Update the `hibernate.cfg.xml` file with your Oracle database credentials.
4. Run the `TestMain` class to start the application.

## Usage

The `TestMain` class demonstrates the usage of the `LoanAgreementDao` and `LoanProductDao` classes. It performs the following operations:

- Creates two `LoanProduct` entities and saves them to the database.
- Creates two `LoanAgreement` entities, associates them with the `LoanProduct` entities, and saves them to the database.
- Retrieves the `LoanAgreement` entities from the database and prints them.
- Updates a `LoanAgreement` entity and saves the changes to the database.
- Deletes a `LoanAgreement` entity from the database.


## License

[Arpit](https://choosealicense.com/licenses/Arpit/)