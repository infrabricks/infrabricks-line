FROM debian:8
MAINTAINER Peter Rossbach <peter.rossbach@bee42.com> @PRossbach

ENV DOCKER_COMPOSE_VERSION 1.1.0
RUN apt-get update && apt-get install -y curl \
 && curl -L https://github.com/docker/compose/releases/download/${DOCKER_COMPOSE_VERSION }/docker-compose-`uname -s`-`uname -m` >/usr/local/bin/docker-compose ; chmod +x /usr/local/bin/docker-compose \
  && apt-get clean autoclean \
  && apt-get autoremove -y \
  && rm -rf /var/lib/{apt,dpkg,cache,log}/

ADD LICENSE /etc/LICENSE.compose
ADD docker-compose /scripts/docker-compose
ADD install /scripts/install

RUN COPYDATE=`date  +'%Y'` \
 && echo "infrabricks fig" >/etc/provisioned.compose \
 && date >>/etc/provisioned.compose \
 && echo >>/etc/provisioned.compose \
 && echo " Copyright ${COPYDATE} by <peter.rossbach@bee42.com> bee42 solutions gmbh" >>/etc/provisioned.compose

WORKDIR /project
ENTRYPOINT [ "/usr/local/bin/docker-compose" ]
CMD [ "" ]
