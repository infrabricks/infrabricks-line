#!/bin/bash

# Autorestart possible?
#-XX:OnError="cmd args; cmd args"
#-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/tmp/heapdump.hprof -XX:OnOutOfMemoryError="sh ~/cleanup.sh"

if [ "${JVM_ROUTE}z" == "z" ]; then
  TOMCAT_JVM_ROUTE=`hostname`
else
  TOMCAT_JVM_ROUTE=$JVM_ROUTE
fi

export LANG="en_US.UTF-8"

if [ -r "/app/jmxremote.access" ]; then
  export JMX_OPTS="-Dcom.sun.management.jmxremote.authenticate=true \
  -Dcom.sun.management.jmxremote.access.file=/app/jmxremote.access \
  -Dcom.sun.management.jmxremote.password.file=/app/jmxremote.password"
else
  export JMX_OPTS="$JMX_OPTS \
  -Dcom.sun.management.jmxremote.authenticate=false"
fi

if [ "${SWAGGER_URL}z" == "z" ]; then
  SWAGGER_URL=http://`hostname`:8080/api
fi

java \
-Xmx${JAVA_MAXMEMORY}m \
-Djava.security.egd=file:/dev/./urandom \
-Duser.language=en -Duser.country=US \
-Djava.awt.headless=true \
-DjvmRoute=${TOMCAT_JVM_ROUTE} \
-Dsun.net.client.defaultReadTimeout=180000 \
-Dsun.net.client.defaultConnectTimeout=180000 \
-Djava.net.preferIPv4Stack=true \
-Dsun.net.inetaddr.ttl=15 \
-Djava.rmi.server.hostname=127.0.0.1 \
-Djava.rmi.server.useLocalHostname=true \
-Dcom.sun.management.jmxremote \
-Dcom.sun.management.jmxremote.ssl=false \
$JMX_OPTS \
-Dswagger.api.basepath=${SWAGGER_URL} \
-jar tomcat8-runner.jar ${TOMCAT_APP}
