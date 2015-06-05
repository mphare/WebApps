package com.vogel.rest.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.vogel.rest.controller.CreateEntry;
import com.vogel.rest.controller.DeleteEntry;
import com.vogel.rest.controller.RetrieveEntry;
import com.vogel.rest.controller.UpdateEntry;

public class WhenTestingHibernate
{
  UpdateEntry   ue = null;
  CreateEntry   ce = null;
  DeleteEntry   de = null;
  RetrieveEntry re = null;

  @Before
  public void initialize()
  {
    ue = new UpdateEntry();
    de = new DeleteEntry();
    ce = new CreateEntry();
    re = new RetrieveEntry();

  }

  @Test
  public void shoudModifyNameType()
  {
    Long idx = ce.saveNameType("MyTest1name", "MyTestType");
    String name = re.getNameByIndex(idx);

    assertEquals(name, "MyTest1name");

    ue.updateNameType(idx, "ABCD1", "1234A");
    name = re.getNameByIndex(idx);

    assertEquals(name, "ABCD1");

    de.deleteIndex(idx);

  }
}
