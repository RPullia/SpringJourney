# E2

## The stereotype annotation @Component

In this project we will see another way to create Beans, different from the ones we used in e1-spring-context.
We will use the stereotype annotation **@Component** above the MyBean class. This annotation will create an instance of that class 
inside the context, but is not enough if used alone...

In order to let it work, we have to use the **@ComponentScan** annotation inside the ProjectConfig class. 
Using this annotation, Spring will know that will have to scan the project to identify, we can also specify the package to scan like this: 

`@ComponentScan(basePackages = "beans")`

So this time there is no need to specify methods with @Bean annotation in the ProjectConfig. 
At the start of the main class, Spring will start the project and will create a default instance of MyBean.

**And if we don't want a default instance?**

Let's assume that we want to initialize the Bean's instance, for example assign some value to the text attribute.
We can define an initializer method, and we can tag it using the **@PostConstructor** annotation, for example:

     @PostConstruct
     private void init(){
        this.text = "Hello I'm a Component";
     }
