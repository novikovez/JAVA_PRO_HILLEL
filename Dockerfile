# Стадия сборки
FROM openjdk:21-jdk-slim AS build

# Устанавливаем Maven
RUN apt-get update && apt-get install -y maven

# Устанавливаем рабочую директорию, где находится pom.xml
WORKDIR /app

# Копируем pom.xml и исходные файлы (src)
COPY ./pom.xml .
COPY ./src ./src

# Собираем проект с помощью Maven
RUN mvn clean package

# Стадия Tomcat
FROM tomcat:11.0.2-jdk21

# Копируем .war файл из стадии сборки в Tomcat
COPY --from=build /app/target/api.war /usr/local/tomcat/webapps/

# Указываем порт, на котором будет работать Tomcat
EXPOSE 8080

# Запуск Tomcat
CMD ["catalina.sh", "run"]
