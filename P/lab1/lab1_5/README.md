### Add maven project as dependency for another

The best practice is to "publish" the .jar file to a local Maven repository nested within the project.

For this we will need to add a lib directory on the root of the project:

```bash
cd project
mkdir lib
```

Get a package from the project we want to use as a dependency

```bash
cd dependencyProject
mvn package
```

Publish the .jar to the lib directory on the main project:

```bash
mvn org.apache.maven.plugins:maven-install-plugin:2.5.2:install-file \
  -Dfile=jar/path/dependencu.jar \
  -DgroupId=IpmaApi.Client \
  -DartifactId=IpmaApiClient \
  -Dversion=1.0-SNAPSHOT \
  -Dpackaging=jar \
  -DlocalRepositoryPath=lib
```

If we ever update the dependency project we should publish the jar again after we create it and then execute the following command to make the main project with the updated dependencies: 

```bash
mvn clean package
```

With the jar added we just need now to define it on the pom.xml file

Define the lib repo:

```bash
<repositories>
    <repository>
        <id>my-local-repo</id>
        <url>file://${basedir}/lib</url>
    </repository>
</repositories>
```

Define the dependency project:

```bash
<dependencies>
    <dependency>
        <groupId>dep.project</groupId>
        <artifactId>dep.projectID</artifactId>
        <version>x.x.x</version>
    </dependency>
</dependencies>
```

### Run the program:

```bash
mvn exec:java -Dexec.mainClass="WeatherForecastByCity.App.App" -Dexec.args="Aveiro"
```