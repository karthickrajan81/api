### com.main.api
This Api is build using Java and Spring boot.

### Dependencies
## Frameworks:org.springframework.boot
## Persistence Layer: org.hsqldb
## Utilities:com.google.code.gson

### Compile
maven.apache.org
## [Compile]
mvn compile -f ".\api\pom.xml"


### Package
maven.apache.org
## [Packagae] 
mvn package -f ".\api\pom.xml"

### Unit Test
Junit
## [RunTest] 
mvn test -f ".\api\pom.xml"

### API URL
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
        "firstName": "Stephennnnnnnnnnn",
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
