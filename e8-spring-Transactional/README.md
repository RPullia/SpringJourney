# E8

# Transactional

The first set up of this project, is similar to the one used in the jdbc exercise. We basically defined a dataSource
and a JdbcTemplate as beans inside the project config class. What we are introducing now is te transaction manager.

**PlatformTransactionManager** is the interface that need to be implemented by any object that it's implementing
the TransactionManager in Spring. In this case we will use a **DataSourceTransactionManager**.

Note that we have injected the datasource bean as a parameter both for JdbcTemplate and for TransactionManager.

Talking about transaction, one of the first achievement that we can get using them, is the atomicity of the 
operations. **Atomicity** allow us to perform operations completely if the execution occurs without throwing exception, or
avoid the execution of the operations if problems occur. This is very important when executing, for example, operations
on databases.

To enable Transaction functionality, we have added another annotation to the ProjectConfig class, **@EnableTransactionManagement**.

We have implemented the addOneBook method to throw a RuntimeException at a certain point, without the **@Transactional**
annotation, even if an exception occur at runtime,the book will be added to the db, and this is something that should be
avoided.

Looking at the exception in console, you will also notice that many of them refers to Spring AOP, that's because 
@Transactional is nothing more that a sort of Aspect we have seen in the previous exercise.




