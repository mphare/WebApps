package com.mphare.springhw;

public class MainApp
{

  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

    HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
    obj.getMessage();

  }

}
