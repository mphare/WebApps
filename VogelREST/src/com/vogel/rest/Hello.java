package com.vogel.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class Hello
{
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String sayPlainTextHello()
  {
    return "Plain Text Hello from Jersey";
  }

  @GET
  @Produces(MediaType.TEXT_XML)
  public String sayXMLHello()
  {
    return "<?xml version=\"1.0\"?>" + "<hello> XML Hello from Jersey" + "</hello>";
  }

  @GET
  @Produces(MediaType.TEXT_HTML)
  public String sayHtmlHello()
  {
    return "<html> " + "<title>" + "Hello Jersey" + "</title>" + "<body><h1>" + "HTML Hello from Jersey"
        + "</body></h1>" + "</html> ";
  }
}
