Where the tutorial is
---------------------
http://www.vogella.com/tutorials/REST/article.html#first

Run it
------
Note: These endpoints do not make database calls

Note: These endpoints return Plain Text

Use this url to test (it is different than what the tutorial calls for):
http://localhost:8080/VogelREST/rest/hello

-  'VogelREST' is defined in the web.xml as <display-name>
-  'rest' is defined in the web.xml as <url-pattern>
-  'hello' is defined in the class and the @Path

http://localhost:8080/VogelREST/rest/hello/500
 - 500 can be any 'double' value

http://localhost:8080/VogelREST/rest/hello/arg?idx=250
 - 250 can be any 'double' value

Note: This endpoint returns XML

http://localhost:8080/VogelREST/rest/hello/xml

Note: This endpoint returns HTML

http://localhost:8080/VogelREST/rest/hello/html

Note: Remove the @Path directive from the code and the 'html' from the end of the url
Make the call with a browser and you will get the HTML response anyway

Updating the Database using REST endpoints
I use Postman to test these calls

Get the values at a row at an index
http://localhost:8080/VogelREST/rest/hello/arg?idx=14

Get a list of all rows, using XML
http://localhost:8080/VogelREST/rest/hello/list

Modify a row at an index
http://localhost:8080/VogelREST/rest/hello/arg?name=X Hadron&type=Urner&idx=2

Delete a row at an index
http://localhost:8080/VogelREST/rest/hello/arg?idx=3

Create a new row in the database
http://localhost:8080/VogelREST/rest/hello/arg?name=J Taylor&type=Dragon



What it is
----------
Basically, I took the REST tutorial from Vogella and combined it with a tutorial for hibernate from DZone
The result is using RESTful CRUD to access a MySQL database

Note: This means you must have the MySQL database with the correct schema running in order for this tutorial to work


Concepts
--------
REST with JAX-RS and Jersey
MySQL and Hibernate
Use Maven to install libraries such as Jersey and JDBC


