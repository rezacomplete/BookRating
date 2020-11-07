# BookRating
book rating microservice

This code is written with Java 8 and spring boot. <br>
Please run: <br/>
<b>docker build -t book-rating .</b> <br/>
<b>docker run -p 8082:8082 -t book-rating</b> <br/>
You can retrieve book information by calling the Rest API like below:<br>
<b>http://localhost:8082/rating/user1</b> <br>
You can access the swagger from the postman using:<br>
<b>http://localhost:8082/v2/api-docs </b> <br>
You can access the swagger UI from the browser using:<br>
<b>http://localhost:8082/swagger-ui.html </b> <br>