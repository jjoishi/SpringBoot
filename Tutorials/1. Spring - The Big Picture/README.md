This lesson gives a high level introduction to Spring Framework, some of the Spring projects. It answers questions on why and when to use Spring.

# Table of Contents
* [Spring Overview](https://github.com/jjoishi/SpringBoot/tree/master/Tutorials/1.%20Spring%20-%20The%20Big%20Picture#what-is-spring)
* [Getting to know Spring with Spring Boot](https://github.com/jjoishi/SpringBoot/tree/master/Tutorials/1.%20Spring%20-%20The%20Big%20Picture#getting-to-know-spring-with-spring-boot)

# What is Spring?

Spring could mean ...
* The Spring Framework
* Spring Boot
* Spring Data
* Spring Cloud
* Spring Batch
* Spring Security
* --- and many more

Most often, they refer to the family of projects or the Spring ecosystem.

## Spring Family
The Spring Family began when Spring Framework was introduced. Spring was introduced in response to the complexity of developing web application in Java (J2EE). Spring was introduced with an intention to make web development, data access, security, etc. easier for developers to implement. It also helped in reducing the boiler plate code (code that is not part of the main application, but is always neded to make things work).

Spring Framework is the foundation of many other spring projects like Spring Data, Spring Security, Spring Kafka, etc. which served very specific purpose But building a Spring application involved a lot of choices, configuration of & between various spring projects, and the cumbersome deployment model. 

Spring Boot was a game changer because it removed all these work by ensuring default settings/ libraries for the projects involving various spring elements, an opiniated view of developing application. Spring Boot also added smart features for auto detecting libraries/configurations, and deployment. Project deployment in Spring boot became as simple as running a simple command.

Spring Cloud sat on top of Spring Boot, and made the development of distributed architectures like cloud based applications, microservices architectures, etc. easy. Distributes systems often have common patterns like service discovery, distributed configuration, etc. Spring Cloud made it easy for developers to develop applications that uses these patterns.

## Why Spring?

* It complements J2EE
* It is flexible, modular and backward compatible - one can choose any part of spring project to develop their applications, and it sticks together.
* Large and active community.
* Continually evolving. Although it is an open source, it is backed by Pivotal which takes care to maintain/add/develop features.

# Getting to know Spring with Spring Boot