FROM busybox
MAINTAINER Peter Rossbach <peter.rossbach@bee42.com>

RUN mkdir -p /opt/tomcat/webapps
ADD target/qrcode-0.0.1 /opt/tomcat/webapps/qrcode

VOLUME ["/opt/tomcat/webapps/qrcode"]

CMD true
