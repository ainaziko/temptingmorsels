FROM openjdk:16
ADD target/tempting-morsels.jar tempting-morsels.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "/tempting-morsels.jar"]