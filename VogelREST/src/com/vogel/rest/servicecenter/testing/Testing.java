package com.vogel.rest.servicecenter.testing;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.vogel.rest.beans.MyBean;

@Path("/testing")
public class Testing
{
  @Path("getJson")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public MyBean produceMyBead()
  {
    String name = "H Jaxon";
    String type = "Sevar";
    MyBean mybean = new MyBean(name, type);

    return mybean;
  }

  @Path("sendJson")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response consumeMyBean(MyBean mybean)
  {
    String name = mybean.getName();
    String type = mybean.getType();

    System.out.println("Name: " + name + " Type: " + type);
    return Response.status(200).entity(name).build();

  }

}
