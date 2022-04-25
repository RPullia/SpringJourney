# E4

## More about Dependency Injection

We will try to understand how to link beans that are inside the context.

First of all we have defined inside the ProjectConfig the beans for Author and Book. Then we have showed different ways to link them

#Author1
We have wired the Book's bean to the Author's one using the method book() inside the setter.
With this technique, Spring will look for a Book's bean already present in the context and will inject it inside the Author's bean.


#Author2
This time the Book's bean is passed as a parameter to the author2 method. This solution is better than the previous one, since it 
allows you to have many adavantages. For example, assuming that we have multiple configuration classes inside the project, it allows
you to simply take a Bean that is declared in another file. In any case, this is a more "clean code" solution.

