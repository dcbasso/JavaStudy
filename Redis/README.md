# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.0/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.0/gradle-plugin/reference/html/#build-image)
* [Spring Data Redis (Access+Driver)](https://docs.spring.io/spring-boot/docs/2.7.0/reference/htmlsingle/#data.nosql.redis)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.0/reference/htmlsingle/#web)

### Guides
The following guides illustrate how to use some features concretely:

* [Messaging with Redis](https://spring.io/guides/gs/messaging-redis/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

### DOCKER REDIS

docker run --name redis-study redis -p 6379:6379

### DETAILS

Using CrudRepository from Spring, with standalone Docker/Redis config.

### MORE ABOUT

- https://www.baeldung.com/spring-data-redis-tutorial
- https://docs.spring.io/spring-data/data-redis/docs/current/reference/html/

### Integration Tests

Using testcontainers we can create and use a real docker connection to test the integration with database.

See more:  https://www.testcontainers.org/

### This Project Uses

- Java SDK: 17
- Spring Boot: 2.7.0
- Test Containers: 1.17.2
- Junit: 5.8.1
- Apache Commons: 3.12.0
- Lombok
