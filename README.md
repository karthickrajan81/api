### com.main.api
This Api is built using Java and Spring boot to give introduction to Micoroservices with simple DAO and DTO implementations

### Dependencies
## Frameworks:org.springframework.boot
## Data Repository: org.springframework.boot\spring-boot-starter-data-jpa
## Persistence Layer: org.hsqldb
## Utilities:com.google.code.gson
## Build and Package:maven.apache.org
## Unit test: Junit

## [Compile]
mvn compile -f ".\api\pom.xml"

## [Packagae] 
mvn package -f ".\api\pom.xml"

## [RunTest] 
mvn test -f ".\api\pom.xml"

### API URLs
## [Welcome]
curl --location --request GET 'http://localhost:8080/'

### Fibonacci Api cURL commands
## [GetFibonacciSeries]
curl --location --request GET 'http://localhost:8080/fib?input=55'
## [GetFibonacciSum]
curl --location --request GET 'http://localhost:8080/fibsum?input=92'

### Person API cURL commands
## [GetAllPerson]
curl --location --request GET 'http://localhost:8080/person/all'
## [GetListOfPersonByName]
curl --location --request GET 'http://localhost:8080/person/name?firstName=Steve&lastName=Jobs
## [GetPersonById]
curl --location --request GET 'http://localhost:8080/person/1'
## [AddPerson]
curl --location --request POST 'http://localhost:8080/person/add' \
--header 'Content-Type: application/json' \
--data-raw '    {
        "firstName": "Steve",
        "lastName" : "Jobs"
    }'
## [UpdatePerson]
curl --location --request PUT 'http://localhost:8080/person/update' \
--header 'Content-Type: application/json' \
--data-raw '    {
        "id":"4",
        "firstName": "Stephen",
        "lastName" : "Hawking"
    }'
## [DeletePerson] 
curl --location --request DELETE 'http://localhost:8080/person/4'

### Post API cURL commands
## [GetPostbyId]
curl --location --request GET 'http://localhost:8080/post/3'
## [GetPostbyUserId]
curl --location --request GET 'http://localhost:8080/post?userId=2'
## [Search]
curl --location --request GET 'http://localhost:8080/post/search?title=commodi&body=commodi'
