FROM maven:3-jdk-8-alpine as base
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
ONBUILD ADD . /usr/src/app
RUN mkdir -p ./target/classes/report
COPY report/*.jasper ./target/classes/report
COPY pom.xml .
RUN mvn dependency:go-offline
RUN apk --update add fontconfig ttf-dejavu
ONBUILD RUN mvn install

FROM base
CMD mvn spring-boot:run
EXPOSE 8080