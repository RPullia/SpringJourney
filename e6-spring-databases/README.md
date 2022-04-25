# E6

# Prerequisites

- Install MySQL Server 8.0.28 - x64
- MySQL Workbench 8.0.28 - x64
- MySQL Shell 8.0.28 - x64
- Create a schema (named spring in my case)
- Tables creation:

        CREATE TABLE `spring`.`book` (
         `idbook` INT NOT NULL AUTO_INCREMENT,
         `title` VARCHAR(45) NULL,
         `price` DOUBLE NULL,
        PRIMARY KEY (`idbook`));

## Connect to a Database

In order to connect to our DB we need a Bean of type DataSource (an interface from javax.sql package), this will allow us to
create a DriverManagerDataSource object that we will use to connect to our DB with **jdbc**.

Of course, in order to connect to the db, we had to specify also the username and the password. As you can imagine, in a real 
enterprise project those parameter are never setted inside the source code, they are stored in some files. We will talk about 
this in the future.

My parameters:

URL:  `localhost:3306/spring`
User: `root`
PW:   `admin`


Anyway, Spring offers us many other ways to connect to databases, we will see them in the future.


As you can see from the ProjectConfig class, we have also created a bean of JsbcTemplate type. It simplifies the use of JDBC 
and helps to avoid common errors. It executes core JDBC workflow, leaving application code to provide SQL and extract results. 
This class executes SQL queries or updates, initiating iteration over ResultSets and catching JDBC exceptions and translating 
them to the generic. Can be used within a service implementation via direct instantiation with a DataSource reference, or get 
prepared in an application context and given to services as bean reference.

https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/jdbc/core/JdbcTemplate.html

We are injecting the DataSource dependecy inside the JdbcTemplate using the method datasource() as we have seen in the
previous exercise.


In order to work with the Book table we have created, we need to implement inside the repositories package the 
BookRepository class. This class is tagged using the stereotype annotation @Repository.

Note: Since we are using a stereotype annotation, and we don't have all the beans definitions inside the ProjectConfig
      class, as we have seen in the past exerxises, we have to add the @ComponentScan annotation above ProjectConfig.

