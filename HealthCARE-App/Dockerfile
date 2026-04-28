FROM eclipse-temurin:21-jre
WORKDIR /app
COPY target/HealthCARE-App-0.0.1-SNAPSHOT.jar   app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]





#  .\mvnw.cmd clean package
# docker build -t healthcare-app .
# docker images

# docker network create healthcare-network
#  docker run -d  --name mysql-container --network healthcare-network  -e MYSQL_ROOT_PASSWORD=Arkkass -e MYSQL_DATABASE=medical_db -p 3307:3306  mysql:8

# docker run -d --name healthcare-app --network healthcare-network -p 8080:8080 -e SPRING_DATASOURCE_URL=jdbc:mysql://mysql-container:3306/medical_db -e SPRING_DATASOURCE_USERNAME=root  -e SPRING_DATASOURCE_PASSWORD=Arkkass healthcare-app