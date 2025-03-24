# Технологии: 
Java
Spring Boot
Spring Data JPA
PostgreSQL
Maven

Установка и запуск:

Клонирование репозитория:
git clone https://github.com/ваш_репозиторий.git

Установка зависимостей. Используйте Maven для сборки проекта:
mvn clean install

Запуск приложения. Запустите приложение с помощью команды Maven:
mvn spring-boot:run

Настройка переменных окружения в файле application.yml для конфигурации приложения:
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
