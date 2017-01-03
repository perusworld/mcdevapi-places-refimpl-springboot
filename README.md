# Maven Spring Boot Web/REST App Base #
Maven/Spring Boot Web/REST app base code

## Requirements ##
1. JDK 1.8+
1. Maven

## Run with Remote Debug ##
	set MAVEN_OPTS=-Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8000
	mvn -Dserver.port=3000 spring-boot:run

## Package Executable jar/war ##
	mvn clean package

## Running the packaged jar ##
	java -jar target\spring-boot-base-0.1.war

## Test App ##
Open browser and goto [http://localhost:3000](http://localhost:3000)

## Test REST APIs -cURL ##
### GET ###
```bash
curl -X GET -H "Accept: application/json" -H "Cache-Control: no-cache" "http://localhost:3000/api/helloREST/peru"
```
### POST ###
```bash
curl -X POST -H "Content-Type: application/json" -H "Cache-Control: no-cache" -d '{
  "msg": "peru"
}' "http://localhost:3000/api/helloREST"
```
