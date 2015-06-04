package com.vogel.rest.controller;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.vogel.rest.persistence.DBase;
import com.vogel.rest.persistence.util.HibernateUtil;

public class DeleteEntry
{
  /**
   * === D ===
   * 
   * @param courseId
   */
  public long deleteIndex(long index)
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;

    try
    {
      transaction = session.beginTransaction();
      DBase dBase = (DBase) session.get(DBase.class, 1L);
      if (dBase != null)
      {
        String name = dBase.getName();
        session.delete(dBase);
        transaction.commit();
      }
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
   * 
   */
  @Test
  public void shouldDeleteEntry()
  {

    long idx = deleteIndex(1);
    ;
    System.out.println("Should Delete Entry (index): " + idx);

  }
}
