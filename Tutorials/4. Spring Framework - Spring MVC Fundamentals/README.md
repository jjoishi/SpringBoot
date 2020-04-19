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



