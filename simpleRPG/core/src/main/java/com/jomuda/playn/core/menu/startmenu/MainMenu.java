package com.jomuda.playn.core.menu.startmenu;

import static playn.core.PlayN.graphics;

import java.util.LinkedList;
import java.util.List;

import playn.core.Canvas;
import playn.core.CanvasImage;
import playn.core.Color;
import playn.core.GroupLayer;
import playn.core.ImageLayer;
import playn.core.Keyboard;
import tripleplay.ui.Interface;

import com.jomuda.playn.core.Keybinding;
import com.jomuda.playn.core.Screen;
import com.jomuda.playn.core.menu.MenuEntry;
import com.jomuda.playn.core.menu.MenuEntryObserver;

public class MainMenu implements Screen {
	
  public int index;
  public int menuSize;
  public List<MenuEntry> menuEntries;
  
  private GroupLayer layer;
  private Interface iface;
  
  
 
  public MainMenu(){
	  init();
  }

  private CanvasImage createMenuImage(MenuEntry me){
	  CanvasImage result = graphics().createImage(200, 50);
	  Canvas resultCanvas = result.canvas();
	  
//	  resultCanvas.setFillGradient(graphics().createLinearGradient(0f, 0f, 200f, 50f, {Color.rgb(0, 0, 0), Color.rgb(100, 0, 0)}, {0, 0, 200, 50}))
	  resultCanvas.setFillColor(Color.argb(50, 255, 255, 255));
          resultCanvas.fillRect(0, 0, result.width(), result.height());
          resultCanvas.setFillColor(Color.rgb(0, 0, 0));
	  resultCanvas.drawText(me.getLabel(), result.width()/2, result.height()/2);
	  
	  
	  return result;
  }
  
  private void init(){
//	  layer = graphics().createGroupLayer();
//	  graphics().rootLayer().add(layer);
//	  iface = new Interface(null);
//	  Root root = iface.createRoot(AxisLayout.vertical().gap(15), SimpleStyles.newSheet());
//	  root.setSize(graphics().screenWidth(), graphics().screenHeight());
//	  root.addStyles(Style.BACKGROUND.is(Background.solid(0xC0C0C0)));
//	  layer.add(root.layer);
	  layer = graphics().createGroupLayer();
	  graphics().rootLayer().add(layer);
	  
	  index = 0;
	  menuEntries = new LinkedList<MenuEntry>();
          
	  	  MenuEntry start = new MenuEntry("START");
	  	start.addObserver(new MenuEntryObserver());
	    menuEntries.add(start);
	    
	      MenuEntry settings = new MenuEntry("SETTINGS");
	    menuEntries.add(settings);
	    
	      MenuEntry load = new MenuEntry("LOAD");
	    menuEntries.add(load);
	  
	      MenuEntry exit = new MenuEntry("EXIT");
	    menuEntries.add(exit);
          menuSize = menuEntries.size();

	  for(int i = 0; i < menuSize; i++){
		  ImageLayer il = graphics().createImageLayer(createMenuImage(menuEntries.get(i)));
		  layer.addAt(il, 0, 50 + 100 * i);
	  }

//	  root.add(new Label("SimpleRPG"));
  }
  
  
  public void navigateMenu(int direction){
	  index = (index + menuSize + direction) % menuSize;
  }
	
  private void activateMenu(){
	  menuEntries.get(index).activate();
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

		/* if(e.key().equals(Key.UP))
			navigateMenu(-1);
		else if(e.key().equals(Key.DOWN))
			navigateMenu(1);
		else if(e.key().equals(Key.ENTER))
			activateMenu(); */

                if(Keybinding.ACCEPT.contains(e.key()))
                  activateMenu();
                else if(Keybinding.CANCEL.contains(e.key()))
                  { }
                else if(Keybinding.UP.contains(e.key()))
                  navigateMenu(-1);
                else if(Keybinding.DOWN.contains(e.key()))
                  navigateMenu(1);

	}
}
