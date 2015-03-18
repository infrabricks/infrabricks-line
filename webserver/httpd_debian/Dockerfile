FROM debian:8
MAINTAINER Peter Rossbach <peter.rossbach@bee42.com> @PRossbach

RUN apt-get update \
  && DEBIAN_FRONTEND=noninteractive apt-get -yq install \
        curl \
        apache2 \
  && rm -rf /var/lib/apt/lists/*

VOLUME [ "/var/log/apache2"]

EXPOSE 80
ENTRYPOINT [ "/usr/sbin/apache2ctl" ]
CMD [ "-D", "FOREGROUND", "-k", "start"]
