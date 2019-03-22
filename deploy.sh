# /bin/bash

git pull
mvn package -Dmaven.test.skip=true
mkdir -p /data/jar
cp target/blog.jar /data/jar/blog.jar
chmod +x /data/jar/blog.jar
ln -s /data/jar/blog.jar /etc/init.d/blogservice
service blogservice restart