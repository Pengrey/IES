### Test if apache server is up or not

With the tool Curl:

```bash
curl -I 127.0.0.1:8080
HTTP/1.1 200 
Content-Type: text/html;charset=UTF-8
Transfer-Encoding: chunked
Date: Tue, 26 Oct 2021 13:45:08 GMT
```

or

By accessing the webpage on  [http://localhost:8080](http://localhost:8080/) and see if it up or not.

or

By observing the server log:

```bash
tail logs/catalina.out
26-Oct-2021 14:39:11.254 INFO [main] org.apache.catalina.startup.HostConfig.deployDirectory Deploying web application directory [/home/pengrey/Work/UA/IES/P/IES_98475/lab2/lab2_1/apache-tomcat-9.0.54/webapps/docs]
26-Oct-2021 14:39:11.264 INFO [main] org.apache.catalina.startup.HostConfig.deployDirectory Deployment of web application directory [/home/pengrey/Work/UA/IES/P/IES_98475/lab2/lab2_1/apache-tomcat-9.0.54/webapps/docs] has finished in [10] ms
26-Oct-2021 14:39:11.264 INFO [main] org.apache.catalina.startup.HostConfig.deployDirectory Deploying web application directory [/home/pengrey/Work/UA/IES/P/IES_98475/lab2/lab2_1/apache-tomcat-9.0.54/webapps/examples]
26-Oct-2021 14:39:11.412 INFO [main] org.apache.catalina.startup.HostConfig.deployDirectory Deployment of web application directory [/home/pengrey/Work/UA/IES/P/IES_98475/lab2/lab2_1/apache-tomcat-9.0.54/webapps/examples] has finished in [148] ms
26-Oct-2021 14:39:11.412 INFO [main] org.apache.catalina.startup.HostConfig.deployDirectory Deploying web application directory [/home/pengrey/Work/UA/IES/P/IES_98475/lab2/lab2_1/apache-tomcat-9.0.54/webapps/host-manager]
26-Oct-2021 14:39:11.427 INFO [main] org.apache.catalina.startup.HostConfig.deployDirectory Deployment of web application directory [/home/pengrey/Work/UA/IES/P/IES_98475/lab2/lab2_1/apache-tomcat-9.0.54/webapps/host-manager] has finished in [15] ms
26-Oct-2021 14:39:11.427 INFO [main] org.apache.catalina.startup.HostConfig.deployDirectory Deploying web application directory [/home/pengrey/Work/UA/IES/P/IES_98475/lab2/lab2_1/apache-tomcat-9.0.54/webapps/manager]
26-Oct-2021 14:39:11.440 INFO [main] org.apache.catalina.startup.HostConfig.deployDirectory Deployment of web application directory [/home/pengrey/Work/UA/IES/P/IES_98475/lab2/lab2_1/apache-tomcat-9.0.54/webapps/manager] has finished in [13] ms
26-Oct-2021 14:39:11.442 INFO [main] org.apache.coyote.AbstractProtocol.start Starting ProtocolHandler ["http-nio-8080"]
26-Oct-2021 14:39:11.448 INFO [main] org.apache.catalina.startup.Catalina.start Server startup in [364] milliseconds
```

### Register role on apache manager app

Add the following xml to the conf/tomcat-users.xml file and restart.

```xml
<role rolename="manager-gui"/> 
<role rolename="manager-script"/> 
<user username="admin" password="secret" roles="manager-gui,manager-script"/>
```

```java
Source Code for Request Parameter Example

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RequestParamExample extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Request Parameters Example</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h3>Request Parameters Example</h3>");
        out.println("Parameters in this request:<br>");

        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");

        if (firstName != null || lastName != null) {
            out.println("First Name:");
            out.println(" = " + HTMLFilter.filter(firstName) + "<br>");
            out.println("Last Name:");
            out.println(" = " + HTMLFilter.filter(lastName));
        } else {
            out.println("No Parameters, Please enter some");
        }
        out.println("<P>");
        out.print("<form action=\"");
        out.print("RequestParamExample\" ");
        out.println("method=POST>");
        out.println("First Name:");
        out.println("<input type=text size=20 name=firstname>");
        out.println("<br>");
        out.println("Last Name:");
        out.println("<input type=text size=20 name=lastname>");
        out.println("<br>");
        out.println("<input type=submit>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse res)
    throws IOException, ServletException
    {
        doGet(request, response);
    }
}
```

Create Webapp mvn project

```java
mvn archetype:generate -DgroupId=ies.Webapp -DartifactId=Webapp -DinteractiveMode=false -DarchetypeGroupId=org.codehaus.mojo.archetypes -DarchetypeArtifactId=webapp-javaee7 -DarchetypeVersion=1.1
```

In this case we needed to change later on on the pom file the version of the war plagin.

Create war file to be executed by Tomcat

```java
mvn install
```

Simple webapp that gets username parameter

```java
package Webapp;
 
import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet(name = "APP", urlPatterns = {"/APP"})
public class App extends HttpServlet {
 
    private static final long serialVersionUID = -1915463532411657451L;
 
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
     
        String username = request.getParameter("username");
        try {
            // Write some content
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Hello World</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Welcome " + username + "</h2>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
}
```

We can access the page we built by going to the url:

```
http://localhost:8080/<project name>/<path given on the class>
```

Error logs:

```bash
pengrey@pengrey-sy > tail ../apache-tomcat-9.0.54/logs/localhost.2021-10-27.log 
		at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:357)
		at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:382)
		at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65)
		at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:895)
		at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1722)
		at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)
		at org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1191)
		at org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659)
		at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
		at java.base/java.lang.Thread.run(Thread.java:833)
 pengrey@pengrey-sy >
```