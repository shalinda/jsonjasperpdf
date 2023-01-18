FROM maven:3-jdk-8-alpine as base
# RUN apk add --no-cache curl tar bash
# ARG MAVEN_VERSION=3.3.9
# ARG USER_HOME_DIR="/root"
# RUN mkdir -p /usr/share/maven && \
# curl -fsSL http://apache.osuosl.org/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz | tar -xzC /usr/share/maven --strip-components=1 && ln -s /usr/share/maven/bin/mvn 
# # /usr/bin/mvn
# ENV MAVEN_HOME /usr/share/maven
# ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"
# # speed up Maven JVM a bit
# ENV MAVEN_OPTS="-XX:+TieredCompilation -XX:TieredStopAtLevel=1"
# ENTRYPOINT ["/usr/bin/mvn"]

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
ONBUILD ADD . /usr/src/app
RUN mkdir -p ./target/classes/report
# COPY report/*.jasper ./target/classes/report/
COPY report/* ./report/
COPY pom.xml .
RUN mvn dependency:go-offline
RUN apk --update add fontconfig ttf-dejavu
ONBUILD RUN mvn install

FROM base
CMD mvn spring-boot:run
EXPOSE 8080
