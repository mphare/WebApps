package com.vogel.rest.controller;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.vogel.rest.persistence.DBase;
import com.vogel.rest.persistence.HibernateUtil;

public class RetrieveEntry
{
  public String getNameByIndex(long index)
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    String name = null;

    try
    {
      transaction = session.beginTransaction();
      List indexes = session.createQuery("from DBase").list();
      for (Iterator iterator = indexes.iterator(); iterator.hasNext();)
      {
        DBase dbase = (DBase) iterator.next();
        name = dbase.getName();
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

    return name;
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

  @Test
  public void testThis()
  {

    long idx = getMyIndex();
    System.out.println("This Test: " + idx);

  }
}
