# iBooksRest
## Rest service

### URIs
Сущность User:
- GET /users/ - получить всех пользователей
- GET /users/{id}/ - получить пользователя по ID
- POST /users/ - создать нового пользователя ({"login":"SomeLogin", "password":"SomePassword", "email":"SomeEmail@email.com"})
- . . .

Сущность Author:
- GET /authors/ - получить список всех авторов
- GET /authors/{id}/ - получить автора по его ID
- GET /authors/{id}/books/ - получить список книг автора
- . . .

Сущность Book:
- GET /books/ - получить список всех книг
- GET /books/{id}/ - получить книгу по её ID
- . . .
