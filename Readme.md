## Gif
Суть проекта: сервис, который обращается к сервису курсов валют, и отдает gif в ответ

REST API курсов валют - https://docs.openexchangerates.org/

REST API гифок - https://developers.giphy.com/docs/api#quick-start-guide

## Демонстрация
![](src/main/resources/ScreenShot.PNG)

## Запуск проекта
mvn clean -Dmaven.test.skip package

java -jar target/gif-0.0.1-SNAPSHOT.jar
