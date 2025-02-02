# Реестр техники 

### Порядок запуска v1.0

1. В файле application.properties настроить подключение к БД
2. Проверить отсутствие ошибок в файле */resources/data.sql, если не видит таблицы, настроить подключение в среде разработки
3. собрать и запустить, должны созда́ться пустые таблицы
4. В файле application.properties раскомментировать строку #spring.sql.init.mode=always и изменить параметр spring.jpa.hibernate.ddl-auto=create на update
5. собрать и запустить, должны заполниться таблицы tv и tvmodel
6. для избежания ошибок в будущем, закомментировать строку #spring.sql.init.mode=always
7. Swagger доступен по адресу http://localhost:8080/swagger-ui/index.html
