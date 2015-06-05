package com.vogel.rest.main;

import org.apache.log4j.Logger;

import com.vogel.rest.controller.CreateEntry;
import com.vogel.rest.controller.DeleteEntry;

public class MainApp
{
  final static Logger logger = Logger.getLogger(MainApp.class);

  public static void main(String[] args)
  {
    CreateEntry ce = new CreateEntry();
    DeleteEntry de = new DeleteEntry();

    Long entry01 = ce.saveNameType("F Franklin", "Raptor");
    // logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>>> Created: " + entry01);
    Long entry02 = ce.saveNameType("M Michaelson (tbr)", "Tesla");
    de.deleteIndex(entry02);

  }

}
