#!/bin/sh

#-v $(pwd)/target/qrcode-0.0.1:/opt/tomcat/webapps/qrcode \
docker run -d -p 8580:8080 \
  -v $(pwd)/tomcat-users.xml:/opt/tomcat/conf/tomcat-users.xml \
  -v /var/run/docker.sock:/var/run/docker.sock \
  infrabricks/tomcat:8
