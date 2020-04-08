In this lesson, we go into fundamentals of Spring Developmemt by going through various configurations that are available in Spring. Some of the topics include Java Configuration, Autowiring, and Advanced Bean Configuration.

# Table of Contents
* [What is Spring](https://github.com/jjoishi/SpringBoot/tree/master/Tutorials/2.%20Spring%20Framework%20-%20Spring%20Fundamentals#what-is-spring)
* [Demo - Java App in Plain Old Java Object (POJO) style](https://github.com/jjoishi/SpringBoot/tree/master/Tutorials/2.%20Spring%20Framework%20-%20Spring%20Fundamentals#demo---java-app-in-plain-old-java-objectpojo-style)


# What is Spring?
   Spring started out as a means of reducing complexity of J2EE enterprise development. It's main focus was **Inversion of Control Container** or **Dependency Injection**. Its started out as a means to help out with Enterprise Java Beans(EJB) development, but at its current state, it does not depend on beans.

   **NOTE: Dependecny Injection is a way of removing hard-wired code in your system, and forcing other to fulfill the dependencies as and when the object is required.**

   * Spring can be used with or without EJB, although lately, it is used independent of EJBs.
   * Spring is POJO (Plain Old Java Object) based. It means spring projects can be written without Spring at all.
   * Spring uses AOP and Proxies to address cross-cutting concerns. This should make your code more readable, modular and less scattered.

   The biggest problme that Spring (in comparison to J2EE) solves is **Testability**, **Maintainabaility**, **Scalability**. It helps reduce the **Code Complexity** and allows us to focus on **Business Logic**.

# Demo - Java App in Plain Old Java Object(POJO) Style
   The overall project is to develop an app that has information on all the speakers coming to a conference.

   In this case, we will develop the application in plain java objects without any configuration.
   
   1. Start a maven project, and provide an appropriate groupID, artifactID and a name to your project.

   **NOTE: By default, intelliJ uses Java version 1.5 as the default compiler. However Maven projects are not designed to run on or below version 5. To force IntelliJ to use maven compiler plugin and not the default one, add a build plugin to you POM file**

   <img src="https://github.com/jjoishi/SpringBoot/blob/master/Tutorials/2.%20Spring%20Framework%20-%20Spring%20Fundamentals/images/1.%20java_pojo/pom.PNG" width="800" height="600">

   2. Create a model for the Speaker. At this point, we are only interested in First and Last name of the speaker.
   
   <img src="https://github.com/jjoishi/SpringBoot/blob/master/Tutorials/2.%20Spring%20Framework%20-%20Spring%20Fundamentals/images/1.%20java_pojo/speaker.PNG" width="800" height="600">

   3. Details of each speaker has to be maintained in the database. However, for simplicity of the project, we do not maintain information in the database. Instead, we define an interface repository that kind of mimics the interfaces to an actual database.

   <img src="https://github.com/jjoishi/SpringBoot/blob/master/Tutorials/2.%20Spring%20Framework%20-%20Spring%20Fundamentals/images/1.%20java_pojo/SpeakerRepository.PNG" width="800" height="600">

   4. We create an implementation of SpeakerRepository that mimics the actual database, and for now, has some speakers defined.

   <img src="https://github.com/jjoishi/SpringBoot/blob/master/Tutorials/2.%20Spring%20Framework%20-%20Spring%20Fundamentals/images/1.%20java_pojo/HibernateSpeakerRepositoryImpl.PNG" width="800" height="600">

   5. Alike Repository, there should be a service that cordinates activities of the speaker. The SpeakerService interfaces mimics the cordinting interface.

   <img src="https://github.com/jjoishi/SpringBoot/blob/master/Tutorials/2.%20Spring%20Framework%20-%20Spring%20Fundamentals/images/1.%20java_pojo/SpeakerService.PNG" width="800" height="600">

   And SpeakerServiceImpl is an implementation of the Speaker cordinating service.

   <img src="https://github.com/jjoishi/SpringBoot/blob/master/Tutorials/2.%20Spring%20Framework%20-%20Spring%20Fundamentals/images/1.%20java_pojo/SpeakerServiceImpl.PNG" width="800" height="600">

   6. The Main driver class. We create an Application class that acts as the main driver class. It instantaites the service. This is turn initializes the repository and all speakers.
   
   <img src="https://github.com/jjoishi/SpringBoot/blob/master/Tutorials/2.%20Spring%20Framework%20-%20Spring%20Fundamentals/images/1.%20java_pojo/Application.PNG" width="800" height="600">

   As you can see from the example above, these set of classes just use plain java objects. Objects of the class are hardcoded initialized. 

   * **Issue**
      * Hardcoded references. 
      * Violation of OCP - If a change in class name were to happen, all hardcoded initializations has to be changed.





