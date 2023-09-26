
# Client APP Whitelist API
This is my implementation of a RESTful API programming task implemented in Java Spring.

# Requirements
- [Java 17 JDK](https://www.java.com/download/ie_manual.jsp)
- [Maven](https://maven.apache.org/download.cgi)
- [Docker](https://docs.docker.com/get-docker/)(Optional)

# Usage
The api exposes the following REST endpoints:
- `/whitelists` List of whitelisted clients, including the app id, dev environment, and IPv4 address
    - `/whitelists/{id}` Get a specific whitelist based on the whitelist ID
- `/whitelisted-ips` List of whitelisted IPv4 addresses only
- `/clients` List of clients
    - `/clients/{id}` Get a specific client based on ID
- `/apps` List of applications
    - `/apps/{id}` Get a specific application based on ID

# Docker
To automatically manage dependencies and run application, you can run the application
within a docker container by going to the project directory, 
and pasting the following command in a terminal.

```
docker build -t client-api-whitelist .
docker run -p 8080:9090 client-api-whitelist
```

# Building

Alternatively, to compile and run the program into a jar file yourself,
run the command

```
mvn clean spring-boot:run
```

# Testing
The project uses Maven Surefire and JUnit Jupiter to run tests.
All of the tests can be found in `tests/`, and can be run using the command
```
mvn test
```

# TODO
- [ ] Fix persistence in database--data initialization scripts don't run
      when the h2 database is persistent for some reason
- [ ] Create Error pages for invalid requests
- [ ] Add JWT Auth to API requests
