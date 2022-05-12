# Microservice User

### Endpoints:

#### Add User

````
POST /api/users/add HTTP/1.1
Host: localhost:3333


{
    "name": "demo",
	"email":"demo@gmail.com,
    "password":"demo",
}
````

#### Get Users

```
GET /api/users/getall HTTP/1.1
Host: localhost:3333

```

#### Get User By Email

```
GET /api/users/findbyemail HTTP/1.1
Host: localhost:3333

paramater : email

```
