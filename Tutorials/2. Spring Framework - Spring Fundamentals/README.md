In this lesson, we go into fundamentals of Spring Developmemt by going through various configurations that are available in Spring. Some of the topics include Java Configuration, Autowiring, and Advanced Bean Configuration.

# Table of Contents
* [What is Spring](https://github.com/jjoishi/SpringBoot/tree/master/Tutorials/2.%20Spring%20Framework%20-%20Spring%20Fundamentals#what-is-spring)
* [Demo - Java App in Plain Old Java Object (POJO) style](https://github.com/jjoishi/SpringBoot/tree/master/Tutorials/2.%20Spring%20Framework%20-%20Spring%20Fundamentals#demo---java-app-in-plain-old-java-objectpojo-style)
* [Demo - Java Spring Configurations](https://github.com/jjoishi/SpringBoot/tree/master/Tutorials/2.%20Spring%20Framework%20-%20Spring%20Fundamentals#demo---conference-app-with-spring-configurations)
* [Bean Scopes, Auto-wiring, Stereotype Annotations](https://github.com/jjoishi/SpringBoot/tree/master/Tutorials/2.%20Spring%20Framework%20-%20Spring%20Fundamentals#bean-scopes-auto-wiring-stereotype-annotations)
* [Demo - Java XML Configurations](link)
* [# Advance Bean Configurations](link)


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

# Bean Scopes, Auto-wiring, Stereotype Annotations
   Scopes are not patterns, howeever Spring uses them internally. There are five types of Scopes

   * Valid in Web configurations only
      * **REQUEST**
      * **SESSION**
      * **GLOBAL SESSION**

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
         In your `Application` class, if your print the the hashcode of two different SpeakerService instances, observe that they are the same.
         ```
            SpeakerService aSpeakerService = appContext.getBean("speakerService", SpeakerService.class);
            SpeakerService aSpeakerService2 = appContext.getBean("speakerService", SpeakerService.class);

            System.out.println(aSpeakerService);
            System.out.println(aSpeakerService2);
        ```

        <img src="https://github.com/jjoishi/SpringBoot/blob/master/Tutorials/2.%20Spring%20Framework%20-%20Spring%20Fundamentals/images/2.%20java_spring_configuration/Singleton.PNG">

      * **PROTOTYPE**
         It creates a separate bean instance per request. Instances are guaranteed to be unique.
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

   **Auto-wiring** : Spring can automatically resolve the dependencies(beans) for the current bean by looking at its collection of bean. The collection of bean that should be registered is defined by scanning beans in a given component. `@ComponentScan` is used to define this. By default, beans are set to `No autowiring`. However, they can be allowed to search and link beans `ByName`, `ByInstanceType`. Beans can be autowired using the `@Autowired` annotation.

   In the following example, I set the function `setRepo` to `AutoWired`, and a log statement has been added to each of the constructors, and setter.

   <img src="https://github.com/jjoishi/SpringBoot/blob/master/Tutorials/2.%20Spring%20Framework%20-%20Spring%20Fundamentals/images/2.%20java_spring_configuration/AutowiredSpeakerServiceImpl.PNG">

   AppConfig initialized the Bean using the default constructor, but without calling the setter explicitly.

   <img src="https://github.com/jjoishi/SpringBoot/blob/master/Tutorials/2.%20Spring%20Framework%20-%20Spring%20Fundamentals/images/2.%20java_spring_configuration/AutoWireAppConfig.PNG">

   Notice the output. Despite the setter not being hooked explicitly in AppConfig, it is called during speakerService bean creation. This is possible due to Auto-wiring.

   <img src="https://github.com/jjoishi/SpringBoot/blob/master/Tutorials/2.%20Spring%20Framework%20-%20Spring%20Fundamentals/images/2.%20java_spring_configuration/OutputAutowire.PNG">

   **Stereotype Annotations**: So far, we have only autowired one constructor injection in bean creation. Typically, a Spring project would have lot more beans, and having to fill up `AppConfig` class with the initialization of all objects to be autowired is a painful task. One can set auto-wiring at class level. To begin with, you will need to include the `@ComponentScan` annotation in AppConfig.
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

# Demo - Java XML Configurations
   Create a copy of Java POJO based Conference app. Without modifying pom or the .iml file, make sure that the application works perfectly. Set the module and JRE version properly on the first run of the copied application. This demo will not only have XML based configuration, but also include their equivalent Java configuration for us to compare.

   * **applicationContext.xml**: This file is the AppConfig equivalent in XML configurations. Like AppConfig, it does not have to have the name applicationContext.xml, but that is a widely used practice. The file stores certain Name-Value pairs, much alike a hashmap and can be used as a registry to bootstrap the application with configurations taken from this XML file. It does have options to provide namespaces to configurations/validations.

   To begin with, we add an `applicationConfig.xml` file under the resources folder of our project. The file is initilized with default spring schema and namesspaces . This also help setup the xml with Spring context so that when we begin to type, the auto completion suggestions are those related to Spring.
   ```
   <?xml version ="1.0" encoding ="UTF-8"?>

      <beans xmlns ="http://www.springframework.org/schema/beans"
         xmlns:xsi = "http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation ="http://www.springframework.org/schema/beans
         http://www.springframework.org/schema/beans/spring-beans.xsd">
      </beans>
   ```

   * **Bean Definition in XML**: Beans are essentially classes where object initializtion replaces `new` keyword. Beans are **defined on classes, but use interfaces**. Take a look at two beans defined in the applicationContext.xml. `Setter Injection` are property named based. They accept the function to call when the bean is invoked, and a ref of the bean which is to be injected(bean for setter injection is commented out in the code snippet below). `Constructor Injection` are index based and use the index and the type of the argument as its `constructor-arg`.
   ```
   <?xml version ="1.0" encoding ="UTF-8"?>

   <beans xmlns ="http://www.springframework.org/schema/beans"
         xmlns:xsi = "http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation ="http://www.springframework.org/schema/beans
         http://www.springframework.org/schema/beans/spring-beans.xsd">

      <bean
            name="speakerRepository"
            class="com.jeevan.repository.HibernateSpeakerRepositoryImpl"> <!-- Do not use interfaces while linking beans-->
      </bean>

      <!-- setter injection use property tag with 'ref' as one of its properties -->
      <!-- Commenting out to demonstrate constructor injection
      <bean
            name="speakerService"
            class = "com.jeevan.service.SpeakerServiceImpl">
            <property name="speakerRepository" ref="speakerRepository"/>
      </bean>
      -->

    <!-- constructor injection. here the properties are indices and their respective value types-->
      <bean
            name="speakerService"
            class = "com.jeevan.service.SpeakerServiceImpl">
            <constructor-arg index="0" ref="speakerRepository"/>
       </bean>
   </beans>
   ```
   **NOTE**: For setter injection, the setter has to be named as property name, minus the 'set' keyword. This would be more evident if you look at the name of the setter function from SpeakerServiceImpl class below - 
   ```
   public class SpeakerServiceImpl implements SpeakerService {
      private SpeakerRepository repo;

      public SpeakerServiceImpl(){

      }

      public SpeakerServiceImpl(SpeakerRepository repo){
         this.repo = repo;
      }

      // NOTE THE NAMING CONVENTION HERE
      // THE SETTERNAME HAS TO MATCH THE BEAN PROPERTY NAME
      public void setSpeakerRepository(SpeakerRepository repo) {
        this.repo = repo;
      }

      @Override
      public List<Speaker> findAll(){
         return repo.findAll();
      }
   }  
   ```

   The main Application class, would just change to enforce the new XML configuration file. Rest of the things remains unchanged.
   ```
   public class Application {
      public static void main(String[] args) {

         ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");

         // Call application using XML configurations
         SpeakerService aSpeakerService = appContext.getBean("speakerService", SpeakerService.class);
         System.out.println(aSpeakerService.findAll().get(0).getFirstName());
         System.out.println(aSpeakerService.findAll().get(1).getFirstName());
      }
   }
   ```

   Auto-wiring a code in XML configuration is as simple as modifying the XML file to include the `autowire` keyword for the bean followed by its type. `Autowire` type can be of `byName`, `byType`, `Constructor` and `No`. The constructor type is used for constructor injection. `byType` is usually used when the setter are unique with respect to their argument types. However, if there are setter with same argument type but different names, `byName` would be preferred. But for this to work, the setter functin name has to match the property name in the XML config file.
   ```
   <bean
      name="speakerService"
      class = "com.jeevan.service.SpeakerServiceImpl" autowire="constructor">
      <!-- commented out because we use constructor injection
         <constructor-arg index="0" ref="speakerRepository"/>
      -->
   </bean>
   ```

# Advance Bean Configurations
   * **Bean Lifecycle** is comprised of the following steps
   ```
      1. Instantiation

      2. Populate Properties

      3. BeanNameAware

      4. BeanFactoryAware

      5. PreInitialization - BeanPostProcessors

      6. InitializeBean

      7. initMethod

      8. PostInitialization - BeanPostProcessors
   ```

   Let us add a new dependency to our `copy of spring configuration' project's pom.xml
   ```
   <!-- https://mvnrepository.com/artifact/javax.annotation/javax.annotation-api -->
      <dependency>
         <groupId>javax.annotation</groupId>
         <artifactId>javax.annotation-api</artifactId>
         <version>1.3.2</version>
      </dependency>
   ```

   One of the steps in the bean life cycle is post initilize method. Let us add a method that displays a message and mark it with `@PostConstruct` annotation. Iresspective of which method is used for injection, the bean has to be created, post which the log is displayed.
   ```
      public class SpeakerServiceImpl implements SpeakerService {
         private SpeakerRepository repo;

         public SpeakerServiceImpl(){
            System.out.println("SSI no args ctor");
         }

         // constructor injection
         public SpeakerServiceImpl(SpeakerRepository repo) {
            System.out.println("SSI parametrized ctor");
            this.repo = repo;
         }

         @PostConstruct
         private void initialize(){
            System.out.println("Post ctor init method called");
         }
    
         @Override
         public List<Speaker> findAll(){
            return repo.findAll();
         }

         // setter injection
         @Autowired
         public void setRepo(SpeakerRepository repo) {
            System.out.println("SSI setter");
            this.repo = repo;
         }
      }
   ```
   And a screenshot of the output shows that the post construct method is called.
   
   <img src="https://github.com/jjoishi/SpringBoot/blob/master/Tutorials/2.%20Spring%20Framework%20-%20Spring%20Fundamentals/images/2.%20java_spring_configuration/AdvanceBeanPostConstruct.PNG>

   * **Factory Bean**: It builds on the initMethod described above(postConstruct). The underlying framework is same as Factory Method pattern, and is a great tool to integarte legacy code into your applications.

   Let us integrate the conference app with a Calendar object. The object would be used to mark when was the speaker registered(sort of). Calendar object is generated in a Factory, which is then used in our repository to mark a speaker's data.

   We begin by creating a Factory class for the Calendar object. the Factory implements the `FactoryBean` and overrides its abstract functions.
   ```
      public class CalendarFactory implements FactoryBean<Calendar> {
         private Calendar aCalendar = Calendar.getInstance();

         @Override
         public Calendar getObject() throws Exception {
            return aCalendar;
         }

         @Override
         public Class<?> getObjectType() {
            return Calendar.class;
         }

         public void addDays(int num){
            aCalendar.add(Calendar.DAY_OF_YEAR, num);
         }
      }
   ```

   The Bean for this factory should be registered in the Spring ecosystem. This is done by adding its entry in the Application Config class.
   ```
   @Configuration
   @ComponentScan({"com.jeevan"})
   public class AppConfig {
      @Bean(name="cal")
      public CalendarFactory calFactory(){
         CalendarFactory aCalFactory = new CalendarFactory();
         aCalFactory.addDays(5);
         return aCalFactory;
      }

      @Bean
      public Calendar cal() throws Exception {
         return calFactory().getObject();
      }
   }
   ```

   Since the calendar instance generated by the factory has to be used with the repository, the instance is injected into the repository class using auto-wiring.
   ```
   @Repository("speakerRepository")
   public class HibernateSpeakerRepositoryImpl implements SpeakerRepository {
      @Autowired
      private Calendar aCal;

      @Override
      public List<Speaker> findAll(){
         List<Speaker> speakers = new ArrayList<Speaker>();

         // TODO: Database should have been queried
         Speaker aSpeaker = new Speaker();
         aSpeaker.setFirstName("Jeevan");
         aSpeaker.setLastName("Joishi");

         Speaker bSpeaker = new Speaker();
         bSpeaker.setFirstName("Aditya");
         bSpeaker.setLastName("Ganjoo");

         System.out.println("Value added on :" +aCal.getTime());

         speakers.add(aSpeaker);
         speakers.add(bSpeaker);

         return speakers;

      }
   }
   ```

   A run of the application demonstrates the date when each of these speakers registered.
   
   <img src="https://github.com/jjoishi/SpringBoot/blob/master/Tutorials/2.%20Spring%20Framework%20-%20Spring%20Fundamentals/images/2.%20java_spring_configuration/FactoryBeanOutput.PNG>

   * **Spring Expression Language(SpEL)** : SpEL are more like mathematical statements that allowes for modification of object graph or change values at runtime, or change configuration settings.

   Let us add a number to model - Speaker class. It is a plain number that is assigned at runtime. The updated Speaker class would look like - 
   ```
   public class Speaker {
      private String firstName;
      private String lastName;
      private double seedNum;

      ....
      ....

      public double getSeedNum() {
         return seedNum;
      }

      public void setSeedNum(double seedNum) {
         this.seedNum = seedNum;
      }

      ....
   ```

   On the repository, since the values are assigned at runtime, let us define a Spring Expression that generates those values and assigns them. These values can be created using `@Value` annotation.
   ```
      public class HibernateSpeakerRepositoryImpl implements SpeakerRepository {
         @Autowired
         private Calendar aCal;

         @Value("#{T(java.lang.Math).random() * 100}")
         private double seedNum;

         ...
         ...

         Speaker aSpeaker = new Speaker();
         aSpeaker.setFirstName("Jeevan");
         aSpeaker.setLastName("Joishi");
         aSpeaker.setSeedNum(seedNum);

         ...
         ...
   ```

   On executing the program, one can see random values being assigned to the speakers (It is same for both the speakers here because the value is assigned at the object initialization. Since both the speakers are created on the same object, the value remains the same.).

   <img src="https://github.com/jjoishi/SpringBoot/blob/master/Tutorials/2.%20Spring%20Framework%20-%20Spring%20Fundamentals/images/2.%20java_spring_configuration/OutputSpEL.PNG>

   * **Bean Profiles**: Bean Profiles is a way of marking territories in spring project. It is like configuring a project to run only in certain environments. Profiles can be marked by using `@Profile` annotation with a string value that defines the configuration. The string value is not a keyword, but any user defined keyword.

   Let us add the repositoryImpl class to "dev" profile.
   ```
      @Repository("speakerRepository")
      @Profile("dev")
      public class HibernateSpeakerRepositoryImpl implements SpeakerRepository {
         ...
   ```

   If I were to run the project at this point, I would encounter a `NullPointerException` error because the `speakerRepository` bean is in "dev" profile, while the `speakerService` bean is not under any profile. Hence the project is not able to find both the beans required under the same configuration. One would also encounter the same error if the `speakerService' bean was defined in profile diffeerent than "dev". 

   The advantages of using profiles is that one can segregated out which functionality are required for certain tasks. There may be utility beans that are just part of the project but do not serve the core of the project, and using profiles can help them segregate out during testing, or one can mark certain profiles as TODO or DEVMACHINE that signifies that it only works in some local configuration, and exporting it to build systems or other machines won't serve the same purpose.