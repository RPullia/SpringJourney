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

In order to connect to our DB we need a Bean of type DataSource (an interface from javax.sql package)



