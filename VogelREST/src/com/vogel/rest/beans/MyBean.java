package com.vogel.rest.beans;

public class MyBean
{
  String name;
  String type;

  public MyBean()
  {

  }

  public MyBean(String name, String type)
  {
    this.name = name;
    this.type = type;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getType()
  {
    return type;
  }

  public void setType(String type)
  {
    this.type = type;
  }

}
