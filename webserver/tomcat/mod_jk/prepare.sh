#!/bin/bash
docker build -t infrabricks/jk:debian8 -f Dockerfile.debian8 .
docker run infrabricks/jk:debian8
CID=$(docker ps -ql)
docker cp ${CID}:/jk/modules/mod_jk.so debian8
docker rm ${CID}
