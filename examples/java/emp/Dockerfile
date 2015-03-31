FROM java:8

MAINTAINER Peter Rossbach <peter.rossbach@bee42.com>

WORKDIR /app

ENV TOMCAT_APP=emp \
    JAVA_MAXMEMORY=256

ADD target/emp-0.1.0 /app/emp

ADD https://repo1.maven.org/maven2/com/github/jsimone/webapp-runner/8.0.18.0-M1/webapp-runner-8.0.18.0-M1.jar /app/tomcat8-runner.jar
COPY runner.sh /app/runner.sh

EXPOSE 8080

CMD [ "/app/runner.sh" ]

ADD LICENSE.webapprunner /etc/LICENSE.webapprunner
ADD LICENSE /etc/LICENSE.emp
RUN COPYDATE=`date  +'%Y'` \
 && echo "infrabricks emp" >/etc/provisioned.emp \
 && date >>/etc/provisioned.emp \
 && echo >>/etc/provisioned.emp \
 && echo " Copyright ${COPYDATE} by <peter.rossbach@bee42.com> bee42 solutions gmbh" >>/etc/provisioned.emp
