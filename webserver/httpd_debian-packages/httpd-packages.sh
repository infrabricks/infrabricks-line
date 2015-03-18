#!/bin/bash

echo "create apache package download list"
# apache2-api-20120211

>/tmp/apache2-pkglist
for p in apache2 apache2-bin apache2-data libapr1 libaprutil1 libaprutil1-dbd-sqlite3 libaprutil1-ldap ssl-cert libapache2-mod-jk openssl libldap-2.4-2  libxml2 libgssapi3-heimdal libsasl2-2 libsasl2-modules-db libasn1-8-heimdal libhcrypto4-heimdal libheimntlm0-heimdal libkrb5-26-heimdal libroken18-heimdal libheimbase1-heimdal libhx509-5-heimdal libwind0-heimdal; do
  apt-get --print-uris --yes download $p | grep -E "http" | tr -d "\'" | awk '{ print $1 }' >>/tmp/apache2-pkglist
done
mkdir -p /packages
cd /packages
cat /tmp/apache2-pkglist
echo "start apache package download"
wget --quiet --input-file /tmp/apache2-pkglist
ls -la /packages
