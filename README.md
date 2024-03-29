## Bike rental

Bike rental app is the first complex project in my portfolio.   
It currently provides basic functionalities, mostly CRUD for User, Bikes and Reservation management. 
Future plans for application development can be found under [TODO section](#to-do).

### Used technologies
- Java 17
- Spring Boot 3.0.4
- Hibernate 8.0.0
- PostgreSQL
- Lombok
- Swagger (from Springdoc-openapi 2.0.2)
- Maven 3.8.7
### Prerequisites 

docker and docker-compose

### How to run?
`docker-compose up` or `./mvnw spring-boot:run` (provided you have a locally running postgres db)

### How to use? 
1. Go to http://localhost:8080/swagger-ui.html

### Database relationship diagram
![db-diagram.png](db-diagram.png)

### To Do: 
- [ ] Create DB schema
- [ ] Extend bikes with photo gallery
- [ ] Spring Security
- [ ] Tests
- [ ] Front-end app
- [ ] Soft delete of DB records
- [ ] Analysis module for admin
