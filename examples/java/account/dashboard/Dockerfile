FROM busybox
MAINTAINER Peter Rossbach <peter.rossbach@bee42.com>

ADD https://repo1.maven.org/maven2/com/netflix/hystrix/hystrix-dashboard/1.4.0-rc.8/hystrix-dashboard-1.4.0-rc.8.war /webapps/hystrix-dashboard.war

VOLUME ["/webapps"]

CMD true

ADD LICENSE /etc/LICENSE.hystrix-dashboard
RUN COPYDATE=`date  +'%Y'` \
 && echo "infrabricks hystrix-dashboard" >/etc/provisioned.hystrix-dashboard \
 && date >>/etc/provisioned.hystrix-dashboard \
 && echo >>/etc/provisioned.hystrix-dashboard \
 && echo " Copyright ${COPYDATE} by <peter.rossbach@bee42.com> bee42 solutions gmbh" >>/etc/provisioned.hystrix-dashboard
