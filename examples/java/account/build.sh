#!/bin/bash
IMAGE=hysterix-account
ACCOUNT=infrabricks
TAG=0.2.0
docker build -t="${ACCOUNT}/$IMAGE" .
DATE=`date +'%Y%m%d%H%M'`
IID=$(docker inspect -f "{{.Id}}" ${ACCOUNT}/$IMAGE)
docker tag -f $IID ${ACCOUNT}/$IMAGE:$DATE
docker tag -f $IID ${ACCOUNT}/$IMAGE:$TAG
