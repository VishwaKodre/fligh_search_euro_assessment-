# Flight Status Service

The Flight Status Service is a Spring Boot application that provides flight status updates, including departure time, arrival time, flight route, flight number, and status (e.g., on time or delayed).

## Technologies Used

- **Spring Boot**: The core framework for building the application.
- **Java**: The programming language used for the application.
- **Maven**: The build tool and dependency management.
- **Couchbase**: The database used to store flight information.
- **Docker**: The containerization platform used for deployment.

## Prerequisites

Before you begin, ensure you have the following software installed:

- Docker: [Install Docker](https://www.docker.com/get-started)

## Running the Application with Docker Compose

You can easily run the Flight Status Service and Couchbase using Docker Compose. Follow these steps:

1. **Clone the Project**: Clone this repository to your local machine.

2. **Build the Application**: Open a terminal and navigate to the project's root directory where the `docker-compose.yml` file is located.

3. **Build the Docker Images**: Build the Docker images for the Flight Status Service and Couchbase using the following command:

   ```shell
   docker-compose build
   ```
4. **Start the Containers**: Run the Docker Compose command to start the containers
   ```shell
   docker-compose build
   ```
This command will start both the Flight Status Service and Couchbase containers, linking them together.

**Access the Application**: Once the containers are up and running, you can access the Flight Status Service in your web browser by navigating to http://localhost:8080.

**Access the Couchbase Console**: You can also access the Couchbase Web Console by navigating to http://localhost:8091. Use the credentials you configured in the docker-compose.yml file.

**API Documentation**: The API documentation for the Flight Status Service is available at http://localhost:8080/swagger-ui.html when the application is running. You can use this documentation to explore and test the available endpoints.

**Shut Down the Containers**: When you're finished, you can stop the containers by pressing Ctrl+C in the terminal where Docker Compose is running.

### Configuration
The application's configuration can be modified in the application.properties file, and Couchbase configuration can be adjusted in the docker-compose.yml file.