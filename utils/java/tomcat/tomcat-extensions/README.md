# Tomcat extensions


## build

```
$ mvn package
$ mvn install
```

## Stdout Access Log Valve

If you run tomcat inside docker container it is usefull that
all your log output can be handle by docker daemon.

### Configure like standard Tomcat output logging

`<date> <class> <method|type> <level>: <msg>`

```
<Valve className="io.infrabricks.catalina.valves.AccessLogStdoutValve"
  pattern="%{begin:yyyy-MM-dd'T'HH:mm:ss:SSSZ}t org.apache.catalina.valves.AccessLogValve access INFO: %h &quot;%r&quot; &quot;%{Referer}i&quot; &quot;%{User-Agent}i&quot; %s %b &quot;%I&quot; %D %S" />
```

Regards
Peter
