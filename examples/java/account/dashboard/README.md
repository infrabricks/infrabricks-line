# Start a simple docker java webapp data container

## set docker env for your docker machine

```
. ./shellinit.sh tomcat
```

## Run tomcat with webapp container

```bash
$ docker-compose up -d
$ docker logs hello_tomcat_1
Checking *.war in /webapps
Checking tomcat extended libs *.jar in /libs
2015-02-11T06:20:01.821+0000 org.apache.catalina.startup.VersionLoggerListener log INFO: Server version:        Apache Tomcat/8.0.18
2015-02-11T06:20:01.824+0000 org.apache.catalina.startup.VersionLoggerListener log INFO: Server built:          Jan 23 2015 11:56:07 UTC
2015-02-11T06:20:01.825+0000 org.apache.catalina.startup.VersionLoggerListener log INFO: Server number:         8.0.18.0
2015-02-11T06:20:01.826+0000 org.apache.catalina.startup.VersionLoggerListener log INFO: OS Name:               Linux
2015-02-11T06:20:01.827+0000 org.apache.catalina.startup.VersionLoggerListener log INFO: OS Version:            3.16.7-tinycore64
2015-02-11T06:20:01.829+0000 org.apache.catalina.startup.VersionLoggerListener log INFO: Architecture:          amd64
2015-02-11T06:20:01.830+0000 org.apache.catalina.startup.VersionLoggerListener log INFO: Java Home:             /usr/lib/jvm/java-8-openjdk-amd64/jre
2015-02-11T06:20:01.840+0000 org.apache.catalina.startup.VersionLoggerListener log INFO: JVM Version:           1.8.0_40-internal-b22
2015-02-11T06:20:01.842+0000 org.apache.catalina.startup.VersionLoggerListener log INFO: JVM Vendor:            Oracle Corporation
2015-02-11T06:20:01.842+0000 org.apache.catalina.startup.VersionLoggerListener log INFO: CATALINA_BASE:         /opt/tomcat
2015-02-11T06:20:01.844+0000 org.apache.catalina.startup.VersionLoggerListener log INFO: CATALINA_HOME:         /opt/tomcat
2015-02-11T06:20:01.845+0000 org.apache.catalina.startup.VersionLoggerListener log INFO: Command line argument: -Djava.util.logging.config.file=/opt/tomcat/conf/logging.properties
2015-02-11T06:20:01.846+0000 org.apache.catalina.startup.VersionLoggerListener log INFO: Command line argument: -Djava.util.logging.manager=org.apache.juli.ClassLoaderLogManager
2015-02-11T06:20:01.846+0000 org.apache.catalina.startup.VersionLoggerListener log INFO: Command line argument: -Duser.language=en
2015-02-11T06:20:01.848+0000 org.apache.catalina.startup.VersionLoggerListener log INFO: Command line argument: -Duser.country=US
2015-02-11T06:20:01.848+0000 org.apache.catalina.startup.VersionLoggerListener log INFO: Command line argument: -Xmx512m
2015-02-11T06:20:01.849+0000 org.apache.catalina.startup.VersionLoggerListener log INFO: Command line argument: -Djava.awt.headless=true
2015-02-11T06:20:01.849+0000 org.apache.catalina.startup.VersionLoggerListener log INFO: Command line argument: -DjvmRoute=5259b04a26ab
2015-02-11T06:20:01.850+0000 org.apache.catalina.startup.VersionLoggerListener log INFO: Command line argument: -Dtomcat.maxThreads=250
2015-02-11T06:20:01.850+0000 org.apache.catalina.startup.VersionLoggerListener log INFO: Command line argument: -Dtomcat.minSpareThreads=4
2015-02-11T06:20:01.853+0000 org.apache.catalina.startup.VersionLoggerListener log INFO: Command line argument: -Dtomcat.httpTimeout=20000
2015-02-11T06:20:01.854+0000 org.apache.catalina.startup.VersionLoggerListener log INFO: Command line argument: -Dtomcat.ajpTimeout=410000
2015-02-11T06:20:01.855+0000 org.apache.catalina.startup.VersionLoggerListener log INFO: Command line argument: -Djava.security.egd=file:/dev/./urandom
2015-02-11T06:20:01.855+0000 org.apache.catalina.startup.VersionLoggerListener log INFO: Command line argument: -Dsun.net.client.defaultReadTimeout=180000
2015-02-11T06:20:01.856+0000 org.apache.catalina.startup.VersionLoggerListener log INFO: Command line argument: -Dsun.net.client.defaultConnectTimeout=180000
2015-02-11T06:20:01.857+0000 org.apache.catalina.startup.VersionLoggerListener log INFO: Command line argument: -Djava.net.preferIPv4Stack=true
2015-02-11T06:20:01.858+0000 org.apache.catalina.startup.VersionLoggerListener log INFO: Command line argument: -Dsun.net.inetaddr.ttl=300
2015-02-11T06:20:01.859+0000 org.apache.catalina.startup.VersionLoggerListener log INFO: Command line argument: -Djava.rmi.server.hostname=127.0.0.1
2015-02-11T06:20:01.859+0000 org.apache.catalina.startup.VersionLoggerListener log INFO: Command line argument: -Djava.rmi.server.useLocalHostname=true
2015-02-11T06:20:01.860+0000 org.apache.catalina.startup.VersionLoggerListener log INFO: Command line argument: -Dcom.sun.management.jmxremote
2015-02-11T06:20:01.861+0000 org.apache.catalina.startup.VersionLoggerListener log INFO: Command line argument: -Dcom.sun.management.jmxremote.ssl=false
2015-02-11T06:20:01.863+0000 org.apache.catalina.startup.VersionLoggerListener log INFO: Command line argument: -Dcom.sun.management.jmxremote.authenticate=false
2015-02-11T06:20:01.864+0000 org.apache.catalina.startup.VersionLoggerListener log INFO: Command line argument: -Djava.endorsed.dirs=/opt/tomcat/endorsed
2015-02-11T06:20:01.865+0000 org.apache.catalina.startup.VersionLoggerListener log INFO: Command line argument: -Dcatalina.base=/opt/tomcat
2015-02-11T06:20:01.866+0000 org.apache.catalina.startup.VersionLoggerListener log INFO: Command line argument: -Dcatalina.home=/opt/tomcat
2015-02-11T06:20:01.867+0000 org.apache.catalina.startup.VersionLoggerListener log INFO: Command line argument: -Djava.io.tmpdir=/opt/tomcat/temp
2015-02-11T06:20:01.971+0000 org.apache.coyote.AbstractProtocol init INFO: Initializing ProtocolHandler ["http-nio-8080"]
2015-02-11T06:20:01.990+0000 org.apache.tomcat.util.net.NioSelectorPool getSharedSelector INFO: Using a shared selector for servlet write/read
2015-02-11T06:20:01.994+0000 org.apache.coyote.AbstractProtocol init INFO: Initializing ProtocolHandler ["ajp-nio-8009"]
2015-02-11T06:20:01.996+0000 org.apache.tomcat.util.net.NioSelectorPool getSharedSelector INFO: Using a shared selector for servlet write/read
2015-02-11T06:20:01.997+0000 org.apache.catalina.startup.Catalina load INFO: Initialization processed in 620 ms
2015-02-11T06:20:02.033+0000 org.apache.catalina.core.StandardService startInternal INFO: Starting service Catalina
2015-02-11T06:20:02.034+0000 org.apache.catalina.core.StandardEngine startInternal INFO: Starting Servlet Engine: Apache Tomcat/8.0.18
2015-02-11T06:20:02.057+0000 org.apache.catalina.startup.HostConfig deployDirectory INFO: Deploying web application directory /opt/tomcat/webapps/status
2015-02-11T06:20:02.430+0000 org.apache.catalina.startup.HostConfig deployDirectory INFO: Deployment of web application directory /opt/tomcat/webapps/status has finished in 372 ms
2015-02-11T06:20:02.438+0000 org.apache.coyote.AbstractProtocol start INFO: Starting ProtocolHandler ["http-nio-8080"]
2015-02-11T06:20:02.442+0000 org.apache.coyote.AbstractProtocol start INFO: Starting ProtocolHandler ["ajp-nio-8009"]
2015-02-11T06:20:02.443+0000 org.apache.catalina.startup.Catalina start INFO: Server startup in 445 ms
```

## Access tomcat with a new shell!
```bash
$ template='{{ range $key, $value := .NetworkSettings.Ports }}{{ $key }}={{ (index $value 0).HostPort }} {{ end }}'
$ docker inspect --format="${template}" hello_tomcat_1
8009/tcp=49153 8080/tcp=49154
$ docker port hello_tomcat_1
8009/tcp -> 0.0.0.0:49157
8080/tcp -> 0.0.0.0:49158
$ curl http://$(docker-machine ip tomcat):49158/status/status.jsp
{
  "Hostname": "5259b04a26ab"
  "Tomcat Version": "Apache Tomcat/8.0.18"
  "Servlet Specification Version": "3.1"
  "JSP version": "2.3"
  "Now": 2015/02/11 06:28:52"
}

## See password at tomcat log output
$ curl --user "admin:AJaANYAF7rFZ" http://$(docker-machine ip tomcat):49158/manager/text/list
OK - Listed applications for virtual host localhost
/status:running:0:status
/jolokia:running:0:jolokia
/manager:running:0:manager
```

## Kill test Tomcat

```bash
$ docker ps
CONTAINER ID        IMAGE                                                  COMMAND                CREATED             STATUS              PORTS                                              NAMES
c38ecdb7103c        127.0.0.1:5000/infrabricks/tomcat:8       /opt/tomcat/bin/tom   4 minutes ago       Up 4 minutes        0.0.0.0:49153->8009/tcp, 0.0.0.0:49154->8080/tcp   tomcat8
$ docker kill c38ecdb7103c
c38ecdb7103c
```

```
$ docker-compose stop
$ docker-compose rm
```
