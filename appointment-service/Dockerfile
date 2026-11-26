# Étape 1 : compilation avec le wrapper Gradle
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
COPY . .
# Corrige les fins de ligne Windows et rend gradlew exécutable
RUN sed -i 's/\r$//' gradlew && chmod +x gradlew
RUN ./gradlew bootJar --no-daemon

# Étape 2 : image finale légère avec uniquement le JRE
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]