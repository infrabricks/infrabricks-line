FROM    ubuntu:14.10
MAINTAINER Peter Rossbach peter.rossbach@bee42.com @PRossbach

RUN DEBIAN_FRONTEND=noninteractive \
  && apt-get update \
  && apt-get install -y nano \
   wget \
   dialog \
   net-tools \
   nginx \
  && rm -rf /var/lib/apt/lists/*

ADD nginx.conf /etc/nginx/
ADD node.conf /etc/nginx/conf.d/node.conf
EXPOSE 80
CMD service nginx start
