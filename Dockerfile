FROM maven:3.6-jdk-8-slim
MAINTAINER Orlando
WORKDIR /project
COPY src /project/src
COPY pom.xml /project
CMD ["mvn","clean","verify"]
