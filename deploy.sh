# /bin/bash

git pull
mvn package -Dmaven.test.skip=true
mkdir -p /data/jar
cp target/blog-0.0.1-SNAPSHOT.jar /data/jar/blog-0.0.1-SNAPSHOT.jar
chmod +x /data/jar/blog-0.0.1-SNAPSHOT.jar
ln -s /data/jar/blog-0.0.1-SNAPSHOT.jar /etc/init.d/blogservice
service blogservice restart