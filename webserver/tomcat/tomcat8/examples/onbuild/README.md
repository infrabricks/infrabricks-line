# Simple tomcat webapp onbuild example

## create project

```
mkdir bin conf lib webapps
touch bin/.created conf/.created lib/.created
cp <your app>.war webapps
echo "FORM infrabricks/tomcat:8-onbuild" >Dockerfile
docker build -t <your app image> .
docker run -d -p 8080 <your app image>
```

## build from  maven webapp package 

```
cat >Dockerfile <<EOF
FROM infrabricks/tomcat:8
ADD target/*.war \${CATALINA_HOME}/webapps/
EOF
docker build -t <your app image> .
```

