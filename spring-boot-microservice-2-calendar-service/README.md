# Microservice Calendar

### Endpoints:

#### Add Event

````
POST /api/calendar HTTP/1.1
Host: localhost:4444


{
    "userId": "4",
	"startDate":"22-02-2022",
    "endDate":"22-02-2022",
}
````

#### Delete Event

```
DELETE /api/calendar/{eventId} HTTP/1.1
Host: localhost:4444

```

#### Get All Events Of USer

```
GET /api/calendar/{userId} HTTP/1.1
Host: localhost:4444


```
