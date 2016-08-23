# Car Boot Sale

From Wikipedia:

> Car boot sales or boot fairs are a form of market in which private individuals come together to sell household and garden goods. They are popular in the United Kingdom, where they are often referred to simply as 'car boots'.

This is a very small application is an example that models a 'Car Boot Sale' program.

### Technology

- Spring Boot
- In Memory Database (HSQL)

### Dependent Libraries

- JUnit 4.12
- Apache Commons Lang

### Important Takeaways

no web.xml required

default uses Tomcat but can exclude this to use Jetty instead

just slap on @SpringBootApplication annotation to Application main class

need quite a lot of maven configuration on the pom.xml or gradle configuration on the build.gradle

schema.sql file in root classpath (resources) and Spring Boot will automatically use to create database schema

data.sql file in root classpath (resources) and Spring Boot will automatically use to initialize the database

logging is automatically configured (no need for even a log4j.properties/log4j.xml confiiguration file)

adding the spring-boot-starter-jdbc dependency will allow you to inject JdbcTemplate

can add application.properties to resources which you can configure whole lots of properties from database to logging

