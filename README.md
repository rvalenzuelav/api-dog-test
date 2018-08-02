# api-dog-test
api-dog-test

## Installing
The project was built under maven, it can be deployed by first installing:

`mvn clean install`

and then running:

`mvn spring-boot:run`

## Querying the REST service
REST service need to be invoke by the URL **localhost:8087/retrieve-breed-data?breed-name={breedName}**
where the curly braces params is the breedName of the dog to be queried

## Changing the tomcat listening port
Application listening port could be change in the application.properties key placed within the project in the path **/src/main/resources/application.properties**. Default port is 8087.

`server.port=8087`
