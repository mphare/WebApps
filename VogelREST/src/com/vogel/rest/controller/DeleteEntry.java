package com.vogel.rest.controller;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vogel.rest.persistence.DBase;
import com.vogel.rest.persistence.util.HibernateUtil;

public class DeleteEntry
{
  /**
   * === D ===
   * 
   * @param courseId
   */
  public void deleteIndex(Double index)
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    long id = index.longValue();

    try
    {
      transaction = session.beginTransaction();
      DBase dBase = (DBase) session.get(DBase.class, id);
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
  }

}
