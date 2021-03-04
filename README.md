###### - Set Using @PostConstruct

````java
import javax.annotation.PostConstruct;

@SpringBootApplication
public class SearchingApplication {

    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone(ZoneOffset.UTC));
    }

    public static void main(String[] args) {
        SpringApplication.run(SearchingApplication.class, args);
    }
}
````

###### - Set In application.yml

````yaml
spring:
  jackson:
    time-zone: GMT+7
````

###### - Example Request

````shell
### Add Book
POST {{baseUrl}}
Content-Type: application/json
Accept: application/json

{
 "bookName": "Golang"
}

### GET ALL
GET {{baseUrl}}

### FILTER BY CreatedDate
GET {{baseUrl}}/filter?from=2021-03-04 10:50:44&to=2021-03-04 10:50:45
````