# Data Ingest Application

This is a Spring Boot application designed for data ingestion using an embedded database. The application leverages `CompletableFutures` for asynchronous processing, allowing for efficient handling of data ingestion tasks.

## Project Structure

The project follows a standard Spring Boot structure with the following key components:

- **src/main/java/com/example/ingest**: Contains the main application code.
  - **DataIngestApplication.java**: The entry point of the Spring Boot application.
  - **controller**: Contains the `IngestController` for handling HTTP requests.
  - **service**: Contains the `IngestService` for business logic and `AsyncService` for asynchronous processing.
  - **repository**: Contains the `RecordRepository` for database operations.
  - **model**: Contains the `RecordEntity` representing the data model.
  - **dto**: Contains the `RecordDto` for data transfer.
  - **config**: Contains the `AsyncConfig` for configuring asynchronous capabilities.
  - **util**: Contains the `Mapper` for converting between entities and DTOs.

- **src/main/resources**: Contains configuration and initialization files.
  - **application.properties**: Configuration properties for the application.
  - **data.sql**: SQL statements to initialize the embedded database.

- **src/test/java/com/example/ingest**: Contains unit tests for the application.
  - **IngestServiceTest.java**: Tests for the `IngestService`.
  - **IngestControllerTest.java**: Tests for the `IngestController`.

- **pom.xml**: Maven configuration file specifying dependencies and build settings.

## Setup Instructions

1. **Clone the repository**:
   ```
   git clone <repository-url>
   cd data-ingest-app
   ```

2. **Build the application**:
   ```
   ./mvnw clean install
   ```

3. **Run the application**:
   ```
   ./mvnw spring-boot:run
   ```

4. **Access the API**:
   The application exposes an endpoint for data ingestion. You can use tools like Postman or curl to send HTTP requests to the API.

## Usage

To ingest data, send a POST request to the `/ingest` endpoint with the required data in the request body. The application will process the request asynchronously and store the data in the embedded database.

## License

This project is licensed under the MIT License. See the LICENSE file for more details.