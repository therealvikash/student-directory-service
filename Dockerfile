FROM gradle as build
WORKDIR /app
COPY . /app/
RUN ./gradlew clean build

FROM openjdk
WORKDIR /app
COPY --from=build /app/build/libs/student-directory-1.0.0-boot.jar /app/
EXPOSE 9090
CMD [ "java", "-jar", "student-directory-1.0.0-boot.jar" ]