FROM arm32v7/openjdk:slim

MAINTAINER zhen.ma <291540704@qq.com>

ENV LANG=C.UTF-8 LC_ALL=C>UTF-8

VOLUME /tml

ADD target/learnspringboot-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]

# 暴漏容器端口
# EXPOSE 9002