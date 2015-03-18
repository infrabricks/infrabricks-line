# install debian standard apache2 httpd

# build

```
docker build -t infrabricks/httpd_debian .
```

* `/var/log/apache2` is a volume
* only standard debian 8 apache2 packages

# usage

```
CID=$(docker run -d -p 80 infrabricks/httpd_debian)
```

```
docker exec -ti ${CID} tail -f /var/log/apache2/access.log
```

```
docker run --volume-form ${CID} --rm -ti debian:8 tail -f /var/log/apache2/access.log
```

Setup your own simple content!

```
$ cat >index.html <<EOF
hello dockers!
EOF
$ CID=$(docker run -d -p 80 -v $(pwd)/index.html:/var/www/html/index.html infrabricks/httpd_debian)

$ curl -Ls $(boot2docker ip):$(docker port ${CID} | awk 'BEGIN { FS = ":" } ; { print $2 }')/index.html
hello dockers!
```

# Links

* [trusted apache container]()
* [tutum php apache container]()
