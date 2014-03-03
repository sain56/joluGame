package com.jomuda.playn.core;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainMenuTest {

	@Test
	public void test_Init_0(){
		MainMenu sut = new MainMenu();
		
		assertEquals("MenuSize not in accordance to menuEntries!", sut.menuSize, sut.menuEntries.size());
		assertEquals(sut.menuEntries.get(0).getLabel(), "START");
		assertEquals(sut.menuEntries.get(1).getLabel(), "EXIT");
	}

}
