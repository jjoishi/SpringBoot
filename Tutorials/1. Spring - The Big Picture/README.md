This lesson gives a high level introduction to Spring Framework, some of the Spring projects. It answers questions on why and when to use Spring.

# Table of Contents
* [Spring Overview](https://github.com/jjoishi/SpringBoot/tree/master/Tutorials/1.%20Spring%20-%20The%20Big%20Picture#what-is-spring)
* [Getting to know Spring with Spring Boot](https://github.com/jjoishi/SpringBoot/tree/master/Tutorials/1.%20Spring%20-%20The%20Big%20Picture#getting-to-know-spring-with-spring-boot)
* [The Spring Framework](https://github.com/jjoishi/SpringBoot/tree/master/Tutorials/1.%20Spring%20-%20The%20Big%20Picture#the-spring-framework)
* [Is Spring a Good Fit](https://github.com/jjoishi/SpringBoot/tree/master/Tutorials/1.%20Spring%20-%20The%20Big%20Picture#is-spring-a-good-fit)

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
   The Spring Family began when **Spring Framework** was introduced. Spring was introduced in response to the complexity of developing web application in Java (J2EE). Spring was introduced with an intention to make web development, data access, security, etc. easier for developers to implement. It also helped in reducing the boiler plate code (code that is not part of the main application, but is always neded to make things work).

   Spring Framework is the foundation of many other spring projects like **Spring Data**, **Spring Security**, **Spring Kafka**, etc. which served very specific purpose But building a Spring application involved a lot of choices, configuration of & between various spring projects, and the cumbersome deployment model. 

   **Spring Boot** was a game changer because it removed all these work by ensuring default settings/ libraries for the projects involving various spring elements, an opiniated view of developing application. Spring Boot also added smart features for auto detecting libraries/configurations, and deployment. Project deployment in Spring boot became as simple as running a simple command.

   **Spring Cloud** sat on top of Spring Boot, and made the development of distributed architectures like cloud based applications, microservices architectures, etc. easy. Distributes systems often have common patterns like service discovery, distributed configuration, etc. Spring Cloud made it easy for developers to develop applications that uses these patterns.

## Why Spring?

* It complements J2EE
* It is flexible, modular and backward compatible - one can choose any part of spring project to develop their applications, and it sticks together.
* Large and active community.
* Continually evolving. Although it is an open source, it is backed by Pivotal which takes care to maintain/add/develop features.

# Getting to know Spring with Spring Boot
   Spring Boot is build on top of Spring Framework and is used to build both web and non-web applications.

## Notable features of Spring Boot
* **Auto-Configuration**:

   Spring Boot will automatically configure and setup an application based on it sorrounding(dependencies that you have added) and hints provided by the developer. For instance, if a spring boot application detects that it interacts with database, the spring boot configures the application for database related dependencies. The more specific the database, the more easy for Spring Boot to auto configure the project.

   Setting up or enabling auto configuration in Spring Boot application is as simple as adding an annotation - `@EnableAutoConfiguration`. It is an additional metadata to the code that can be used to configure projects ar runtime.

   For Example,
   ```
   @EnableAutoConfiguration
   public class Demo {
       ...
   }
   ```

* **Standalone**: 

   No need to deploy the application to web server. You can just run it using a single command.

   A typical Java web application has to go through the follwing steps -
   `Package Application` -> `Choose Webserver` -> `Configure Webserver` -> `Deploy Application & Start Webserver`

   With Spring Boot application, the pipeline is - 
   `Package Aplication` -> `Run`

   Spring Boot takes care of the rest by starting a web server under your application, configure the defaults, and runs your application.

* **Opinionated**:  

   It has a chosen way of doing things by default. 

   A typical Java application involves a lot of choices from tooling, logging, frameworks, libraries, build tools, etc. Spring removes this by having defaults that just runs. Also, Spring Initializer lets you choose the defaults for your application, and creates a readymade project for you to start.

# The Spring Framework

## Six key areas

The Spring Framework can be divided into 6 key areas - 
* **Core** :

   Spring Core serves as the foundational module upon which other key areas of Spring Framework are built. Spring core provides different features like - internationalization support, validation support, data binding support, type conversion support, etc. However, the main focus of Spring Core is **Dependency Injection**. 

   **Dependency Injection** - A real world object, say computer, has various other dependencies, say hard disk, memory, etc. The computer object can `fulfill its own dependency` much like buying a laptop that does not allow any modifications to the specs. Otherwise, the computer object may `declare its dependencies` - much like buying an assembled computer which can be configured by choice. Depending on itself created tightly coupled systems whereas declaration makes the system loosely coupled and more flexible to change. 9The second choice is dependency injection). **Spring core is a dependency injection container** - developers develop each module independently, and when a project declares a module dependency, Spring core glues it all together.

* **Web** :
   Spring Web is a framework for handling web requests. It provides two functions to achieve that- 
   * **Spring Web MVC**
      Let us first understand what a Java Servlet is. A Java Servlet is an object that takes in the request and generates a response. The servlet APIs are the ones that take web requests when they hit the web server, and pass the request to the application for further processing. Once processed, the servlet API also forwards the response to the web server to be served to the client. However Servlets are considered to be low level APIs. Hence they are difficult to use and manage because developers on the business logic side have to interact directly with these low level APIs, and code using it can become easily disorganized.
      `Web Server` -> `Servlet API` -> `Business Logic`.

      In case of Spring MVC, an additional layer is introduced between the Servlet API and 'Business Logic'
      `Web Server` -> `Servlet API` -> `Spring Core MVC` -> `Business Logic`
      A developer need not worry on the complex details of Servlet APIs, and can develop and structure business logic to route requests/responses through Spring Core MVC. 

   * **Spring Web Webflux**
      Spring Web Webflux is mostly suited for reactive applications - applications that are concerned with data streams and propagation of change. It handles requests asynchornously. Webflux applications rely on notifications systems(depend on others as well) to let know when a stage of the request processing is over, so that the next stage can start processing. This makes the previous stage available for other requests.

* **Aspect Oriented Programming (AOP)** :
   AOP is a way of writing more modular code by spearating cross-module concerns. Without AOP, applications would most likely have scattered and duplicated code across the application. For example, Security of an application, may be checking that the current user is valid admin, can happen across many different modules in the application. 

      ```
      void someSensitiveOperation() {
          if(validAdmin){
              // do something.
          } else {
              // log the error
              // report the behavior
          }
      }
      ```

   Instead of spreading these checks across modules of an application, Spring AOP allows us to define the security measures at a single location, and have modules depend on it. Authorization for example, can be defined using `@PreAuthorize` tag with appropriate arguments.

      ```
      @PreAuthorize("hasRole('admin')")
      void someSensitiveOperation() {
          // do something.
      }
      ```
* **Data Access** :
   Spring Data Access makes it easier for applications to interact with data sources. It removes all boiler plate code needed to retrieve and process results from data source like 'PreparedStatement', or iterating over 'ResultSet', or having code in try-catch-finally blocks. Using Spring Data Access, this is as simple as belows - 
      
      ```
      int numRecords = new JdbcTemplate(dataSource).queryForInt("Select count(*) from Foo");
      ```
    
    Spring Data Access also makes **database transaction** easier. In normal Java code, this would include setting autocommit, or setting the rollback in case of failures. In Spring, one can use the annotation `@Transactional' to denote that the function only acts on the database transactionally - either all or nothing.
       
       ```
       @Transactional
       void doDatabaseOperation() {
           // do something.
       }
       ```

    **Exception Translation** - Database vendors have different error codes for the same exception. With Spring Data Access, all these different error codes from different vendors are mapped onto the same Spring bucket corressponsing to that exception. 

    **Testing** applications is made easier with Spring Data Access. Spring Data lets you configure data sources easily, so that when testing one can point to a test database, but when the project goes live, actual production database is set up.

* **Integration** :
   Integration is about making different systems and applications work together. This 
      * How do applications talk to each other ? RMI   , Messaging Systems or Web Services. Let us define a rest service below

      
      ```
      @RestController                                              // Denotes we are using REST
      public class AccountController {
          @GetMapping("/account/{id}")                             // Denotes the operation and path
          public Account findAccount(@PathVariable int id){        // Associates Path and Value
              // do something
          }
      }
      ```

      
      Spring Framework provides suport from programmatically invoking our rest service using `restTemplates`. restTemplates automates and takes care of opening the connection, sending requests and handling responses. Query for account details can be as simple as 

     
      ```
      restTemplate.getForObject("http://jeevan.com/account/567", Account.class);
      ```

* **Testing** :
   Both Unit Testing and Integration testing in Spring Framework is made easy by the fact that Spring Framework's core idea is based on dependency injection. Spring Testing provides certain mocking functionalities that lets you test your code by supplying your dependencies to your code functionality, or mocks that allows you to integrate modules with injection and test them with these new set of dependencies.

# Is Spring a Good Fit?

## Advantages
   * Rock Solid and engineered.
   * Stood the test of time. It has taken time to develop, and has had a lot of contributions over the years.
   * Spring Community is huge and very active.
   * One of the most used frameworks.
   * Built-in IDE support.
   * Develop scalable architecture.

## Disadvantages
   * Too much 'magical'/ 'configurable'. Things and dependencies just work, and people don't understand why things work.
   * Since it is heavily used, the learning curve is steep.
   * It increases the deliverable size.
   * Hard to debug as Spring hides a lot of details.
   * Add memory overhead to run applications.
   * Complexity of Spring has increased.