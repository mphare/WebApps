package com.vogel.rest.controller;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vogel.rest.persistence.DBase;
import com.vogel.rest.persistence.util.HibernateUtil;

public class UpdateEntry
{

  /**
   * 
   * === U ===
   * 
   * @param index
   * @param name
   * @param type
   */
  public void updateNameType(Long index, String name, String type)
  {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    try
    {
      transaction = session.beginTransaction();
      DBase dBase = (DBase) session.get(DBase.class, index);
      // If the row for index doesn't exist, this will be null
      if (dBase != null)
      {
        dBase.setName(name);
        dBase.setType(type);
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
