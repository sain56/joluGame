package com.jomuda.playn.core.menu;

import java.security.InvalidParameterException;
import java.util.Observable;
import java.util.Observer;

public class MenuEntryObserver implements Observer {
	

	@Override
	public void update(Observable arg0, Object arg1){
		if(arg0 instanceof MenuEntry){
			
		}
		
		else
			throw new InvalidParameterException(arg0 + " is not of type MenuEntry");
	}

}
