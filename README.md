###Task Input
Serge is a local travel guide who provides private hiking tours of the mountains.
Hikers would contact him over the phone to go on three different hike trails: A, B and
C. He would enter each booking request in a spreadsheet along with the hikers'
information.

Trails:

    Name: A
    Start: 08:00
    End: 09:00
    Age limit (inclusive): 5-100
    Price: 35.00 EUR/person

    Name: B
    Start: 12:00
    End: 14:00
    Age limit (inclusive): 11-50
    Price: 70.90 EUR/person

    Name: C
    Start: 15:00
    End: 18:00
    Age limit (inclusive): 18-40
    Price: 95.50 EUR/person

Conditions:
 - A hiker must be within the specified age limit of the chosen hike trail
 - A hiker can include more than one hiker in his/her booking; provided that they are within the age limit of the chosen hiking trail
 - Each booking should be for one hiking trail only

Task is to implement a solution that would allow:
 - Hikers to create, cancel and view their bookings
 - Serge to view hike bookings for a specific day
 
Assume the following:
 - here is no restrictions on the number of bookings that can be made daily
 - The dates and times of hike bookings can overlap each other as many times as possible


###Notes
# 
DISCLAIMER:
I knew I run out of time heavily if I would add the tests for all the functionality. 
If I had 3+ more hours I would add some of them with poor coverage. But as I was adding more and more entities, 
I had a time just to finish the core functionality. 
If you give me more time I'd make it all done.
==================================================

1). The solution runs out ot the box and contains all needed dependencies.
The database, used for this solution, is a runtime H2 instance; it should be allowed to create 
local db file in the home directory:

`~/toursdb`

It is created automatically without any configuration.

2). The project runs as usual Spring Boot project, with command:

`mvn clean spring-boot:run`

3). After the project starts, main API page can be invoked by the link:
`http://localhost:8080/swagger-ui/index.html` (preferred way),

or with curl commands, for example:
`curl -X GET "http://localhost:8080/trails" -H "accept: application/json"`

**It is highly recommended to use the Swagger documentation page, as it contains graphical UI to invoke REST requests really easy.**

NOTE: Please use `http://localhost:8080/swagger-ui/index.html`.

For further information, the curl commands are below:
- Get trails (dictionary)
`curl -X GET "http://localhost:8080/trails" -H "accept: application/json"`
- Get trails by name
`curl -X GET "http://localhost:8080/trails/Mordor" -H "accept: application/json"`
- Create booking
`curl -X POST "http://localhost:8080/bookings" -H "accept: application/json" -H "Content-Type: application/json" -d "{ \"hikers\": [ { \"age\": 20, \"firstName\": \"A\", \"lastName\": \"B\" } ], \"trailName\": \"Mordor\"}"`
- View booking
`curl -X GET "http://localhost:8080/bookings/7" -H "accept: */*"`
- View booking by date
`curl -X GET "http://localhost:8080/bookings?date=2020-02-20" -H "accept: */*"`
- Cancel booking
`curl -X DELETE "http://localhost:8080/bookings/7" -H "accept: */*"`
