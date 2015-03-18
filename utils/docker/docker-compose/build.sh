#!/bin/bash
IMAGE=docker-compose
ACCOUNT=infrabricks
TAG_LONG=1.1.0
docker build -t="${ACCOUNT}/$IMAGE" .
DATE=`date +'%Y%m%d%H%M'`
IID=$(docker inspect -f "{{.Id}}" ${ACCOUNT}/$IMAGE)
docker tag -f $IID ${ACCOUNT}/$IMAGE:$DATE
docker tag -f $IID ${ACCOUNT}/$IMAGE:$TAG_LONG
