import java.net.URL;
import java.util.Properties;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class TomEECalcClient
{
  public static void main(String[] args) throws Exception
  {
    Properties properties = new Properties();
    properties.setProperty("openejb.embedded.remotable", "true");

    Service calcService = Service.create(new URL("http://localhost:8080/TomEEWs/webservices/HelloTomEEWsImpl?wsdl"),
        new QName("http://sortedset.com/wsdl", "HelloTomEEService"));

    HelloTomEEWs calc = calcService.getPort(HelloTomEEWs.class);

    System.out.println("Sum of 10 and 10 is : " + calc.sum(10, 10));
    System.out.println("Multiple of 10 and 10 is : " + calc.multiply(10, 10));
  }
}
