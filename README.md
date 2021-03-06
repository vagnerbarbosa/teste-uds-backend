# Açaí API - Java

Rest WebService with Spring Boot.

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

## API endpoints

> http://localhost:8080/acais ** REQ.001 - Escolher açaí **
- JSON Body consumes example via POST `{ "size": "PEQUENO", "flavor": "KIWI" }`

> http://localhost:8080/acais/{id} ** REQ.002 - Personalizar açaí **
- JSON Body consumes example via POST`[ "GRANOLA", "LEITE_NINHO", "PACOCA" ]`

> http://localhost:8080/acais/{id} ** REQ.003 - Montar pedido **
- JSON Body produces example via GET`{ "size": "Pequeno", "flavor": "Kiwi", "additionals": "Granola / Leite Ninho / Paçoca", "preparationTime": "00:13:00", "total": 16.00 }`
## Running the tests

- At the terminal, execute `mvn test` to run the tests.

## About me
- Vagner Barbosa
- e-mail: contato@vagnerbarbosa.com







