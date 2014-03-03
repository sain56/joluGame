package com.jomuda.playn.core;

import static playn.core.PlayN.graphics;

import java.util.LinkedList;
import java.util.List;

import playn.core.GroupLayer;
import playn.core.Key;
import playn.core.Keyboard;
import tripleplay.ui.Background;
import tripleplay.ui.Interface;
import tripleplay.ui.Label;
import tripleplay.ui.Root;
import tripleplay.ui.SimpleStyles;
import tripleplay.ui.Style;
import tripleplay.ui.layout.AxisLayout;

public class MainMenu implements Screen {
	
  public int index;
  public int menuSize;
  public List<MenuEntry> menuEntries;
  
  private GroupLayer layer;
  private Interface iface;
 
  public MainMenu(){
	  init();
  }

  private void init(){
	  layer = graphics().createGroupLayer();
	  graphics().rootLayer().add(layer);
	  iface = new Interface(null);
	  Root root = iface.createRoot(AxisLayout.vertical().gap(15), SimpleStyles.newSheet());
	  root.setSize(graphics().screenWidth(), graphics().screenHeight());
	  root.addStyles(Style.BACKGROUND.is(Background.solid(0xC0C0C0)));
	  layer.add(root.layer);
	  
	  index = 0;
	  menuEntries = new LinkedList<MenuEntry>();
	  menuEntries.add(new MenuEntry("START"));
	  menuEntries.add(new MenuEntry("EXIT"));
	  menuSize = menuEntries.size();
	  
	  root.add(new Label("SimpleRPG"));
  }
  
  
  public void navigateMenu(int direction){
	  index = (index + menuSize + direction) % menuSize;
  }
	
  public void activateMenu(){
	  menuEntries.get(index).activate();
	  System.out.println(index);
  }
	
  public void update(int delta){

  }

  public void paint(float alpha) {

  }

//  public boolean unload() {
//    try{
//    	finalize();
//    	return true;
//    } catch(Throwable e){
//    	return false;
//    }
//  }

	@Override
	public void notifyKeyEvent(Keyboard.Event e) {
		System.out.println("Notified by key.event: " + e.key().toString());

		if(e.key().equals(Key.UP))
			navigateMenu(-1);
		else if(e.key().equals(Key.DOWN))
			navigateMenu(1);
		else if(e.key().equals(Key.ENTER))
			activateMenu();
	}
}
