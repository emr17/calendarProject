# Microservice Gateway

Microservices run at localhost:3333,localhost:4444,localhost:5555.
Interface run at localhost:3000.


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
gAAAAABiaaMKrHsm5PzcLu3qlrkZYSEs_KR3xhLrHMh8DEKwdjeJZ71YEUvRP1q0O1YRSLmeOVtTa0kgyart-2FaJRZcdpQVlCiSiSSBs7Sz6_hhfqpsN1oqjYvZN3iaF4SI1TosFky5BDhekjKQ78f1qgew5FSS7ZXe6KTKBh1EImKdUsXXEUCRl2DOyCfSUvAdTnXluxfz8gAPi2n5fNc-vvMejEsSfUK9NFDaDok11cQND7iXkzY=



Eksikler:
Docker konfigürasyonu yok.
Arayüzde etkinlik silme özelliği yok.
Arayüzde eski etkinlikler gözükmüyor.
Redis kullanılmadı.