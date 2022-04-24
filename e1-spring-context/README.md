# What is Spring?


Spring is a lightweight framework for creating Java applications. 
Spring is divided into submodules that allow you to create applications of different types: standalone, web, data access, event driven, etc. ... 

All the classes that Spring has to manage are called **Bean** (not to be confused with JavaBean). 
The Spring container that contains all bean is called **IoC Container**. Spring beans, by default, are **Singleton** in scope and eagger. 
Singleton in the sense that you will always have the same instance for the same bean. Eagger in the sense that at context startup, 
Spring attempts to resolve all dependencies specified by the configuration.

The core module is based on the IoC (Inversion of Control) functionality.
The IoC is a pattern that allows the automated management of dependencies: it will be the framework to take care of enhancing the dependencies 
of the classes and not the programmer.



# Spring ApplicationContext

It is the core of a Spring Boot application. It represents the Spring IoC container and is responsible for instantiating, configuring, and assembling beans. 
The container receives instructions on which objects to instantiate, configure, and assemble by reading the configuration metadata. 
Configuration metadata is represented in XML, Java annotations, or Java code.

In this example we have used the AnnotationConfigApplicationContext in the main class passing to it the config class.

`ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);`



# Configuration class of the project - ../src/main/java/config/ProjectConfig

Using the **@Configuration**, we define the configuration class that will be used by the context. There could be multiple configuration class.
In a Spring project you can use XML and annotations at the same time to read configs

Inside the configuration class we will specify the beans in order to create their instance in the Spring context. In this case, even if not usual, the method 
name will not contain a verb. Anyway it will return an instance of a bean automatically in the context when we use the bean annotation



# Beans	- ../src/main/java/beans/..

- The set of beans is declared inside the bean tag.
- Each bean is declared with the bean tag.
- With the id attribute, we indicate the name of the bean, which must be unique within the Spring context.
- With class, we indicate the implementation of the bean's class.

What happen if we specify in the Configuration  more bean of the same class for example with a different attribute's value?

        @Bean
        public AnotherBean anotherBean1(){
            AnotherBean ab = new AnotherBean();
            ab.setText("Hello I'm one more bean! The no 1");
            return ab;
        }

        @Bean
        public AnotherBean anotherBean2(){
            AnotherBean ab = new AnotherBean();
            ab.setText("Hello I'm one more bean! The no 2");
            return ab;
        }

Of course this will raise an exception (NoUniqueBeanDefinition) when asking the context for AnotherBean, 
because Spring will see that there are multiple instance of the same Bean.

But we can solve this problem defining a primary bean with **@Primary**.
In this case if we ask to the context to get a bean by type (AnotherBean), we will get always the instnce of the prymary bean.
If we want to get the instance of the other one, we will have to ask the context to get the bean by name (anotherBean2).

Example:

asking by type:  `AnotherBean ab1 = context.getBean(AnotherBean.class);`

asking by name:  `AnotherBean ab2 = context.getBean("anotherBean2",AnotherBean.class);`


In this case we used the thefault name of the bean (same of the method's name defined in the ProjectConfig).
But we can also assign a specific name to the bean using @Bean("ThisIsMyName")
