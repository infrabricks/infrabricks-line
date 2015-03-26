# Simple hello

## local build without docker
```
mvn package
mvn tomcat7:run

```

Test the local hello app
```
curl -Ls :8080/hello/status.jsp |jq '.Hostname'
open http://localhost:8080/hello/index.jsp
```

