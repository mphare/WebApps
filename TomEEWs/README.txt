
Where the tutorial is
---------------------
http://blog.sortedset.com/step-by-step-web-services-with-tomcat-tomee-apache-cxf-eclipse/



Run it
------
Use this URL for the WSDL"
http://localhost:8080/TomEEWs/webservices/HelloTomEEWsImpl?wsdl

Note: The tutorial has you export the WAR to /<tomee>/webapps
In the case of running Tomee from Eclipse, this is NOT /opt/tomee/webapps
(at least not how I have tomee configured in Eclipse)
Instead, export the WAR to <proj workspace>/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/webapps
Note: It might be /tmp1/ depending on what other containers are installed. If tomcat was installed first, it
is using tmp0, so tomee will be tmp1. Just be sure you know which is which (look at some of the other installed apps)

 References to Admin-GUI and to the Console button are lost on me. I cannot find them anywhere
 
 Use the other project, TomEEClient, to test TomEEWs at the application level
 DO NO deploy TomEEClient to Tomee or to Tomcat, it is not necessary and may cause 
 problems if you try.
 Just run TomEECalcClient as a Java Application and it will find the WS and calculate the results.
 
 What it is
 ----------
 A full service Web Service including the wsdl
 
 Concepts
 --------
 Web Service
 WSDL
 Soap
 SoapGUI
 Deploy as WAR to Tomee
 