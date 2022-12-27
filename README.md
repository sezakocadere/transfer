# Transfer

A Spring Boot application which is used to serve Rest APIs and perform database operations. Used JPA to interact with H2 database.

## API DOCS
### Customer 
> **/customers (GET) :** List All Customers.

> **/customers (POST) :** Create a customer with name, surname, tckn and email.

> **/customers/{customerId} (PUT) :** Update the customer's data except identification number(tckn).

> **/customers/{customerId} (DELETE) :** Remove an account of a customer (makes the status is passive).

### Account
> **/accounts/{customerId} (GET) :** Get all accounts of a customer.

> **/accounts (POST) :** Create an account for a customer with balance and currency.

> **/accounts/{accountId} (DELETE) :** Remove an account of a customer (makes the status is passive).

### Transfer
> **/transfer (GET) :** Lists All Transfers.

> **/transfer (POST) :** Transfer amount between two accounts if they have the same currency and enough balance.

## H2 Memory Database
http://localhost:9090/h2-console/

username: sa

password: 1234567


## Basic Authentication

username: user

password: 123

## Swagger Integration
https://transfer-seza.herokuapp.com/swagger-ui.html

