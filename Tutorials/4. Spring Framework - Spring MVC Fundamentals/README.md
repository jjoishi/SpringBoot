This course covers the fundamentals of Spring MVC. Topics include containers and containers list appointments, standard and rest controllers, jsp pages and thymeleaf and comsuming spring mvc from client side javascript.

# Table of Contents
* [What is Spring MVC?](https://github.com/jjoishi/SpringBoot/tree/master/Tutorials/4.%20Spring%20Framework%20-%20Spring%20MVC%20Fundamentals#what-is-spring-mvc)

# What is Spring MVC?
   Spring MVC's architecture is based on the MVC design pattern. The below image (copyrights to Spring Framework: Spring MVC Fundamentals course by Bryan Hansen on Pluralsight) shows the typical layout of MVC pattern.

   <img src ="https://github.com/jjoishi/SpringBoot/blob/master/Tutorials/4.%20Spring%20Framework%20-%20Spring%20MVC%20Fundamentals/images/1.%20spring_mvc/mvc.PNG"/>

   The 'Model' is the backend layers of the application which has several layers like business layers, data layers, etc. Data layer can be backed up several databases, relational and non-relational. The 'Model' is general is implemented as various microservices. Model typically means the data that is stored/retrieved in some format. The 'View' layer typically defines the forntend of the application where the user interacts. These can be implemented using JSP or any frontend frameworks like Javascript, React, etc. The 'Controller' acts as a a layer to delegate inputs from user to the backend. And when a response is generated, the controller talks to the 'View' to render the application accordingly. Controller are usually implmented using Command Pattern Design Pattern.

   * **Request-Response Cycle**: The image ((copyrights to Spring Framework: Spring MVC Fundamentals course by Bryan Hansen on Pluralsight)) below shows a typical request-reponse cycle using the MVC pattern.

   <img src ="https://github.com/jjoishi/SpringBoot/blob/master/Tutorials/4.%20Spring%20Framework%20-%20Spring%20MVC%20Fundamentals/images/1.%20spring_mvc/RequestResponseCycle.PNG"/>

   The sequence of data flow is - 
   
   `Incoming Request` --> `Delegate Request` --> `Handle Request` --> `Create Model` --> `Delegate Rendering` --> `Render Response` --> `Return Control` --> `Return Response`

# Creating Conference Sping MVC Application
   * Create a Spring Boot (yes, Spring Boot) project from www.start.spring.io using Java and Maven, and adding Spring Web as a dependency. 
   * Download the zip file, and open it using intelliJ
   * Under 'resources/static' folder, add a HTML file that prints a dummy message.
   * Run the application. and navigate to localhost:8080 to check that the application is working as intended.
   
   By default, the above applications is packaged into a JAR file. However, if you want to package the application as a WAR file and deploy it to external servers like Tomcat, execute the additional steps mentioned below. Note that adding Application servers is not possible in IntelliJ Community Edition - 

   * Download the core zip package of Apache Tomcat server.
   * Under `Settings` -> `Build, Execution and Deployment` -> `Application Servers`, add TomcatServer by supplying the required path.
   * In the project's pom.xml, add the following in project properties - 
   ```
      <packaging> war </packaging>
   ```
   
   and athe following dependency - 

   ```
      <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-tomcat -->
      <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-tomcat</artifactId>
         <version>2.2.6.RELEASE</version>
      </dependency>
   ```
   * create a folder under `src/main`, say webapps, and copy the index.html file from `resources/static`. It is so because, resources folder are not included s part of the WAR packaging.
   * Edit the `Run Configuration`, to add a new Tomcat Configuration. Make sure the JDK version also matches. 
   * Choose war type as `conference:war`, and default as `/conference`
   * Run the application, and tomcat should automatically launch a browser with the default `/conference` page.

   More information on integrating Tomcat server with IntelliJ can be found [here](https://mkyong.com/intellij/intellij-idea-run-debug-web-application-on-tomcat/)



