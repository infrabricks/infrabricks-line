FROM java:8-jre
MAINTAINER Peter Rossbach <peter.rossbach@bee42.com> @PRossbach

ENV JAVA_OPTS="-server \
-Xmx256m \
-Djava.awt.headless=true \
-Djava.security.egd=file:/dev/./urandom \
-Dsun.net.client.defaultReadTimeout=180000 \
-Dsun.net.client.defaultConnectTimeout=180000 \
-Djava.net.preferIPv4Stack=true \
-Dsun.net.inetaddr.ttl=15 \
-Djava.rmi.server.hostname=127.0.0.1 \
-Djava.rmi.server.useLocalHostname=true \
-Dcom.sun.management.jmxremote \
-Dcom.sun.management.jmxremote.ssl=false \
-Dcom.sun.management.jmxremote.authenticate=false"

EXPOSE 8080
ADD maven/* /app/
# spotify
#ADD hello-0.1.0.jar /app/hello-0.1.0.jar
ADD run.sh /app/run.sh
WORKDIR /app
ENTRYPOINT [ "/app/run.sh" ]
