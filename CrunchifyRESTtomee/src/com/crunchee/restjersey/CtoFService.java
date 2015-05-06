package com.crunchee.restjersey;

import javax.ws.rs.GET;


@Path("/ctofservice")
public class CtoFService
{

  @GET
  @Produces("application/xml")
  public String convertCtoF()
  {

    Double fahrenheit;
    Double celsius = 36.8;
    fahrenheit = ((celsius * 9) / 5) + 32;

    String result = "@Produces(\"application/xml\") Output: \n\nC to F Convertor Output: \n\n" + fahrenheit;
    return "<ctofservice>" + "<celsius>" + celsius + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput>"
        + "</ctofservice>";
  }

  @Path("{c}")
  @GET
  @Produces("application/xml")
  public String convertCtoFfromInput(@PathParam("c") Double c)
  {

    Double fahrenheit;
    Double celsius = c;
    fahrenheit = ((celsius * 9) / 5) + 32;

    String result = "@Produces(\"application/json\") Output: \n\nC to F Convertor Output: \n\n" + fahrenheit;
    return "<ctofservice>" + "<celsius>" + celsius + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput>"
        + "</ctofservice>";
  }

}
