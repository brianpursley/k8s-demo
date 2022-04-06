FROM maven:3-openjdk-11 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests=true

FROM openjdk:11
COPY --from=build /usr/src/app/target/api.jar /usr/app/api.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/app/api.jar"]