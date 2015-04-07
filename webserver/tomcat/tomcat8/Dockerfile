FROM java:8-jre

MAINTAINER Peter Rossbach <peter.rossbach@bee42.com>

ENV TOMCAT_MAJOR_VERSION=8 \
 TOMCAT_MINOR_VERSION=8.0.20 \
 CATALINA_HOME=/opt/tomcat \
 JOLOKIA_VERSION=1.2.3 \
 JAVA_MAXMEMORY=512 \
 TOMCAT_MAXTHREADS=250 \
 TOMCAT_MINSPARETHREADS=4 \
 TOMCAT_HTTPTIMEOUT=20000 \
 TOMCAT_AJPTIMEOUT=410000 \
 DEPLOY_DIR=/webapps \
 LIBS_DIR=/libs \
 PATH=$PATH:$CATALINA_HOME/bin \


RUN DEBIAN_FRONTEND=noninteractive \
  apt-get update \
  && apt-get install -yq pwgen \
  && apt-get clean autoclean \
  && apt-get autoremove -y \
  && rm -rf /var/lib/{apt,dpkg,cache,log}/

# INSTALL Docker (for detect correct JVM_ROUTE)
ADD https://get.docker.io/builds/Linux/x86_64/docker-1.5.0 /usr/local/bin/docker

# INSTALL TOMCAT
RUN wget -q https://archive.apache.org/dist/tomcat/tomcat-${TOMCAT_MAJOR_VERSION}/v${TOMCAT_MINOR_VERSION}/bin/apache-tomcat-${TOMCAT_MINOR_VERSION}.tar.gz && \
  wget -qO- https://archive.apache.org/dist/tomcat/tomcat-${TOMCAT_MAJOR_VERSION}/v${TOMCAT_MINOR_VERSION}/bin/apache-tomcat-${TOMCAT_MINOR_VERSION}.tar.gz.md5 | md5sum -c - && \
  tar zxf apache-tomcat-*.tar.gz && \
  rm apache-tomcat-*.tar.gz && \
  mv apache-tomcat* ${CATALINA_HOME} && \
  rm -rf ${CATALINA_HOME}/webapps/examples \
  ${CATALINA_HOME}/webapps/docs \
  ${CATALINA_HOME}/webapps/ROOT \
  ${CATALINA_HOME}/webapps/host-manager \
  ${CATALINA_HOME}/RELEASE-NOTES \
  ${CATALINA_HOME}/RUNNING.txt \
  ${CATALINA_HOME}/bin/*.bat \
  ${CATALINA_HOME}/bin/*.tar.gz \
  && mkdir -p ${CATALINA_HOME}/work ${CATALINA_HOME}/temp

RUN wget -q http://labs.consol.de/maven/repository/org/jolokia/jolokia-war/${JOLOKIA_VERSION}/jolokia-war-${JOLOKIA_VERSION}.war \
  && mv jolokia-war-${JOLOKIA_VERSION}.war ${CATALINA_HOME}/webapps/jolokia.war

ADD conf/server.xml ${CATALINA_HOME}/conf/server.xml
ADD conf/logging.properties ${CATALINA_HOME}/conf/logging.properties
ADD bin/create_tomcat_user.sh ${CATALINA_HOME}/bin/create_tomcat_user.sh
ADD bin/tomcat.sh ${CATALINA_HOME}/bin/tomcat.sh
RUN chmod +x ${CATALINA_HOME}/bin/*.sh /usr/local/bin/docker
ADD lib/tomcat-extensions.jar ${CATALINA_HOME}/lib/tomcat-extensions.jar
ADD lib/jolokia-access.xml ${CATALINA_HOME}/lib/jolokia-access.xml

WORKDIR /opt/tomcat

EXPOSE 8080
EXPOSE 8009

ADD LICENSE /etc/LICENSE.tomcat8
RUN COPYDATE=`date  +'%Y'` \
 && echo "infrabricks tomcat8" >/etc/provisioned.tomcat8 \
 && date >>/etc/provisioned.tomcat8 \
 && echo >>/etc/provisioned.tomcat8 \
 && echo " Copyright ${COPYDATE} by <peter.rossbach@bee42.com> bee42 solutions gmbh" >>/etc/provisioned.tomcat8

CMD ["/opt/tomcat/bin/tomcat.sh"]
