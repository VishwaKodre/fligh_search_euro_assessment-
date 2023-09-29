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

## Setting Up Couchbase Bucket and Adding Flight Data

Before running the Flight Status Service, you'll need to set up a Couchbase bucket named "flight-search-service" and add flight data as documents. Follow these steps:

1. **Access Couchbase Console**: Open a web browser and navigate to the Couchbase Web Console at `http://localhost:8091` (or the URL where your Couchbase instance is running).

2. **Log In**: Log in to the Couchbase Console using the credentials you configured in the `docker-compose.yml` file.

3. **Create a Bucket**:
   - Click on the "Buckets" tab in the Couchbase Console.
   - Click the "Create Bucket" button.
   - Enter "flight-search-service" as the bucket name.
   - Set any desired configurations such as the bucket's memory quota and replica count.
   - Click the "Create Bucket" button to create the "flight-search-service" bucket.

4. **Add Flight Data as Documents**:
   - Click on the "Buckets" tab and select the "flight-search-service" bucket.
   - In the "Documents" tab, click the "Create Document" button.
   - In the document editor, paste the following payload as a JSON document. You can use this as a template and modify it for different flight entries:

   ```json
   {
     "flightNumber": "BA123",
     "departureAirportCode": "JFK",
     "departureAirportName": "John F. Kennedy International Airport",
     "departureTime": "2023-09-27T08:00:00Z",
     "arrivalAirportCode": "LHR",
     "arrivalAirportName": "London Heathrow Airport",
     "arrivalTime": "2023-09-27T12:00:00Z",
     "status": "On Time",
     "flightRoute": [
       {
         "airportCode": "ORD",
         "airportName": "Chicago O'Hare International Airport"
       },
       {
         "airportCode": "DFW",
         "airportName": "Dallas/Fort Worth International Airport"
       }
     ]
   }

### Configuration 
The application's configuration can be modified in the application.properties file, and Couchbase configuration can be adjusted in the docker-compose.yml file.