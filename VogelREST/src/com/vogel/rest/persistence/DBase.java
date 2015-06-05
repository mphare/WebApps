package com.vogel.rest.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "basetable")
public class DBase
{

  private long   index;
  private String name;
  private String type;

  public DBase()
  {

  }

  @Id
  @GeneratedValue
  @Column(name = "ENTRY_ID")
  public long getIndex()
  {
    return index;
  }

  public void setIndex(long index)
  {
    this.index = index;
  }

  @Column(name = "NAME")
  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  @Column(name = "TYPE")
  public String getType()
  {
    return type;
  }

  public void setType(String type)
  {
    this.type = type;
  }

}
