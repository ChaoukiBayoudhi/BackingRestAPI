# Backing Rest API

A secure Rest API using spring-boot, spring-security and jwt.

## Tech stack

- Java 19, built with Maven
- Spring Boot 2.7.5
- Spring Web (REST controllers)
- Spring Data JPA (Hibernate)
- Spring Security
- Lombok
- PostgreSQL driver
- JJWT (JSON Web Tokens)
- Database: PostgreSQL (`bankingdb` in `application.properties`)

## Data model

| Entity | Fields |
|---|---|
| `User` | id, username, email, password, name, familyName, roles |
| `Account` | rib, createdDate, amount, thresholdValue, state, type, owner, bank, transactions |
| `Bank` | id, name, address, email, telephoneNumber, accounts |
| `Transaction` | id, dateTime, amount, type, ribOtherAccount, message, account |
| `Customer` | id, name, familyName, cin, birthDate, accounts |
| `Role` | id, name, users |

## REST endpoints

Found in the controllers (`CustomerController`, `AuthenticationController`):

| Method | Path |
|---|---|
| GET | `/` |
| GET | `/{id}` |
| POST | `/` |
| DELETE | `/{id}` |
| POST | `/api/auth/signup` |
| POST | `/api/auth/signin` |

## Project structure

- `tn.isg.mssi.BackingRestAPI`: BackingRestApiApplication
- `tn.isg.mssi.BackingRestAPI.Configurations`: WebSecurityConfig
- `tn.isg.mssi.BackingRestAPI.Entities`: Account, Bank, Customer, Role, Transaction, User
- `tn.isg.mssi.BackingRestAPI.Enumerations`: AccountState, AccountType, ERole, TransactionType
- `tn.isg.mssi.BackingRestAPI.PlayLoad`: JwtResponse, SigninRequest, SignupRequest
- `tn.isg.mssi.BackingRestAPI.Repositories`: CustomerRepository, RoleRepository, UserRepository
- `tn.isg.mssi.BackingRestAPI.Security.jwt`: AuthEntryPointJwt, JwtAuthFilter, JwtUtils
- `tn.isg.mssi.BackingRestAPI.Security.services`: UserDetailsImpl, UserDetailsServiceImpl
- `tn.isg.mssi.BackingRestAPI.Services`: AuthenticationService, CustomerService
- `tn.isg.mssi.BackingRestAPI.Web`: AuthenticationController, CustomerController
- Tests: 1 test class

## How to run

Requirements: a JDK 19+ and Maven (or the included Maven wrapper).
Create the `bankingdb` database and set your own username and password in `src/main/resources/application.properties`.

```bash
./mvnw spring-boot:run
```

The API then listens on `http://localhost:8080`.

---

Author: [Chaouki Bayoudhi](https://github.com/ChaoukiBayoudhi)
