FROM openjdk:11

MAINTAINER Vitor Lima <vjsl@cin.ufpe.br>

EXPOSE 8080

COPY target/vanhackchallenge-0.0.1-SNAPSHOT.jar /app.jar

ENTRYPOINT ["java","-jar","/app.jar"]