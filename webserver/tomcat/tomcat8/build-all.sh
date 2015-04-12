#!/bin/bash
IMAGE=tomcat
ACCOUNT=infrabricks
TAG_SHORT=8
TAG_LONG=8.0.21
docker build -t="${ACCOUNT}/$IMAGE" .
DATE=`date +'%Y%m%d%H%M'`
IID=$(docker inspect -f "{{.Id}}" ${ACCOUNT}/$IMAGE)
docker tag -f $IID ${ACCOUNT}/$IMAGE:$DATE
docker tag -f $IID ${ACCOUNT}/$IMAGE:$TAG_SHORT
docker tag -f $IID ${ACCOUNT}/$IMAGE:$TAG_LONG

docker build -t="${ACCOUNT}/${IMAGE}:${TAG_SHORT}-dev" -f Dockerfile.dev .
IID=$(docker inspect -f "{{.Id}}" ${ACCOUNT}/$IMAGE:${TAG_SHORT}-dev)
docker tag -f $IID ${ACCOUNT}/${IMAGE}:${TAG_LONG}-dev

docker build -t="${ACCOUNT}/${IMAGE}:${TAG_SHORT}-tcnative" -f Dockerfile.tcnative-build .
IID=$(docker inspect -f "{{.Id}}" ${ACCOUNT}/$IMAGE:${TAG_SHORT}-tcnative)
docker tag -f $IID ${ACCOUNT}/${IMAGE}:${TAG_LONG}-tcnative

docker build -t="${ACCOUNT}/${IMAGE}:${TAG_SHORT}-volume" -f Dockerfile.volume .
IID=$(docker inspect -f "{{.Id}}" ${ACCOUNT}/$IMAGE:${TAG_SHORT}-volume)
docker tag -f $IID ${ACCOUNT}/${IMAGE}:${TAG_LONG}-volume
