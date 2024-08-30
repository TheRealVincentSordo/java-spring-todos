# java-spring-todos
This is a simple Java Spring Boot CRUD app for TODOs

## Configuration
This app is setup using a local postgres database
In front of this service I have a React app that is running on port 3000.

### CORS
When developing an app locally you can sometimes get a error like 
```
Access to XMLHttpRequest at 'http://localhost:8080/todos' from origin 'http://localhost:3000' has been blocked by CORS policy: No 'Access-Control-Allow-Origin' header is present on the requested resource.
```
To get around this issue you can include a CORSConfig class that allows the connections from a local port.
Take a look at my example in this repo if you run into these issues.