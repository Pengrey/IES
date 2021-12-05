# Review Questions

### A) Explain the differences between the RestController and Controller components used in different parts of this lab.

The Controller annotation is a component that receives `HttpServletRequest` and `HttpServletResponse` instances just like a `HttpServlet` but is able to participate in an MVC workflow. The RestController annotation is a specialized version of the controller annotation, this specialized version does the @controller and the @responsebody annotations job. This helps us by taking us the work of adding the @responsebody annotation to all request mapping methods, being active by default.

### B) Create a visualization of the Spring Boot layers (UML diagram or similar), displaying the key abstractions in the solution of 3.3, in particular: entities, repositories, services and REST controllers.

For us to implement the solution to the exercise 3.3 we used two Controllers, movie and quote, this controllers will be our entrypoint to the application. Next if we make a call on the controller the controller will then calll the service to interact with the repository making the repository abstractedd from the point of view of the controller. The repository will then deal with the two identities movie and quote and with the help of the service we can manage them without the need of making sraight calls to the database.

More inforrmation about the classes can be seen on the Demo.pdf file

### C) Explain the annotations @Table, @Colum, @Id found in the Employee entity.

- @Table: It specifies the table to be used to persist the employee entity in the database
- @Column: It specifies the the column, in this case the columns on the table defined on @Table, to be used to persist the employee's attributes, in this case its used for the name, role and emailAddress.
- @Id: It specifies the attribute to be used for identification of the object on the database, on the employee we use it on the id attribute and its generated automatically, it will later be used for queries and object identification.

### D) Explain the use of the annotation @AutoWired (in the Rest Controller class).

The @Autowired annotation is used to autowire bean on the setter method, this will enable automatic dependency injection on the class EmployeeController enabling the use and sync of the EmployeeRepository.