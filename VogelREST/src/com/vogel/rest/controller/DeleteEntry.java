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
  public Long deleteIndex(Long index)
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;

    try
    {
      transaction = session.beginTransaction();
      DBase dBase = (DBase) session.get(DBase.class, index);
      if (dBase != null)
      {
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

    Long idx = deleteIndex(1L);
    System.out.println("Should Delete Entry (index): " + idx);

  }
}
