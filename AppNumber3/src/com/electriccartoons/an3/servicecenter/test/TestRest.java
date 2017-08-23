package com.electriccartoons.an3.servicecenter.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class TestRest
{
  
  @Path("test1")
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String runTest1()
  {
    return "Test 1 Completed";
  }

}
