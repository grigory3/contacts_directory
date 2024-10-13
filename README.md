Стек технологий: Java 19, Spring Boot, Web, Data, Hibernate, Maven, PostgreSQL, Postman, GIT.

Описание эндпоинтов:

1. POST-запрос, URL .../clients - добавление нового клиента.

Для реализации метода необходимо отправить JSON запрос с именем клиента.

Пример запроса:

{

    "name": "Nikola Tesla"

}

2. POST-запрос, URL .../clients/{clientId}/contacts - добавление новой контактной информации 
для клиента c данным id.

Для реализации метода необходимо отправить JSON запрос с типом контактной информации (EMAIL, PHONE)
и заполнить само значение.

Пример запроса:

{

    "type": "EMAIL",
    "value": "nikola1856@google.com"

}

3. GET-запрос, URL .../clients - получение списка клиентов.

Пример ответа:

{

     "id": 1,
     "name": "Nikola Tesla"

}

4. GET-запрос, URL .../clients/{clientId} - получение информации по определенному клиенту.


5. GET-запрос, URL .../clients/{clientId}/contacts - получение контактной информации 
по определенному клиенту.

Пример ответа: 

{

        "id": 1,
        "type": "EMAIL",
        "value": "nikola1856@google.com"

}

6. GET-запрос, URL .../clients/{clientId}/contacts/type/{type} - получение контактной информации 
по определенному клиенту заданного типа.