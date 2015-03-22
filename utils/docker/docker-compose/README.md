# Docker-Compose for boot2docker and windows

Docker-compose is a very helpfull tool, but it isn't available for windows user and you can't directly install it on boot2docker. Very Bad!

This is a tiny docker tool wrapper from docker-compose :)

## install

### windows

At windows install the docker client
from source or master:

* https://ahmetalpbalkan.com/blog/compiling-docker-cli-on-windows/
* https://master.dockerproject.com/windows/amd64/docker.exe

install the docker-compose script and image to your

```
$ git clone https://github.com/infrabricks/infrabricks-line
$ cd utils/docker/docker-compose
$ docker build -t infrabricks/docker-compose .
# or
$ docker pull infrabricks/docker-compose
# install the script
$ docker run --rm -v $(pwd):/data --entrypoint=/scripts/install infrabricks/docker-compose
```

Move `docker-compose` script to standard directory at your `PATH`.

### boot2docker

```
$ git clone https://github.com/infrabricks/infrabricks-line
$ cd utils/docker/docker-compose
$ docker build -t infrabricks/docker-compose .
# or
$ docker pull infrabricks/docker-compose
# install the script
$ docker run --rm -v /usr/local/bin:/data --entrypoint=/scripts/install infrabricks/docker-compose
```

## Usage

```
cat >docker-compose.yml <<EOF
hello:
  image: hello-world
EOF
./docker-compose up
Creating hello_hello_1...
Pulling image hello-world:latest...
31cbccb51277: Pull complete
e45a5af57b00: Pull complete
.024 kB/1.024 kBBeady exists
hello-world:latest: The image you are pulling has been verified. Important: image verification is a tech preview feature and should not be relied on to provide security.
Status: Downloaded newer image for hello-world:latest
Attaching to hello_hello_1
hello_1 | Hello from Docker.
hello_1 | This message shows that your installation appears to be working correctly.
hello_1 |
hello_1 | To generate this message, Docker took the following steps:
hello_1 |  1. The Docker client contacted the Docker daemon.
hello_1 |  2. The Docker daemon pulled the "hello-world" image from the Docker Hub.
hello_1 |     (Assuming it was not already locally available.)
hello_1 |  3. The Docker daemon created a new container from that image which runs the
hello_1 |     executable that produces the output you are currently reading.
hello_1 |  4. The Docker daemon streamed that output to the Docker client, which sent it
hello_1 |     to your terminal.
hello_1 |
hello_1 | To try something more ambitious, you can run an Ubuntu container with:
hello_1 |  $ docker run -it ubuntu bash
hello_1 |
hello_1 | For more examples and ideas, visit:
hello_1 |  http://docs.docker.com/userguide/
hello_hello_1 exited with code 0
Gracefully stopping... (press Ctrl+C again to force)
```

## Use compose to provision other machines

Access a external server with docker-compose set the
DOCKER_X Variables

```
$ $(boot2docker shellinit)
# or
$ $(docker-machine env dev)
$ docker run -v $PWD:/$(basename $PWD) -v $DOCKER_CERT_PATH:/certs -e DOCKER_CERT_PATH=/certs -e DOCKER_HOST=$DOCKER_HOST -e DOCKER_TLS_VERIFY=$DOCKER_TLS_VERIFY -ti --rm -w /$(basename $PWD) infrabricks/docker-compose --help
```

set an alias

```

$ _docker-compose() {
  _PWD=$PWD
  _BASENAME=$(basename $PWD)
  docker run -v "$_PWD":"/$_BASENAME" \
    -v $DOCKER_CERT_PATH:/certs \
    -e DOCKER_CERT_PATH=/certs \
    -e DOCKER_HOST=$DOCKER_HOST \
    -e DOCKER_TLS_VERIFY=$DOCKER_TLS_VERIFY \
    -ti --rm  -w "$_BASENAME" \
    infrabricks/docker-compose $@
}
$ alias docker-compose="_docker_compose $@"
```

## Links

* https://github.com/docker/compose
* https://docs.docker.com/compose/
* Use old fig inside a docker container
  * https://github.com/ianblenke/docker-fig-docker

Regards
Peter
