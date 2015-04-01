FROM ubuntu:14.10
MAINTAINER Peter Rossbach <peter.rossbach@bee42.com>

RUN DEBIAN_FRONTEND=noninteractive \
    apt-get update && apt-get -y install curl && \
    rm -rf /var/lib/apt/lists/*

ENV CT_URL https://github.com/hashicorp/consul-template/releases/download/v0.8.0/consul-template_0.8.0_linux_amd64.tar.gz
RUN curl -L $CT_URL | tar -C /usr/local/bin --strip-components 1 -zxf -
#ADD consul-template /usr/local/bin/consul-template
ADD run.sh /app/run.sh
ADD restart-nginx.sh /app/restart-nginx.sh

RUN chmod +x /app/*.sh \
  /usr/local/bin/consul-template

ADD nginx.conf /app/templates/nginx.conf

VOLUME [ "/app/export" ]
WORKDIR /app
CMD ["/app/run.sh"]
