# Soccer API

This project is a minimal demo of a soccer management API built with Spring Boot following a hexagonal architecture with a simple command and query bus.
Domain entities now use small value objects for identifiers to better express intent.

## Modules
- **Teams**: Manage team creation and listing.
- **Players**: Register players for teams.
- **Scores**: Provides standings and top scorer tables.

## Build and Run
Use Maven to build and run the project:
```bash
mvn spring-boot:run
```

Run tests with:
```bash
mvn test
```
