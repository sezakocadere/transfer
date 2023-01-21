# Transfer

A **Spring Boot** application which is used to serve **Rest APIs** and perform database operations. Used **JPA** to interact with **H2 database**.


## API DOCS

Type | API Request | Info |
|--|--|--|
| GET | /customers |List all customers|
| POST | /customers |Create a customer with name, surname, tckn and email|
| PUT | /customers/{customerId}|Update the customer's data except identification number(tckn)|
| DELETE | /customers/{customerId} |Remove an account of a customer (makes the status is passive)|
| GET | /accounts/{customerId} |Get all accounts of a customer|
| POST | /accounts |Create an account for a customer with balance and currency|
| DELETE | /accounts/{accountId} |Remove an account of a customer (makes the status is passive)|
| GET | /transfer|Lists all transfers|
| POST | /transfer |Transfer amount between two accounts if they have the same currency and enough balance|


## H2 Memory Database
http://localhost:9090/h2-console/
```
username: sa

password: 1234567
```

## Basic Authentication
Login with the following credentials:
```
username: user

password: 123
```
You are free to reach other endpoints.
## Swagger Integration
https://transfer-seza.herokuapp.com/swagger-ui.html

