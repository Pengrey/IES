# Maven

Apache Maven is a software project management and comprehension tool. Based on the concept of a project object model (POM), Maven can manage a project's build, reporting and documentation from a central piece of information.

### Main objectives:

- Making the build process easy
- Providing a uniform build system
- Providing quality project information
- Encouraging better development practices

### Creating a Project:

To create a project we first need to create a directory somewhere and start a shell in that directory. After that we execute a similar command:

```bash
mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
```

In this case the folder structure will follow the following:
```bash
my-app
|-- pom.xml
`-- src
    |-- main
    |   `-- java
    |       `-- com
    |           `-- mycompany
    |               `-- app
    |                   `-- App.java
    `-- test
        `-- java
            `-- com
                `-- mycompany
                    `-- app
                        `-- AppTest.java
```
> Note:
The command previously executed created a directory woth the same name given as the artifactId
>
The `src/main/java` directory contains the project source code, the `src/test/java` directory contains the test source, and the `pom.xml` file is the project's Project Object Model, or POM.

### The POM

The `pom.xml` file is the core of a project's configuration in Maven. It is a single configuration file that contains the majority of information required to build a project in just the way we want. This project's POM is:

```xml

1. <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
2.   xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
3.   <modelVersion>4.0.0</modelVersion>
4.  
5.   <groupId>com.mycompany.app</groupId>
6.   <artifactId>my-app</artifactId>
7.   <version>1.0-SNAPSHOT</version>
8.  
9.   <properties>
10.     <maven.compiler.source>1.7</maven.compiler.source>
11.     <maven.compiler.target>1.7</maven.compiler.target>
12.   </properties>
13.  
14.   <dependencies>
15.     <dependency>
16.       <groupId>junit</groupId>
17.       <artifactId>junit</artifactId>
18.       <version>4.12</version>
19.       <scope>test</scope>
20.     </dependency>
21.   </dependencies>
22. </project>
```

### Build the Project

```bash
mvn package
```

The command line will print out various actions, and end with the following:

```bash
 ...
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.953 s
[INFO] Finished at: 2019-11-24T13:05:10+01:00
[INFO] ------------------------------------------------------------------------
```

Unlike the first command executed (archetype:generate), the second is simply a single word - package. Rather than a goal, this is a phase. A phase is a step in the [build lifecycle](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html), which is an ordered sequence of phases. When a phase is given, Maven executes every phase in the sequence up to and including the one defined. For example, if we execute the compile phase, the phases that actually get executed are:

1. validate
2. generate-sources
3. process-sources
4. generate-resources
5. process-resources
6. compile

We can then test the newly compiled and packaged JAR with the following command:

```bash
java -cp target/my-app-1.0-SNAPSHOT.jar com.mycompany.app.App
```

Which will print the quintessential:

```bash
Hello World!
```

### Running programs:

To run a program that uses maven as a project management and comprehension tool we need to first build it, and then we have several aproaches to running it, as seen before we can just use java -cp:

```bash
java -cp target/my-app-1.0-SNAPSHOT.jar com.mycompany.app.App
```

But we can also use maven by doing the following:

```bash
mvn exec:java -Dexec.mainClass="weather.WeatherStarter" #adapt to match your own package and class name
```

To execute with arguments we just need to use exec.args:

```bash
mvn exec:java -Dexec.mainClass="MyweatherRadar.App" -Dexec.args="1010500"
```

By doing this, we should receive the jar output and the status:

```bash
[INFO] Scanning for projects...
[INFO] 
[INFO] -------------------< com.MyweatherRadar.app:my-app >--------------------
[INFO] Building my-app 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- exec-maven-plugin:3.0.0:java (default-cli) @ my-app ---

...

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  15.992 s
[INFO] Finished at: 2021-10-12T20:23:14+01:00
[INFO] ------------------------------------------------------------------------
```