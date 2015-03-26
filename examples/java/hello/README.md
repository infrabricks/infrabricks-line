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

## start with docker maven plugin

```
mvn package
mvn docker:start
curl -Ls <dockerhost ip>:<port>/hello/status.jsp |jq '.Hostname'
```

* `mvn docker:stop` - only working inside maven process (test, exec stages)!
* https://github.com/rhuss/docker-maven-plugin
