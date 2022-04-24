# E3

## The stereotype annotations @Service and @Repository

Service, is usually the term used for those classes that are implementg use cases in an application.
Inside an application, we usually define an object as a **@Service** if it process data somehow, or more in general, if
it does something...

With the **@Repository** instead, are those classe that connects to databases in order to work with data.

Notice that we can also tag the service and repository class with the @Component annotation, SPring will not consider it 
as a mistake, anyway, is better to specify the exact purpose of the class. 

## Dependency Injection

Dependency Injection is a fundamental aspect of the Spring framework, through which the Spring container “injects” objects into other objects or “dependencies”. Simply put, this allows for loose coupling of components and moves the responsibility of managing components onto the container.

## @Autowired

Now that the Repository and service have been defined, we want to implement a method addSomeProducts() inside the service class.
Since this method will use the repository class we have defined, we have to link togheter the Service and the repository beans.
If we don't link toghet the two beans, when we will try to get the Service's bean fromt he context inside the main class, we 
will receive a **NullPointerException**.

In order to link the Service and Repository, we will use the annotation **@Autowired** above the Repository object we are defining
in the service class.

The @Autowired annotation can be applied to different elements of our class: to a field, a method or a constructor.
In any case its task is to indicate to Spring which dependencies are required by a given object. These are searched among the instances 
present in the IoC container and, if present, are injected through the constructor or the annotated method.

At runtime the behavior of Spring will be as follows:

- the productRepository bean will be instantiated, since the class is tagged with @Repository. This instance will be stored in the IOC container. 
- Since the component scan is active, the framework will start searching inside the packages that have components to instantiate; 
- The ProductDeliveryService instance has productRepository as a dependency. To resolve this dependency, the framework will check if there is 
  an instance in the IOC container that is a candidate for resolving this dependency and will inject it into the bean. 

The criteria used to resolve dependencies are in order : 

- Matching by name : Spring looks for a bean that is called exactly as per the property name, In our example this check was enough.
- Match by type: If no bean with that name exists, or if more than one exists, Spring looks for a bean in the IOC container of that type.
- Matching by Qualifier: If more than one bean of that type exists, Spring looks for a bean in the IOC container of that type and declares it with an appropriate id. 

You can formally declare a bean id using the @Qualifier annotation along with @Bean. 
When you need to order the inject of a bean with id X just annotate the field with @Autowired("X").
