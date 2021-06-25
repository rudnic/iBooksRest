# iBooksRest
## Rest service

### Предметная область:
База данных, заточенная под мобильное приложение, представляющее из себя социальную сеть для книжных любителей. Сравнительную аналогию можно провести с кинопоиском, только вместо фильмов пользователи могут искать, оценивать, писать отзывы о книгах. Как и в любой социальной сети должны присутствовать возможности написания постов в своём профиле, добавлять друзей и переписываться с ними.

### URIs
Сущность User:
- GET /users/ - получить всех пользователей
- GET /users/{id}/ - получить пользователя по ID
- POST /users/ - создать нового пользователя ({"login":"SomeLogin", "password":"SomePassword", "email":"SomeEmail@email.com"})
- DELETE /users/{id}/ - удалить пользователя по ID
- PUT /users/{id}/ - обновить пользователя по его ID ({"login":"SomeLogin", "password":"SomePassword", "email":"SomeEmail@email.com"})

Сущность Author:
- GET /authors/ - получить список всех авторов
- GET /authors/{id}/ - получить автора по его ID
- GET /authors/{id}/books/ - получить список книг автора
- POST /authors/ - создать нового автора ({"firstname":"Ivan", "middlename":"Ivanovich", "lastname":"Ivanov"})
- DELETE /authors/{id}/ - удалить автора по ID (если запретят как экстремиста xd)

Сущность Book:
- GET /books/ - получить список всех книг
- GET /books/{id}/ - получить книгу по её ID
- POST /books/ - добавить новую книгу ( {"name": "Герой нашего времени", "category": "Роман", "authorsId": [1]"} )
- POST /books/{id}/comments/ - добавить комментарий к книге ( {"commentText": "This is comment", "user": {"id": 1}"} )
- GET /books/{id}/comments/ - посмотреть комментарии
- DELETE /books/{id}/ - удалить книгу по id


Спроектированная база данных:


![База данных](https://i.ibb.co/cyjMTzX/diagram.png)
