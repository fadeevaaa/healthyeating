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
*1. Клонирование репозитория:*
git clone https://github.com/fadeevaaa/healthyeating.git
- *Установка зависимостей (используйте Maven для сборки проекта):*
mvn clean install
- *Запуск приложения. Запустите приложение с помощью команды Maven:*
mvn spring-boot:run
- *Настройка переменных окружения в файле application.yml для конфигурации приложения:*
  
  ```
  server:
  
    port: 8081
  
  spring:

    datasource:
  
      url: jdbc:postgresql://localhost:5432/your_database_name
    
      username: your_username
    
      password: your_password
    
    jpa:
  
      hibernate:
    
        ddl-auto: update
  ```

###  Описание API
- Эндпоинт: /users
- Метод: POST
- Добавление нового пользователя.
```
{
    "name" : "Ivan",
    "email" : "vanya@gmail.com",
    "age" : "25",
    "weight" : "72",
    "height" : "175",
    "purpose" : "MAINTENANCE"
}
```

- Эндпоинт: /dishes
- Метод: POST
- Добавление нового блюда.
```
{
    "name" : "яблоко",
    "numberOfCaloriesPerBatch" : "100",
    "nutrient" : {
        "proteins" : "0.4", 
        "fats" : "0.4", 
        "carbohydrates" : "9.8"
    }
}
```

- Эндпоинт: /meals
- Метод: POST
- Добавление приема пищи для пользователя.
```
{
    "name" : "перекус",
    "user" : {
        "id" : "1"
    },
    "dishes" : [
        {"id" : "1"}
    ]
}
```

- Эндпоинт: /reports/{id}
- Метод: GET
- Отчет за день с суммой всех калорий и приемов пищи.
```
http://localhost:8081/reports/1?date=2025-03-24
```

- Эндпоинт: /reports/{id}/comparison
- Метод: GET
- Проверка, уложился ли пользователь в свою дневную норму калорий.
```
http://localhost:8081/reports/1/comparison?date=2025-03-24
```

- Эндпоинт: /reports/{id}/history
- Метод: GET
- История питания по дням.
```
http://localhost:8081/reports/1/history
```
