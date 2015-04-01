FROM ubuntu:14.10
MAINTAINER Peter Rossbach peter.rossbach@bee42.com @PRossbach

RUN DEBIAN_FRONTEND=noninteractive \
 && apt-get update \
 && apt-get install -y redis-server \
 && rm -rf /var/lib/apt/lists/*

EXPOSE      6379
ENTRYPOINT  ["/usr/bin/redis-server"]
