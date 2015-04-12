# Flexible Docker Apache Tomcat 8 container

![logo.png](https://raw.githubusercontent.com/infrabricks/infrabricks-line/master/webserver/tomcat/tomcat8/logo.png)

* Based on official trustet docker inc openjdk java jre-8
* Install Apache Tomcat 8 Basic distribution
* Add jolokia jmx rest api to the distribution
* Tuned server.xml and logging.properties for production
* Access Log to stdout
* Drop all webapps and unused files
* Show some docker tricks
  * My webapp and tomcat docker composition pattern
  * JDK and Tomcat as docker data volume
  * Easy overwrite or extend Tomcat configs, webapps or libs

![Tomcat Layer](https://raw.githubusercontent.com/infrabricks/infrabricks-line/master/webserver/tomcat/tomcat8/images/infrabricks-tomcat8.png)

![Tomcat Layer](https://raw.githubusercontent.com/infrabricks/infrabricks-line/master/webserver/tomcat/tomcat8/images/infrabricks-tomcat8-volume.png)

[More Info](https://github.com/infrabricks/infrabricks-line/tree/master/webserver/tomcat/tomcat8)

This implements some ideas from my german [tomcat blog post](http://www.infrabricks.de/blog/2014/12/19/docker-microservice-basis-mit-apache-tomcat-implementieren/).

## User Feedback

See my [infrabricks blog](http://www.infrabricks.de) to more informations.

Contact me: Peter <peter.rossbach@bee42.com>

Follow me [on Twitter](https://twitter.com/PRossbach)

## Source code

* [infrabricks-line tomcat8](https://github.com/infrabricks/infrabricks-line/tree/master/webserver/tomcat/tomcat8)

## Contact

For bugs, questions, comments, corrections, suggestions, etc., open an issue in
 [infrabricks/infrabricks-line](https://github.com/infrabricks/infrabricks-line/issues) with a title starting with `[tomcat8] `.

Or just [click here](https://github.com/infrabricks/infrabricks-line/issues/new?title=%5Btomcat8%5D%20) to create a new issue.

## License

Copyright (c) 2014-2015 [bee42 solutions Gmbh- Peter Rossbach](http://www.bee42.com)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

More details read the [project license file](https://raw.githubusercontent.com/infrabricks/infrabricks-line/master/webserver/tomcat/tomcat8/LICENSE)!

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

### Contributing

You are invited to contribute new features, fixes, or updates, large or small; we are always thrilled to receive pull requests, and do our best to process them as fast as we can.

Before you start to code, we recommend discussing your plans through a GitHub issue, especially for more ambitious contributions. This gives other contributors a chance to point you in the right direction, give you feedback on your design, and help you find out if someone else is working on the same thing.

## Power by Apache Tomcat

![Power by Apache Tomcat ](https://raw.githubusercontent.com/infrabricks/infrabricks-line/master/webserver/tomcat/tomcat8/images/tomcat-power.gif)

## References

* [Apache Tomcat](https://tomcat.apache.org)
* [Docker](https://docker.com)
* [Infrabricks Blog](http://www.infrabricks.de)
* [Tomcat Docker hub library images](https://registry.hub.docker.com/u/library/tomcat/)
* [jolokia](http://www.jolokia.org/)
* [Docker maven plugin](https://github.com/rhuss/docker-maven-plugin)
