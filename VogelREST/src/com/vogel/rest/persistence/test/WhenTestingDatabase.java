package com.vogel.rest.persistence.test;

import org.junit.Test;

import com.vogel.rest.controller.CreateEntry;

public class WhenTestingDatabase {

	
	@Test
	public void shouldwWriteToDatabase() {
	
		CreateEntry ce = new CreateEntry();
		ce.saveNameType("Crimson","Stark");
		
	}
}
