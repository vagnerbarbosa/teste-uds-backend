# Processo seletivo UDS Tecnologia - Java

Açai API.

### Main Technologies

- [JDK 8](https://www.oracle.com/technetwork/java/javase/14u-relnotes-6361871.html)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data](https://spring.io/projects/spring-data)
- [Hibernate ORM](https://hibernate.org/orm/)
- [Mockito](https://site.mockito.org/)

## Running the Application

> **8080** it's the port where the api is available - make sure the port is free

- At the terminal, execute the command `docker pull postgres:9.6.17`;
- Then run the command `docker run --publish 5432:5432 --name postgres -e POSTGRES_PASSWORD=123 -d postgres`
- Already at the root of the project execute `mvn clean install`;
- And finally, `java -jar target/teste-uds-backend-0.0.1-SNAPSHOT.jar`

## Running the tests

- At the terminal, execute `mvn test` to run the tests.

## About me:
- Vagner Barbosa
- e-mail: contato@vagnerbarbosa.com







