package com.vogel.rest;

import java.util.Iterator;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

@Path("/hello")
public class Hello
{

  @Path("arg")
  @DELETE
  @Produces(MediaType.TEXT_PLAIN)
  public String deleteIndexRS(@QueryParam("idx") String idx)
  {
    Long index = Long.parseLong(idx);
    deleteIndex(index);
    return "Deleted Index: " + index;
  }

  @Path("arg")
  @POST
  @Produces(MediaType.TEXT_PLAIN)
  public String saveNameTypeRS(@QueryParam("name") String name, @QueryParam("type") String type)
  {

    Long idx = saveNameType(name, type);
    return "Added new Name: " + name + " Type: " + type + " index: " + idx;
  }

  /*
   * http://localhost:8080/VogelREST/rest/hello
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

  /*
   * ======================================================= Use This One!
   * -------------------------------------------------------
   */
  @GET
  @Produces(MediaType.TEXT_HTML)
  public String sayHtmlHello()
  {
    long idx = getMyIndex();
    return "<html> " + "<title>" + "Hello Jersey" + "</title>" + "<body><h1>" + "HTML Hello from Jersey (index: " + idx
        + ")" + "</h1></body>" + "</html> ";
  }

  @Test
  public void testThis()
  {

    long idx = getMyIndex();
    System.out.println("This Test: " + idx);

  }

  public long getMyIndex()
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    long retValue = -1;
    try
    {
      transaction = session.beginTransaction();
      List indexes = session.createQuery("from DBase").list();
      for (Iterator iterator = indexes.iterator(); iterator.hasNext();)
      {
        DBase dbase = (DBase) iterator.next();
        retValue = dbase.getIndex();
      }
      transaction.commit();

    } catch (HibernateException e)
    {
      transaction.rollback();
      e.printStackTrace();

    } finally
    {
      session.close();
    }
    return retValue;
  }

  /**
   * === C ===
   * 
   * @param courseName
   * @return
   */
  public Long saveNameType(String name, String type)
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    Long index = null;
    try
    {
      transaction = session.beginTransaction();
      DBase dBase = new DBase();
      dBase.setName(name);
      dBase.setType(type);

      index = (Long) session.save(dBase);
      transaction.commit();

    } catch (HibernateException e)
    {
      transaction.rollback();
      e.printStackTrace();
    } finally
    {
      session.close();
    }
    return index;
  }

  /**
   * === D ===
   * 
   * @param courseId
   */
  public void deleteIndex(Long index)
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    try
    {
      transaction = session.beginTransaction();
      DBase dBase = (DBase) session.get(DBase.class, index);
      session.delete(dBase);
      transaction.commit();
    } catch (HibernateException e)
    {
      transaction.rollback();
      e.printStackTrace();

    } finally
    {
      session.close();

    }
  }
}
