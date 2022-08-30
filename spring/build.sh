#!/bin/sh

mvn clean package -Dmaven.test.skip=true;
cp ./target/spring*.jar ./.docker/alpine/spring.jar
docker-compose up ;
