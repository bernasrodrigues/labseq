# Labseq Application

## Overview

The Labseq application is a full-stack project consisting of a backend service and a frontend user interface. The backend is implemented using Quarkus (Java), and the frontend is developed using Angular.

### Backend

The backend service provides an endpoint to compute and retrieve values from the Labseq sequence, which is a sequence defined by a recursive relation. It uses caching to optimize performance.

### Frontend

The frontend is a simple Angular application that allows users to input a number and retrieve the corresponding Labseq value from the backend. It features error handling and a user-friendly interface.

## Running Locally
Download project
### BackEnd

1. **Navigate to the backend directory (labseq)**:
   ```bash
   cd path/to/labseq
   ./mvnw quarkus:dev

This command starts the Quarkus application in development mode. The service will be available at http://localhost:8080.


### FrontEnd
1. **Navigate to the backend directory (labseq/labseq_ui)**:
    ```bash
   cd path/to/labseq/labseq-ui
   npm install      (to install dependencies)
   ng serve

This command starts the Angular development server. The application will be available at http://localhost:4200.


## Running with Docker
### Building Docker Images
1. **Navigate to the root directory.**
2. **Build the Docker image for the backend:** 
    ```bash
    docker build -f src/main/docker/Dockerfile.jvm -t quarkus/labseq_service-jvm .
3. **Build the Docker image for the frontend:**
    ```bash
    docker build -t angular-labseq-ui .  
4. **Build the Docker image for the backend:**
    ```bash
     docker run -i --rm -p 8080:8080 quarkus/labseq_service-jvm
This command starts the backend service in a Docker container and maps port 8080 on your host to port 8080 in the container.
5. **Build the Docker image for the frontend:**
    ```bash
   docker run -d -p 4200:80 angular-labseq-ui         
This command starts the frontend application in a Docker container and maps port 4200 on your host to port 80 in the container.

## Accessing the Application
 Frontend: Open your browser and go to http://localhost:4200.

 Backend: The API is available at http://localhost:8080/labseq/{n}, where {n} is the index of the Labseq sequence.


## Overview

The Labseq application is a full-stack project consisting of a backend service and a frontend user interface. The backend is implemented using Quarkus (Java), and the frontend is developed using Angular.

### Backend

The backend service provides an endpoint to compute and retrieve values from the Labseq sequence, which is defined by a recursive relation. It uses caching to optimize performance and follows the REST architecture for API interaction.

### Frontend

The frontend is a simple Angular application that allows users to input a number and retrieve the corresponding Labseq value from the backend. It features error handling to ensure users receive appropriate feedback.

## Project Structure

### Backend

- **`src/main/java/com/example/resource/LabseqResource.java`**: Defines the REST endpoint for retrieving Labseq values.
- **`src/main/java/com/example/service/LabseqService.java`**: Contains the business logic for computing Labseq values and caching them.
- **`Dockerfile`**: Contains instructions to build the Docker image for the backend.

### Frontend

- **`src/app/labseq/labseq.component.ts`**: Contains the logic for fetching Labseq values from the backend and handling user input.
- **`src/app/labseq/labseq.component.html`**: Provides the HTML template for user interaction.
- **`src/app/labseq/labseq.component.css`**: Contains styles for the Labseq component.
- **`Dockerfile`**: Contains instructions to build the Docker image for the frontend.