# E9

# Transactional - Part 2
Note: the @Transactional can be also placed above a class and not only methods. They override each other according to 
the priority order; from lowest to highest we have: interface, superclass, class, interface method, superclass method, 
and class method. Usually it's not recommended to set @Transactional on the interface; however, it is acceptable for 
cases like @Repository with Spring Data.

**Propagation** defines our business logic's transaction boundary. Spring manages to start and pause a transaction 
according to our propagation setting.

Here the different propagation levels:

- REQUIRED (Default)
- REQUIRES_NEW
- MANDATORY
- NEVER
- SUPPORTS
- NOT_SUPPORTED
- NESTED (very rare to use it)

For more info on how they work: https://www.baeldung.com/spring-transactional-propagation-isolation

Example 1:

In this first example, a Runtime exception will be thrown once i == 5 and even the first 5 execution of addBook will be
marked as rollback because the propagation level is set as REQUIRED

    @Transactional // Propagation level is REQUIRED by default
    public void addBook(String title, Double price) {  // here is where the transaction is created
        String sql = "INSERT INTO book VALUES (NULL, ?, ?)";
        jdbcTemplate.update(sql, title, price);
    }// here is where the transaction is commited

    @Transactional
    public void addTenBook(){
        for (int i=1; i <= 10; i++){
            bookRepository.addBook("Book"+i, 10.00);
            if (i == 5) throw new RuntimeException("Something went wrong!");
        }
    }

Example 2:
    
In this example, the five addBook before the exception will be executed and we will find the books in the db.

    @Transactional (propagation = Propagation.REQUIRES_NEW)
    public void addBook(String title, Double price) {
        String sql = "INSERT INTO book VALUES (NULL, ?, ?)";
        jdbcTemplate.update(sql, title, price);
    }

    @Transactional
    public void addTenBook(){
        for (int i=1; i <= 10; i++){
            bookRepository.addBook("Book"+i, 10.00);
            if (i == 5) throw new RuntimeException("Something went wrong!");
        }
    }

Example 4:

In this example, 5 books are created.

    @Transactional (propagation = Propagation.NOT_SUPPORTED)
    public void addBook(String title, Double price) {
        String sql = "INSERT INTO book VALUES (NULL, ?, ?)";
        jdbcTemplate.update(sql, title, price);
    }

    @Transactional
    public void addTenBook(){
        for (int i=1; i <= 10; i++){
            bookRepository.addBook("Book"+i, 10.00);
            if (i == 5) throw new RuntimeException("Something went wrong!");
        }
    }

Example 4:

In this example, nothing is created.

    @Transactional (propagation = Propagation.MANDATORY)
    public void addBook(String title, Double price) {
        String sql = "INSERT INTO book VALUES (NULL, ?, ?)";
        jdbcTemplate.update(sql, title, price);
    }

    @Transactional
    public void addTenBook(){
        for (int i=1; i <= 10; i++){
            bookRepository.addBook("Book"+i, 10.00);
            if (i == 5) throw new RuntimeException("Something went wrong!");
        }
    }

Example 5:

In this example, nothing is created and we receive also a different exception. Is the opposite of MANDATORY
.IllegalTransactionStateException: Existing transaction found for transaction marked with propagation 'never'

    @Transactional (propagation = Propagation.MANDATORY)
    public void addBook(String title, Double price) {
        String sql = "INSERT INTO book VALUES (NULL, ?, ?)";
        jdbcTemplate.update(sql, title, price);
    }

    @Transactional
    public void addTenBook(){
        for (int i=1; i <= 10; i++){
            bookRepository.addBook("Book"+i, 10.00);
            if (i == 5) throw new RuntimeException("Something went wrong!");
        }
    }

Example 6:

In this example, nothing is created.

    @Transactional (propagation = Propagation.SUPPORTS)
    public void addBook(String title, Double price) {
        String sql = "INSERT INTO book VALUES (NULL, ?, ?)";
        jdbcTemplate.update(sql, title, price);
    }

    @Transactional
    public void addTenBook(){
        for (int i=1; i <= 10; i++){
            bookRepository.addBook("Book"+i, 10.00);
            if (i == 5) throw new RuntimeException("Something went wrong!");
        }
    }