FROM maven

COPY . /opt/client-whitelist-api
WORKDIR /opt/client-whitelist-api

ENTRYPOINT mvn clean spring-boot:run
