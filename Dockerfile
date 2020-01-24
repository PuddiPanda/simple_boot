FROM openjdk:8-jre

COPY simple_boot-0.0.1-SNAPSHOT myapp.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/.urandom", "-jar", "/myapp.jar"]