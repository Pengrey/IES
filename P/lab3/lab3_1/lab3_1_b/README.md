# Questions

### The “UserController” class gets an instance of “userRepository” through its constructor; how is this new repository instantiated?

The new repository is instantiated with the help of the tag @Autowired and the method UserController as seen below:

```java
private final UserRepository userRepository;

@Autowired
public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
}
```

### List the methods invoked in the “userRepository” object by the “UserController”. Where are these methods defined?

The methods invoked in the "userRepository" object by the "Usercontroller" are:

- findAll
- findByName
- save
- findById
- delete

All the methods besides findByName are defined on the org.springframework.data.repository.CrudRepository where as the findByName is defined on the interface UserRepository

### Where is the data being saved?

The data is being save onto the Hibernate Session

### Where is the rule for the “not empty” email address defined?

The rule of not empty is defined on the User class as follows:

```java
@NotBlank(message = "Email is mandatory")
private String email;
```