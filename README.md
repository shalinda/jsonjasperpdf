## Sample call
`curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d '[{"name":"shalinda", "age": 10, "salary": "1000.0","food":"rice", "child":{"name":"duwi"}},{"name":"dilshan", "age":21, "salary": 2300, "food":"rice", "child":{"name":"jani"}}]' http://localhost:8080/report?name=employee >>employee.pdf`

## Jasper compile
Jasper report designed iReport 5.6.0
Compile the report to target/report folder for local running
Compile the report to report folder for Docker

# Jasper development
Using iReport develop the report
match the fields to the Java Model object and passed json to the service 

## Model object
Create Model object in model package that matches the passed json

## See also
https://stackoverflow.com/questions/10722587/how-do-i-convert-a-json-array-into-a-java-list-im-using-svenson

## Build Docker
`docker build . -t jsonpdf`

## Run Docker
`docker run  docker $HOME/.m2:/root/.m2 -p 8080:8080 jsonpdf`

## Other links
http://www.jsonschema2pojo.org/

