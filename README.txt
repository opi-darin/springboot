Spring Boot RESTful webservice example using gradle with docker integration.

Basic customer webservice (id, first and last name only) using hard coded data, with GET/POST/PUT/DELETE implementations.

Requirements:

Java 8+, Docker, curl or Chrome Postman

Run using Gradle

1. ./gradlew bootRun
2. Test web service using curl or brower extension like Chrome Postman

   Examples:
       curl localhost:8080/customers
       curl localhost:8080/customers/1

Run using Docker

1. Build a Docker image

./gradlew build buildDocker

2. Run the Docker container

docker run -p 8080:8080 -t example-springboot

3. Test web service using curl or brower extension like Chrome Postman

   Examples:
       curl localhost:8080/customers
       curl localhost:8080/customers/1



Next steps that could be included in the example:
- real data store
- security for authentication/authorization
- data validation
- document the web service public api

