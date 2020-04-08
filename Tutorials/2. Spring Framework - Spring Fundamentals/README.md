In this lesson, we go into fundamentals of Spring Developmemt by going through various configurations that are available in Spring. Some of the topics include Java Configuration, Autowiring, and Advanced Bean Configuration.

# Table of Contents
* [What is Spring](link)
* [Demo - Java App in Plain Old Java Object (POJO) style](link)


# What is Spring?
   Spring started out as a means of reducing complexity of J2EE enterprise development. It's main focus was **Inversion of Control Container** or **Dependency Injection**. Its started out as a means to help out with Enterprise Java Beans(EJB) development, but at its current state, it does not depend on beans.

   **NOTE: Dependecny Injection is a way of removing hard-wired code in your system, and forcing other to fulfill the dependencies as and when the object is required.**

   * Spring can be used with or without EJB, although lately, it is used independent of EJBs.
   * Spring is POJO (Plain Old Java Object) based. It means spring projects can be written without Spring at all.
   * Spring uses AOP and Proxies to address cross-cutting concerns. This should make your code more readable, modular and less scattered.

   The biggest problme that Spring (in comparison to J2EE) solves is **Testability**, **Maintainabaility**, **Scalability**. It helps reduce the **Code Complexity** and allows us to focus on **Business Logic**.

# Demo - Java App in Plain Old Java Object(POJO) Style