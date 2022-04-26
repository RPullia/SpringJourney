# E7

# Aspect Oriented Programming

The Aspect Oriented Programming (AOP) uses the modularity of the OOP bringing it to a new level, where 
the "transversal" functionalities of an application are  treated by separate modules.
A new modularization unit called Aspect is introduced.

Let's take a look at some of the terms used in the AOP:

   - Aspect: A modularization of "cross-cutting" functionality used in various classes. 
     Transaction management or Logging are examples of such functionality in applications. 
     In Spring AOP, Aspects are implemented with normal classes (and we talk about schema-based approach) 
     or normal classes annotated with @Aspect annotation (@AspectJ style).

   - Join Point: A point during program execution, such as method execution or exception handling. 
     In Spring AOP, a join point always represents the execution of a method.

   - Advice: action taken by an aspect at a particular join point. There are several types of Advise 
     including "around," "before" and "after". Many AOP frameworks, including Spring, model an Advice as 
     an interceptor, managing a chain of interceptors around join points.

   - Pointcut: a predicate that matches one or more join points. Each Advice is associated with a pointcut 
     and is executed at each join point that satisfies the expression associated with the pointcut 
     (for example, executing a method with a certain name). The concept of join points that match pointcut 
     expressions is a central node of the AOP. Spring, by default, uses the AspectJ pointcut expression language.

   - Target object: are the objects "connected" to the Aspects, in fact they are also called advised object. 
     Spring uses proxie objects created at runtime to implement the AOP.


In our project, we have added the package "aspects" with the HelloServiceAspect class inside it tagged with
the @Aspect annotation.

Note:
- in order to use the aspect, we have also added the annotation @EnableAspectJAutoProxy above the ProjectConfig class.
- There must be an instance of the aspect in the context, this instance will not be created automatically when running
  the application, its functionality is note the same of a stereotype annotations. That's why we have added also the
  component annotation above the aspect class.

