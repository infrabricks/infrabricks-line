# create a qrcode

## build and install

```
$ mvn clean packages
$ docker-compose build
```

## Run

```
$ $(boot2docker shellinit)
$ docker-compose up -d
$ docker-compose ip
$ PORT=$(docker-compose port tomcat 8080 | awk 'BEGIN { FS = ":" } ; { print $2 ; }')
$ curl -Ls $(boot2docker ip):$PORT/qrcode/qr?code=http://www.bee42.com >qr-bee42.png
open qr-bee42.com
```

## dev

```
./dev.sh
mvn clean package tomcat7:deploy -Dtomcat.host=$(b2d ip) -Dmaven.tomcat.update=true
curl -Ls $(boot2docker ip):8580/qrcode/qr?code=http://www.bee42.com >qr-bee42.png
open $(boot2docker ip):8580/qrcode/vcard.html
```

## Links

* Idea comes from `
http://viralpatel.net/blogs/create-qr-codes-java-servlet-qr-code-java/`
* https://github.com/kenglxn/QRGen
* https://github.com/zxing/zxing
* http://zxing.appspot.com/generator

## License

http://www.apache.org/licenses/LICENSE-2.0.html

Regards
Peter
