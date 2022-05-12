# Microservice Gateway

### Endpoints:

#### Add User

````
POST /gateway/user/add HTTP/1.1
Host: localhost:5555


{
    "name": "demo",
	"email":"demo@gmail.com,
    "password":"demo",
}
````

#### Get Users

```
GET /gateway/user/getall HTTP/1.1
Host: localhost:5555

```

#### Get User By Email

```
GET /gateway/user/findbyemail HTTP/1.1
Host: localhost:5555

paramater : email

```


#### Add Event

````
POST /gateway/calendar HTTP/1.1
Host: localhost:5555


{
    "userId": "4",
	"startDate":"22-02-2022",
    "endDate":"22-02-2022",
}
````

#### Delete Event

```
DELETE /gateway/calendar/{eventId} HTTP/1.1
Host: localhost:5555

```

#### Get All Events Of USer

```
GET /gateway/calendar/{userId} HTTP/1.1
Host: localhost:5555


```
