import javax.ejb.Stateless;
import javax.jws.WebService;

@Stateless
@WebService(portName = "HelloTomEEPort", serviceName = "HelloTomEEService", targetNamespace = "http://sortedset.com/wsdl", endpointInterface = "HelloTomEEWs")
public class HelloTomEEWsImpl implements HelloTomEEWs
{

  @Override
  public int sum(int add1, int add2)
  {
    return add1 + add2;
  }

  @Override
  public int multiply(int mul1, int mul2)
  {
    return mul1 * mul2;
  }

}
