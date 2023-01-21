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



## Scenario
- [x] New customers can be defined with name, surname, identification number and email in the system, existing customers can be updated except identification number or deleted.
- [x] Account can be created for a user with balance and currency
- [x] Transfer balance between two accounts if they have the same currency, otherwise send an error.  
- [x] If transfer is between different users, response informative note.

- [x] Making some services private for authenticated user
- [x] Swagger Integration
- [x] Deploying code to somewhere (Heroku, AWS, DigitalOcean etc.)
