#!/bin/bash

if [[ ! -d /data/apache2-jk-config ]]; then
	mkdir /data/apache2-jk-config
fi

if [[ ! -d /data/apache2-log ]]; then
	mkdir /data/apache2-log
fi

# embed workers.properties
F_HOST=/data/apache2-jk-config/workers.properties
F_CONT=/etc/libapache2-mod-jk/workers.properties

if [[ ! -f $F_HOST ]]; then
	touch $F_HOST
fi

ID=$(docker run \
	--detach 	\
	-v $F_HOST:$F_CONT \
	-v /data/apache2-log/:/var/log/apache2/ \
	-p 80   \
	--name apache2 \
	infrabricks/httpd_debian-jk
)

echo started apache in $ID

docker port $ID 80
