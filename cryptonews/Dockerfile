#
# First stage
#

FROM maven:3.8.3-openjdk-17 AS build

COPY src /home/app/src
COPY pom.xml /home/app

ARG REDISHOST
ARG REDISPORT
ARG REDISUSER
ARG REDISPASSWORD
ARG CRYPTO_API_URL
ARG CRYPTO_API_KEY

RUN mvn -f /home/app/pom.xml clean package

#
# second stage
#

FROM openjdk:17-oracle

ARG REDISHOST
ARG REDISPORT
ARG REDISUSER
ARG REDISPASSWORD
ARG CRYPTO_API_URL
ARG CRYPTO_API_KEY

COPY --from=build /home/app/target/cryptonews-0.0.1-SNAPSHOT.jar /usr/local/lib/cryptonews.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/cryptonews.jar"]