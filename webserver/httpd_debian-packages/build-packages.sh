#!/bin/bash
IMAGE=httpd_debian-packages
ACCOUNT=infrabricks
RELEASE_TAG=0.1.0
docker build --no-cache -t="$ACCOUNT/$IMAGE" -f Dockerfile.packages .
DATE=`date +'%Y%m%d%H%M'`
ID=$(docker inspect -f "{{.Id}}" $ACCOUNT/$IMAGE)
docker tag $ID $ACCOUNT/$IMAGE:$DATE
docker tag $ID $ACCOUNT/$IMAGE:$RELEASE_TAG
