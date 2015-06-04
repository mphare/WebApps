package com.vogel.rest.controller;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vogel.rest.persistence.DBase;
import com.vogel.rest.persistence.util.HibernateUtil;

public class CreateEntry
{
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

}
