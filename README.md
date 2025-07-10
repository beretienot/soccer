# Soccer API

This project is a minimal demo of a soccer management API built with Spring Boot following a hexagonal architecture with a simple command and query bus.
Domain entities now use small value objects for identifiers to better express intent.

## Modules
- **Teams**: Manage team creation and listing.
- **Players**: Register players for teams.
- **Scores**: Provides standings and top scorer tables.

## Build and Run
Use Gradle to build and run the project:
```bash
./gradlew bootRun
```

Run tests with:
```bash
./gradlew test
```

The project includes Gradle wrapper scripts, so no local installation is
required.

## Environment
Create a `.env` file in the project root to supply environment variables when
running the application locally. The VS Code launch configuration will load
variables from this file automatically.

## License

This project is licensed under the [MIT License](LICENSE).

