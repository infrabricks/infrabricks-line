#!/bin/sh
exec consul-template \
     -consul=consul:8500 \
     -retry 30s \
     -wait 5s:15s \
     -log-level=debug \
     -template "/app/templates/nginx.conf:/app/export/etc/nginx/conf.d/node.conf:/app/restart-nginx.sh"
