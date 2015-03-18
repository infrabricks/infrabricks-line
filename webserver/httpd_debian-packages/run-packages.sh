#!/bin/bash
mkdir -p packages
docker run --rm -v `pwd`/packages:/packages infrabricks/httpd-packages
