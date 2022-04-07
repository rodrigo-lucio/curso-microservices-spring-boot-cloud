FROM openjdk:16
ARG JAR_FILE=naming-sever/target/*.jar
COPY ${JAR_FILE} app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.edg=file:/dev/./urandom", "-jar","/app.jar"]