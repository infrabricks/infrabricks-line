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

## Other option

* define a docker-compose.yml
* Use exec plugin to start/stop container

```
<plugin>
  <artifactId>exec-maven-plugin</artifactId>
  <groupId>org.codehaus.mojo</groupId>
  <executions>
      <execution>
        <id>start</id>
        <phase>pre-integration-test</phase>
        <goals>
          <goal>exec</goal>
        </goals>
        <configuration>
          <executable>${basedir}/scripts/dc-start.sh</executable>
        </configuration>
      </execution>
      <execution>
        <id>stop</id>
        <phase>post-integration-test</phase>
        <goals>
          <goal>exec</goal>
        </goals>
        <configuration>
          <executable>${basedir}/scripts/dc-stop.sh</executable>
        </configuration>
      </execution>
    </executions>
</plugin>
```

``
## Reference
* `mvn docker:stop` - only working inside maven process (test, exec stages)!
* https://github.com/rhuss/docker-maven-plugin
