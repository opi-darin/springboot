Simple Spring Boot RESTful webservice example using gradle with docker integration.

Basic customer webservice (id, first and last name only) using hard coded data, with GET/POST/PUT/DELETE implementations.

Requirements:

Java 8+, Gradle, Docker, curl or Chrome Postman

Build:

Run the gradle build to compile, test, and assemble the code into a JAR file.

gradle build

Run the application

java -jar build/libs/example-springboot-1.0.0.jar

Or

Build a Docker image

gradle build buildDocker

Run the Docker container
docker run -p 8080:8080 -t example-springboot

Usage:

Use a tool like curl or Chrome Postman to try it out!

Examples:

curl localhost:8080/customers
curl localhost:8080/customers/1

Next steps that could be included in the example:
- real data store
- security for authentication/authorization
- data validation
- document the web service public api

