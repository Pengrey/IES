### How Does Jetty Server Work?

Jetty has the ability to run an application like a traditional application server like Tomcat or Wildfly in what is called Standalone deployment.

This isn't really anything special, however, Jetty also has the functionality to operate as a servlet that is embedded in your existing application. This allows you to not run an application in Jetty but to run Jetty in your application.

Why would you ever run Jetty in your application as an embedded system? There are some distinct advantages, including better self-contained applications, the ability to test against server like application dependencies, more control of custom filters, headers and caching, and single object 
deployment. Essentially, these advantages improve application development time specifically in development as developers are able to simplify their manual testing.

That simplification can decrease the amount of time an application can take to start and run because the application is better contained and help promote a more microservice distributed architecture. Not only does the self-contained services simplify the deployment but plugins like [Maven](https://www.jrebel.com/blog/what-is-maven) even further streamline their process because they can hard code, their configurations into their builds.

### Can Jetty Server Run Real Applications?

As Jetty itself is largely just a container, it misses many components that would needed when running more serious apps. There is a Jetty distribution called “Hightide” that provides components and features that are needed to host apps requiring JNDI, JMX, annotations or Java EE integration.

Jetty 9 does not yet offer a distribution for Hightide, but for those who want to use Hightide, there is a distribution based on Jetty 8 available now. Jetty Hightide includes JNDI, JMX, annotations, and also JEE integrations. Even with all those awesome features, it remains lightweight — Hightide is only 24 megabytes in size. As with the regular Jetty installation, Hightide also provides numerous usage and how-to examples to help you understand and use its Java EE integration and features.