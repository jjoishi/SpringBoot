The course introduces the fundamentals of Spring Boot. Some of the cases that will be addressed in this course are condiguring a spring application, developing REST api, building a GraphQL server, making your application production ready, and writing unit & integration tests in Spring Boot. At the end of the project, we will develop a TrackZilla - a bug tracking application using Spring Boot.

# Table of Contents
* [Introduction to Spring Boot](https://github.com/jjoishi/SpringBoot/tree/master/Tutorials/5.%20Spring%20Boot%20Fundamentals#introduction-to-spring-boot)

# Introduction to Spring Boot
   Spring Boot sits on top of various other spring projects like Spring Data, Spring MVC, Spring security, etc. and is used to **boot** up your entire Spring application with very little configurations. As seen in previous courses, there were XML confguration, and then Annotation based configurations options. All of these didn't entirely solve the problem. Another issue - web applications usually have the same structure with configurations, controllers, service layers, data layer , databases, etc. These parts more or less are boiler plate to an application. The below image (copyrights to Spring Boot Fundamentals course by Kesha Williams) shows the typical layout of a web project -
   <img src = "https://github.com/jjoishi/SpringBoot/blob/master/Tutorials/5.%20Spring%20Boot%20Fundamentals/images/1.%20spring_boot_intro/TypicalWebApplication.PNG"/>

   Spring Boot solves the above problem with configurations and dependency management and deployment. It facilitates single step deployment because it auto configures all the dependency and the applications just runs. Spring Boot comes with servlet containers/servers where your applications can be deployed.

   Main features of Spring Boot includes - 
   
   * **Automatic Configuration**: It configures the application automatically based on te libraries or dependencies that you have added to your pom.xml. For eg, if you add a dependency to MySQL database, it will make sure that all database connection objects, query formats are wrapped in that format without user intervention.

   * **Starter Dependencies**: If you include starter mvn dependency in your pom.xml, the starter kit has most of the dependency for getting started with the development with no further need of configuration changes. For instance, `spring-boot-starter-test` includes testing libraries, JUnit, Mockito, Hamcrest Spring test, and Spring core. `spring-boot-starter-data-jpa' includes spring data JPA with hibernate, JDBC, Entity Manager, Transaction API, Spring Data JPA, Aspects, and likewise for other starter kits.
   
   * **Command Line Interface**:
   
   * **Actuator**: Actuators are used to monitor the internal runtime operational information  and what's happening inside it. It can be managed via HTTP endpoints of JMX, and can be used to study health status, metrics, loggers, audit events, HTTP Trace, etc.
