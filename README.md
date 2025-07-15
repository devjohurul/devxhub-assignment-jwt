# DevXHub

A Spring Boot application providing JWT-based authentication and role-based access control for user management.

## Features

- JWT authentication for secure endpoints
- In-memory and database user support
- Role-based access for `USER` and `ADMIN`
- RESTful endpoints for login, user creation, and protected resources

## Endpoints

- `POST /login` — Authenticate and receive a JWT token
- `GET /public` — Public endpoint, no authentication required
- `GET /user` — Requires `USER` or `ADMIN` role
- `GET /admin` — Requires `ADMIN` role
- `POST /users` — Create a new user (admin only)

## Setup & Run

1. **Clone the repository:**
2. **Configure application properties:**
   - Set `jwt.secret` and `jwt.expiration` in `src/main/resources/application.properties`.

3. **Build and run:**
4. **Test endpoints:**
   - Use Postman or curl to interact with the API.

## Assumptions

- JWT secret and expiration are set in properties.
- Database configuration is required for persistent users.
