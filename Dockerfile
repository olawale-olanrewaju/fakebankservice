FROM amazoncorretto:17
WORKDIR /construction
COPY *.gradle gradle.* gradlew /construction/
COPY gradle/ /construction/gradle/
RUN ./gradlew wrapper
COPY . .
RUN ./gradlew clean bootJar && cp build/libs/*.jar app.jar && jar -xf app.jar
ENTRYPOINT ["java","-jar","app.jar"]
