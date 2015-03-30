FROM java:8

MAINTAINER Peter Rossbach <peter.rossbach@bee42.com>

WORKDIR /app

ENV TOMCAT_APP=hystrix-account \
    JAVA_MAXMEMORY=512

ADD target/hystrix-account-0.2.0 /app/hystrix-account

ADD https://repo1.maven.org/maven2/com/github/jsimone/webapp-runner/8.0.18.0-M1/webapp-runner-8.0.18.0-M1.jar /app/tomcat8-runner.jar
COPY runner.sh /app/runner.sh

EXPOSE 8080

CMD [ "/app/runner.sh" ]

ADD LICENSE.webapprunner /etc/LICENSE.webapprunner
ADD LICENSE /etc/LICENSE.hystrix-account
RUN COPYDATE=`date  +'%Y'` \
 && echo "infrabricks hystrix-account" >/etc/provisioned.hystrix-account \
 && date >>/etc/provisioned.hystrix-account \
 && echo >>/etc/provisioned.hystrix-account \
 && echo " Copyright ${COPYDATE} by <peter.rossbach@bee42.com> bee42 solutions gmbh" >>/etc/provisioned.hystrix-account
