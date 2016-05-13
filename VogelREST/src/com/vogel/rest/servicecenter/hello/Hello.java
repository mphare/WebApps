package com.vogel.rest.servicecenter.hello;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


import com.vogel.rest.controller.CreateEntry;
import com.vogel.rest.controller.DeleteEntry;
import com.vogel.rest.controller.RetrieveEntry;
import com.vogel.rest.controller.UpdateEntry;
import com.vogel.rest.persistence.DBase;

@Path("/hello")
public class Hello
{

  /**
   * 
   * @param idx
   * @return
   */
  @Path("arg")
  @PUT
  @Produces(MediaType.TEXT_PLAIN)
  public String modifyNameTypeRS(@QueryParam("idx") Long idx, @QueryParam("name") String name,
      @QueryParam("type") String type)
  {
    UpdateEntry ue = new UpdateEntry();
    ue.updateNameType(idx, name, type);
    return "Modify Name, Type for (index): " + idx;
  }

  /**
   * 
   * @param idx
   * @return
   */
  @Path("arg")
  @DELETE
  @Produces(MediaType.TEXT_PLAIN)
  public String deleteIndexRS(@QueryParam("idx") long idx)
  {
    DeleteEntry de = new DeleteEntry();
    de.deleteIndex(idx);
    return "Deleted Index: " + idx;
  }

  /**
   * 
   * @param name
   * @param type
   * @return
   */
  @Path("arg")
  @POST
  @Produces(MediaType.TEXT_PLAIN)
  public String saveNameTypeRS(@QueryParam("name") String name, @QueryParam("type") String type)
  {

    CreateEntry cne = new CreateEntry();
    Long idx = cne.saveNameType(name, type);
    return "Added new Name: " + name + " Type: " + type + " index: " + idx;
  }

  /*
   * http://localhost:8080/VogelREST/rest/hello
   */
  /**
   * 
   * @return
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
  /**
   * 
   * @param c
   * @return
   */
  @Path("{c}")
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String sayPlainTextHelloWithC(@PathParam("c") Double c)
  {
    return "Plain Text Hello from Jersey with C: " + c;
  }

  /*
   * http://localhost:8080/VogelREST/rest/hello/test?idx=<c>
   */
  /**
   * 
   * @param idx
   * @return
   */
  @Path("test")
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String sayPlainTextHelloWithArgRS(@QueryParam("idx") long idx)
  {
    return "Index: " + idx;
  }

  /*
   * http://localhost:8080/VogelREST/rest/hello/arg?c=<c>
   */
  /**
   * 
   * @param c
   * @return
   */
  @Path("arg")
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String getPlainTextHelloWithArgRS(@QueryParam("idx") long idx)
  {
    RetrieveEntry re = new RetrieveEntry();
    String name = re.getNameByIndex(idx);
    return "Index: " + idx + " Name: " + name;
  }

  /**
   * 
   * @param idx
   * @return
   */
  @Path("entry")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public DBase getJSonHelloWithArgRS(@QueryParam("idx") long idx)
  {
    RetrieveEntry re = new RetrieveEntry();
    DBase dBase = re.getByIndex(idx);
    return dBase;
  }

  /**
   * 
   * @return
   */
  @Path("entries")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<DBase> getJSonEntriesRS()
  {
    RetrieveEntry re = new RetrieveEntry();
    List<DBase> dBases = re.getEntries();
    return dBases;
  }

  /**
   * 
   * @return
   */
  @POST
  @Produces(MediaType.TEXT_PLAIN)
  public String sayPlainTextHelloPost()
  {
    return "Plain Text Hello from Jersey (w/Post)";
  }

  /**
   * http://localhost:8080/VogelREST/rest/hello/xml
   * 
   * @return
   */
  @Path("xml")
  @GET
  @Produces(MediaType.TEXT_XML)
  public String sayXMLHello()
  {
    return "<?xml version=\"1.0\"?>" + "<hello> XML Hello from Jersey" + "</hello>";
  }

  @Path("list")
  @GET
  @Produces(MediaType.TEXT_HTML)
  public String getListofEntriesRS()
  {
    RetrieveEntry re = new RetrieveEntry();
    String list = re.getListOfEntries();
    return "<html> " + "<title>" + "Hello Jersey" + "</title>" + "<body><h1>" + "List of Entries" + "</h1>" + list
        + "</body>" + "</html> ";
  }

  /**
   * 
   * @return
   */
  @Path("htmlx")
  @GET
  @Produces(MediaType.TEXT_HTML)
  public String getHtmlHello()
  {

    RetrieveEntry re = new RetrieveEntry();
    long idx = re.getMyIndex();
    return "<html> " + "<title>" + "Hello Jersey" + "</title>" + "<body><h1>" + "HTML Hello from Jersey (index: " + idx
        + ")" + "</h1></body>" + "</html> ";
  }

  /**
   * http://localhost:8080/VogelREST/rest/hello/html
   * 
   * @return
   */
  @Path("html")
  @GET
  @Produces(MediaType.TEXT_HTML)
  public String sayHtmlHello()
  {

    return "<html> " + "<title>" + "Hello Jersey" + "</title>" + "<body><h1>" + "HTML Hello from Jersey" + "</h1></body>" + "</html> ";
  }
  /**
   * http://localhost:8080/VogelREST/rest/hello/html
   * 
   * @return
   */


}
