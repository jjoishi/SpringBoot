In this lesson, we go into fundamentals of Spring Developmemt by going through various configurations that are available in Spring. Some of the topics include Java Configuration, Autowiring, and Advanced Bean Configuration.

# Table of Contents
* [What is Spring](https://github.com/jjoishi/SpringBoot/tree/master/Tutorials/2.%20Spring%20Framework%20-%20Spring%20Fundamentals#what-is-spring)
* [Demo - Java App in Plain Old Java Object (POJO) style](https://github.com/jjoishi/SpringBoot/tree/master/Tutorials/2.%20Spring%20Framework%20-%20Spring%20Fundamentals#demo---java-app-in-plain-old-java-objectpojo-style)
* [Demo - Java Spring Configurations](https://github.com/jjoishi/SpringBoot/tree/master/Tutorials/2.%20Spring%20Framework%20-%20Spring%20Fundamentals#demo---conference-app-with-spring-configurations)


# What is Spring?
   Spring started out as a means of reducing complexity of J2EE enterprise development. It's main focus was **Inversion of Control Container** or **Dependency Injection**. Its started out as a means to help out with Enterprise Java Beans(EJB) development, but at its current state, it does not depend on beans.

   **NOTE: Dependency Injection is a way of removing hard-wired code in your system, and forcing other to fulfill the dependencies as and when the object is required.**

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

# Demo - Conference App with Spring configurations
   Create a copy of the conference project from [Demo1](https://github.com/jjoishi/SpringBoot/tree/master/Tutorials/2.%20Spring%20Framework%20-%20Spring%20Fundamentals#demo---java-app-in-plain-old-java-objectpojo-style), and and name it '**Conference-JavaConfigurations**'. For the project to work properly, its properties has to be changed to suit the new project name. Change the following - 

   * Under the project, rename the file '**Conference.iml**' to '**Conference-JavaConfigurations.iml**'
   * In pom.xml, replace the ArtifactID of the project to a new name. This will avoid any clash of namespaces/packages if the project is published.
   * For the first launch, running the main method will invoke a window. Set the classpath of the module to the new project name, and select the JRE that you have installed on your system.

   To make the project Spring based, the first step is to make spring dependencies available to the project. This can be done by adding the spring conext as dependecy to pom.xml
   ```
      <dependency>
         <groupId>org.springframework</groupId>
         <artifactId>spring-context</artifactId>
         <version>5.2.5.RELEASE</version>
      </dependency>
   ```

   Spring Framework core idea is based on 'Dependency Injection'. To achieve this - 

   1. Class SpeakerServiceImpl had hardcoded initialization of SpeakerRepository. To achieve Dependency injection for this class, we would define an object of SpeakerRepository but would only initialize it via '**Constructor Injection**' or '**Setter Injection**'.

   <img src="https://github.com/jjoishi/SpringBoot/blob/master/Tutorials/2.%20Spring%20Framework%20-%20Spring%20Fundamentals/images/2.%20java_spring_configuration/SpeakerServiceImpl.PNG" width="800" height="600">

   2. The main method in Application class also had direct initialization of 'SpeakerService'. To mitigate such hardcoded initializations, Java Configurations/Spring Configurations/ XML Configurations are used where such objects are created and registered as '**Beans**'. To define the configuration for this project, we introduce a new class called '**AppConfig**'.

   It is a public class marked with `@Configuration` at the class level to indicate that this class is responsible for bootstrapping the application. Additionally, we define two Beans using `@Bean` with optional argument `name' that gets registered with the Spring framework as two objects which would be used in the project.

   Bean `speakerRepository` initializes a new repository, and the Bean `speakerService` takes in the speakerRepository object to initialize the service(conference app).

   <img src="https://github.com/jjoishi/SpringBoot/blob/master/Tutorials/2.%20Spring%20Framework%20-%20Spring%20Fundamentals/images/2.%20java_spring_configuration/AppConfig.PNG" width="800" height="600">

   These beans are registered with the spring framework through the `AppConfig` class. So naturally, our main `Application` class should initialized the configuration class, and access beans(and its underlying functions) through the Config class.

   <img src="https://github.com/jjoishi/SpringBoot/blob/master/Tutorials/2.%20Spring%20Framework%20-%20Spring%20Fundamentals/images/2.%20java_spring_configuration/Application.PNG" width="800" height="600">

# Bean Scopes and Auto-wiring
   Scopes are not patterns, howeever Spring uses them internally. There are five types of Scopes

   * Valid in Web configurations only
      * REQUEST
      * SESSION
      * GLOBAL SESSION

   * Valid in any configuration
      * **SINGLETON**
         
         It is the default bean scope in Spring. As the name suggests, objects are initialized only once per Spring container. This may be same as one object per JVM, but not necessarily. Technically, you can have multiple Spring Containers in a single JVM instance. Since containers are isolated, the objects has to be singleton only on that container.

         A bean's scope can be defined as singleton by using the `@Scope` annotation with the appropriate `BeanDefinition` value.
         ```
            @Bean(name = "speakerService")
            @Scope(value = BeanDefinition.SCOPE_SINGLETON)
            public SpeakerService getSpeakerService(){
        
               // constructor injection
               SpeakerServiceImpl aService = new SpeakerServiceImpl(getSpeakerRepository());
        
               // setter injection
               // SpeakerServiceImpl aService = new SpeakerServiceImpl();
               // aService.setRepo(getSpeakerRepository());
               return aService;
            }
         ```
         In your `Application' class, if your print the the hashcode of two different SpeakerService instances, observe that they are the same.
         ```
            SpeakerService aSpeakerService = appContext.getBean("speakerService", SpeakerService.class);
            SpeakerService aSpeakerService2 = appContext.getBean("speakerService", SpeakerService.class);

            System.out.println(aSpeakerService);
            System.out.println(aSpeakerService2);
        ```

        <img src="https://github.com/jjoishi/SpringBoot/blob/master/Tutorials/2.%20Spring%20Framework%20-%20Spring%20Fundamentals/images/2.%20java_spring_configuration/Singleton.PNG">

      * **PROTOTYPE**
         It creates a separate bean instance per request. Instances are guranteed to be unique.
         ```
            @Bean(name = "speakerService")
            @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
            public SpeakerService getSpeakerService(){
        
               // constructor injection
               SpeakerServiceImpl aService = new SpeakerServiceImpl(getSpeakerRepository());
        
               // setter injection
               // SpeakerServiceImpl aService = new SpeakerServiceImpl();
               // aService.setRepo(getSpeakerRepository());
               return aService;
            }
         ```

         The result as seen below, indicates that the two SpeakerService instances are different.
         
         <img src="https://github.com/jjoishi/SpringBoot/blob/master/Tutorials/2.%20Spring%20Framework%20-%20Spring%20Fundamentals/images/2.%20java_spring_configuration/Prototype.PNG">

   **Auto-wiring** : Spring can automatically resolve the dependencies(beans) for the current bean by looking at its collection of bean. The collection of bean can that should be registtered is defined by scanning beans in a given component. `@ComponentScan` is used to define this. By default, beans are set to `No autowiring`. However, they can be allowed to search and link beans `ByName', 'ByInstanceType'. Beans can be autowired using the `@Autowired` annotation.

   In the following example, I set the function `setRepo` to `AutoWired`, and a log statement has been added to each of the constructors, and setter.

   <img src="https://github.com/jjoishi/SpringBoot/blob/master/Tutorials/2.%20Spring%20Framework%20-%20Spring%20Fundamentals/images/2.%20java_spring_configuration/AutowiredSpeakerServiceImpl.PNG">

   AppConfig initialized the Bean using the default constructor, but without calling the setter explicityly.

   <img src="https://github.com/jjoishi/SpringBoot/blob/master/Tutorials/2.%20Spring%20Framework%20-%20Spring%20Fundamentals/images/2.%20java_spring_configuration/AutoWireAppConfig.PNG">

   Notice the output. Despite the setter not being hooked explicitly in AppConfig, it is called during speakerService bean creation. This was possible due to Auto-wiring.

   <img src="https://github.com/jjoishi/SpringBoot/blob/master/Tutorials/2.%20Spring%20Framework%20-%20Spring%20Fundamentals/images/2.%20java_spring_configuration/OutputAutowire.PNG">

   ** Stereotype Annotations**: So far, we have only autowired one constructor injection in bean creation. Typically, a Spring project would have lot more beans, and having to fill up `AppConfig` class with the initialization of all objects to be autowired is a painful task. One can set auto-wiring at class level. To begin with, you will need to include the `@ComponentScan` annotation in AppConfig.
   ```
   @ComponentScan("com.jeevan"})
   ```

   Instead of having bean identifers in AppConfig, those can be defined at appropriate classes using `@Repository` or `@Service` stereotypes annotations.
   ```
   @Service("speakerService")
   public class SpeakerServiceImpl implements SpeakerService {
   private SpeakerRepository repo;
   ....
   ```
   ```
   @Repository("speakerRepository")
   public class HibernateSpeakerRepositoryImpl implements SpeakerRepository {
   @Override
   public List<Speaker> findAll(){
   ....
   ```

   Since, definition of the beans has moved from AppConfig to respective classes, AppConfig should no longer be defining those beans again. As such they are all commented out.
   ```
   @Configuration
   @ComponentScan({"com.jeevan"})
   public class AppConfig {
      // Bean annotations are used to get instances of spring beans
      // Bean is used at method level

      /*
      * Commenting because of autowiring using stereotype annotations.
      *
      @Bean(name = "speakerService")
      @Scope(value = BeanDefinition.SCOPE_SINGLETON)
      public SpeakerService getSpeakerService(){
         // constructor injection
         // SpeakerServiceImpl aService = new SpeakerServiceImpl(getSpeakerRepository());
        
         // setter injection
         // SpeakerServiceImpl aService = new SpeakerServiceImpl();
         // aService.setRepo(getSpeakerRepository());


         // Object for autowiring. aService initialized using default constructor
         // but no setter has been called.
         SpeakerServiceImpl aService = new SpeakerServiceImpl();
         return aService;
      }

    @Bean(name = "speakerRepository")
    public SpeakerRepository getSpeakerRepository() {
        return new HibernateSpeakerRepositoryImpl();
    }
    */
   }
   ```

   Despite, not linking the beans explicitly, Spring Framework reads the dependencies of beans in `com.jeevan` to understand which beans should be autowired with the other to work properly. The following output shows that despite no explicit dependency injection, default constructor followed by setter injection is used for instantiation (because @Autowired tag was set to the setter in the class SpeakerServiceImpl).

   <img src="https://github.com/jjoishi/SpringBoot/blob/master/Tutorials/2.%20Spring%20Framework%20-%20Spring%20Fundamentals/images/2.%20java_spring_configuration/OutputStereotype.PNG">