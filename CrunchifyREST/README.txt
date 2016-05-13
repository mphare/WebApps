
Crunchify REST Example
http://crunchify.com/how-to-build-restful-service-with-java-using-jax-rs-and-jersey/


Celsius to Fahrenheit

  Use this URL to test:
    http://localhost:8080/CrunchifyREST/crunchify/ctofservice
    http://localhost:8080/CrunchifyREST/crunchify/ctofservice/<celsius>
    http://localhost:8080/CrunchifyREST/crunchify/ctofservice/celsius?c=<celsius>

What it is
----------
Creates a few RESTful endpoints of various types
	1. url, fixed: Uses a constant independent value and returns the same dependent value every time
	2. url, variable: adds a variable for the independent value to the url, dependent value is based on the independent value 
	3. url with parameter: uses a parameter for the independent value, dependent value is based on the independent value

ctofservice returns xml
ftocservice returns json 


Concepts
--------
different type of REST endpoints (url and parameterized)
different return types (xml and json)