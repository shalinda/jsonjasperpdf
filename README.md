## JSON to PDF
Objective of this project is to create REST micro service that converts a json respresentation of data and return a pretty printable report build using jasper reports. Jasper already has a server but it limits your capability to use it as a back office micro service in its opensource version.

Alternatively you do an embeded reporting server in you application but that limits you to being java and limits scalability.

This project is a light weight java spring boot application that runs as a micro service and renders you json into a pretty pdf report and responds.

The build is containerized and with support of docker should be able build to run it with minimal effort.

## Sample call
`curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d '[{"name":"shalinda", "age": 10, "salary": "1000.0","food":"rice", "child":{"name":"duwi"}},{"name":"dilshan", "age":21, "salary": 2300, "food":"rice", "child":{"name":"jani"}}]' http://localhost:8080/report?name=employee >>employee.pdf`

Jasper file located at `report/emp/`

Java model located at `src/main/com/jsonpdf/model/emp`

## Jasper subreport
`curl -H "Accept: application/json"  -H "Content-type: application/json" -X POST "http://jsonpdf:8080/report?product=emp&name=employee" -d '[{"name":"shalinda", "age": 10, "salary": 1000.0,"food":"rice", "childs":[{"name":"duwi", "age":10}]},{"name":"dilshan", "age":21, "salary": 2300, "food":"rice", "childs":[{"name":"jani", "age":20}]}]'>employee.pdf`

Jasper file located at `report/emp1/`

Java model located at `src/main/com/jsonpdf/model/emp1`

## Jasper compile
Jasper report designed iReport 5.6.0
Compile the report to target/report folder for local running
Compile the report to report folder for Docker

# Jasper development
Using iReport develop the report

Match the fields to the Java Model object and passed json to the service 

## Model object
Create Model object in model package in java code that matches the passed json

## See also
 - https://stackoverflow.com/questions/10722587/how-do-i-convert-a-json-array-into-a-java-list-im-using-svenson
 
 - https://dzone.com/articles/spring-boot-2-restful-api-documentation-with-swagg

## Build Docker
`docker build . -t jsonpdf`

## Run Docker
`docker run  docker $HOME/.m2:/root/.m2 -p 8080:8080 jsonpdf`

## Access Swagger

http://localhost:8080/swagger-ui.html

## Other links
 - http://www.jsonschema2pojo.org/
 
 - https://github.com/jasperapp/jasper

## Future
Dynamical capability to load jrxml and compile internally

Avoid need for java pojo object
