package com.jomuda.playn.core.menu;

import java.util.Observable;

public class MenuEntry extends Observable{
	
	private String label;
	
	public MenuEntry(String label){
		this.setLabel(label);
	}
	
	public void activate(){
		super.notifyObservers();
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
