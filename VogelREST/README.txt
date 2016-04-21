Tutorial:
http://www.vogella.com/tutorials/REST/article.html#first

Use this url to test (it is different than what the tutorial calls for):
http://localhost:8080/VogelREST/rest/hello

-  'VogelREST' is defined in the web.xml as <display-name>
-  'rest' is defined in the web.xml as <url-pattern>
-  'hello' is defined in the class and the @Path

In web.xml, the

There are multiple responders for the GET /hello url. 1 for plain text, 1 for XML and 1 for HTML
A browser will ask for HTML by default, so we get the 'HTML Hello from Jersey' response
If the HTML response is not present (or commented out as a test) then the 
plain text response is delivered to the browser

!! Use Postman to send various requests to the web app
