# Healthy eating

## Сервис для отслеживания дневной нормы калорий пользователя и учета съеденных блюд.

### Описание
В проекте реализованы:
- добавление пользователей с параметрами, по которым автоматически рассчитывается дневная норма калорий (для упрощения реализации используется формула Харриса-Бенедикта для мужчин);
- добавление блюд с параметрами;
- добавление пользователем приема пищи со списком блюд;
- отчеты (эндпоинты, без формирования документа):
  - отчет за день с суммой всех калорий и приемов пищи;
  - проверка, уложился ли пользователь в свою дневную норму калорий;
  - история питания по дням.

### Используемые технологии 
- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven

### Установка и запуск
- *Клонирование репозитория:*
git clone https://github.com/fadeevaaa/healthyeating.git
- *Установка зависимостей (используйте Maven для сборки проекта):*
mvn clean install
- *Запуск приложения. Запустите приложение с помощью команды Maven:*
mvn spring-boot:run
- *Настройка переменных окружения в файле application.yml для конфигурации приложения:*
  
  ```server:
  
    port: 8081
  
  spring:

    datasource:
  
      url: jdbc:postgresql://localhost:5432/healthy_eating
    
      username: postgres
    
      password: fadeevaaa
    
    jpa:
  
      hibernate:
    
        ddl-auto: update```

  spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
  
  spring.datasource.username=your_username
  
  spring.datasource.password=your_password
  
  spring.jpa.hibernate.ddl-auto=update
