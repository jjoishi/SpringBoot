This directory has all trails and experiments with Spring Boot framework in Java.

# Table of contents
* [Installation](https://github.com/jjoishi/SpringBoot#installation)
* [Maven](https://github.com/jjoishi/SpringBoot/tree/master/Maven)

# Installation

## Get Java SDK
Oracle's JDK are now licensed based. However, production ready open-source builds of Oracle's JDK can be downloaded from the site - https://jdk.java.net/.
In my case, I have downloaded JDK version 14 (zipped file). 

## Get IntelliJ IDEA
IntelliJ IDEA IDE can be downloaded from - https://www.jetbrains.com/idea/download/. I have downloaded the zipped package of the IntelliJ IDEA COmmunity Edition, version 2019.3.4. 

## Setup
The main motive behind downloading the zipped packages was to avoid setting too many environment variables in the system, and focus on using Java only on IntelliJ IDE. ( Please note that since Java SDK and IntelliJ IDE are not installed, and their respective HOME directories are not set on PATH, both Java and IntelliJ cannot be invoked from Windows command line).

### Associate JDK 14 with IntelliJ:
1. Launch IntelliJ. Create a new project by using 'Create New Project' option from the welcome screen, or using File  > New > Project.
2. In the project type, select Java
3. For the field Project SDK, select Add JDK, and browse to the location of extracted contents of JDK 14.
4. Ignore option to create a project from template. Instead on the next page, provide a Project Name and Project's location.
5. Click Finish.

Not only have you associated JDK 14 with Intellij, you have also created a new project to work on. For any subsequent Java projects, the path to JDK would be available handy.
In the project view, you can add Java class to your project, providing an appropriate package and class name.

More information can be found here - https://www.jetbrains.com/help/idea/creating-and-running-your-first-java-application.html