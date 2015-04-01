#!/bin/bash
/usr/local/bin/docker exec $NGINX_CID /bin/sh -c '/usr/sbin/nginx -s reload && echo $(date) >>/tmp/restart.log'
echo "restart $NGINX_CID with result ($?) after template changed!"
#/usr/local/bin/docker exec -it $NGINX_CID /bin/bash -c \
# 'kill -HUP $(cat /var/run/nginx.pid)'
