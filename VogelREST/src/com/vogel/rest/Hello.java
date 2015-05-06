package com.vogel.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class Hello
{
  /*
   * http://localhost:8080/VodelREST/rest/hello
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String sayPlainTextHello()
  {
    return "Plain Text Hello from Jersey";
  }

  /*
   * http://localhost:8080/VogelREST/rest/hello/<c>
   */
  @Path("{c}")
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String sayPlainTextHelloWithC(@PathParam("c") Double c)
  {
    return "Plain Text Hello from Jersey with C: " + c;
  }

  /*
   * http://localhost:8080/VogelREST/rest/hello/arg?c=<c>
   */
  @Path("arg")
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String sayPlainTextHelloWithArg(@QueryParam("c") Double c)
  {
    return "Plain Text Hello from Jersey with Argument: C: " + c;
  }

  @POST
  @Produces(MediaType.TEXT_PLAIN)
  public String sayPlainTextHelloPost()
  {
    return "Plain Text Hello from Jersey (w/Post)";
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
        + "</h1></body>" + "</html> ";
  }
}
