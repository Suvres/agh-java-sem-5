#FROM alpine
#WORKDIR app
#COPY spring.jar .
#RUN /bin/sh -c "apk add --no-cache openjdk17"
##CMD /bin/sh -c "java -jar ./jar_file/spring.jar"

FROM openjdk:17-jdk-alpine
COPY spring.jar spring.jar
ENTRYPOINT ["java","-jar","/spring.jar"]
