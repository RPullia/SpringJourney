# E5

## More about Dependency Injection

This time, we will not use the @Bean annotation inside the config class. Instead, we will tag the Author and Book class with
the @Component annotation.


@Autowired used to inject the Book inside Author, by default, requires the existance of the Book's bean inside the context,
but if the Book instance is not created, for exampleassuming that we have not tagged the Book's class with the @Component 
annotation, this situation will raise an exception when we will tryy to retrieve the Author's instance from the context. 
This situation can be avoided like this:

        @Autowired(required = false)

Anyway, this is not a reccomended solution...you will get a NullPointeException at some point!

## @Qualifier

Now, as you can see, in this project only the Author's class is tagged with the @Component annotation, instead the beans of
the Book class are created insidd the configuration class using the @Bean annotation.

We have different possible beans for the Book class, so the use of the @Autowired annotation is not enough to let Sping know 
wich instance of book have to inject inside the Author. To solve this ambiguity problem, we have introduced **@Qualifier** annotation.

Using this annotation with a different value on each bean, we can use the @Qualifier coupled with the @Autowired inside the
Author class, to specify Spring the dependency that need to be injected. 




