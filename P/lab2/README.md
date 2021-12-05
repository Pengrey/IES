# Review questions

### A. What are the responsibilities/services of a “servlet container”?

A servlet container is responsible for dynamically generate the web page on the server side. A servlet container is a manager of servlets, it manages the life cycle of servlets.

 

### B. Explain, in brief, the “dynamics” of Model-View-Controller approach used in Spring Boot to serve web content. (You may exemplify with the context of the previous exercises.)

A Spring Model-View-Controller is a framework that helps building web applications, it follows as the name says a Model-View-Controller model where the model contains the data of the web app and the controller is the one that manages the flow of the app while the view indicates the view format of the app. 

In the previous exercises we used a Controller (GreetingController), a view (/templates/greeting) and a Model.

### C. Inspect the POM.xml for the previous Spring Boot projects. What is the role of the “starters” dependencies?

The starters dependecies are used to bootstrap our application, this means that it builds tests for it and starts it if needed being this dependecies our entrypoint to our new webapp.

### D. Which annotations are transitively included in the @SpringBootApplication?

```java
@ComponentScan
@Configuration
@EnableAutoConfiguration
```

### E. Search online for the topic “Best practices for REST API design”. From what you could learn, select your “top 5” practices, and briefly explain them in you own words.

1. Accept and respond with JSON
JSON is the standard for transfering data, this means that for availability and good practices we should accept JSON and respond JSON
2. Use nouns instead of verbs in endpoint paths
Due to the way HTTP request methods are formed we should use nouns, the http call are already verbs so making endpoint paths nouns simplifies the interaction, making it less confusing.
3. Nesting resources for hierarchical objects
For better organisation we should nest resources for hierachical objects, it helps the clients by having a well know structure to traverse and get the data and its the standard .
4. Maintain Good Security Practices
An API is an entry point to various applications, either our own or our clients, following good security practices helps mantaining the integrity of the information and availability of it.
5. Versioning our APIs
Versioning our APIs will help our clients maintain their application and also port their app to the newer version in gradual steps, it will also prevent to break their side of the app.