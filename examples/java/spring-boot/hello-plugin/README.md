# spring boot hello world

## build

```
mvn clean package docker:build
```

## usage

```
docker-compose up -d
docker-compose port
curl $(boot2docker ip):49158/hello
```

## References

* http://plainoldobjects.com/2014/11/16/deploying-spring-boot-based-microservices-with-docker/
* https://spring.io/guides/gs/spring-boot/
