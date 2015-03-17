FROM busybox
MAINTAINER Peter Rossbach <peter.rossbach@bee42.com> @PRossbach

RUN mkdir -p /opt/tomcat/webapps
ADD status /opt/tomcat/webapps/status

VOLUME ["/opt/tomcat/webapps/status"]

CMD true
