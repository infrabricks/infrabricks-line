FROM ubuntu:14.10
MAINTAINER Peter Rossbach peter.rossbach@bee42.com @PRossbach

RUN DEBIAN_FRONTEND=noninteractive \
  && apt-get update \
  && apt-get -y install curl \
  && curl -sL https://deb.nodesource.com/setup | sudo bash - \
  && apt-get -y install python build-essential \
  && apt-get -y install nodejs \
  && node -v \
  && npm -v \
  && npm install -g nodemon \
  && rm -rf /var/lib/apt/lists/* \
  && mkdir -p /app

ADD package.json /app/package.json
ADD server.js /app/server.js

WORKDIR app

RUN cd /app; npm install

EXPOSE  8080

CMD ["nodemon", "/app/server.js"]
