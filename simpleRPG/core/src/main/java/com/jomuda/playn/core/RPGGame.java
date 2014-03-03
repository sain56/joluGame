package com.jomuda.playn.core;

import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;
import playn.core.Game;
import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.Key;
import playn.core.Keyboard;
import playn.core.PlayN;

public class RPGGame extends Game.Default {

  private Screen currentScreen;
  private Screen previousScreen;
  private MainMenu mainMenu;

  public RPGGame() {
    super(33); // call update every 33ms (30 times per second)
  }

  @Override
  public void init() {
    // create and add background image layer
    Image bgImage = assets().getImage("images/bg.png");
    ImageLayer bgLayer = graphics().createImageLayer(bgImage);
    graphics().rootLayer().add(bgLayer);

    mainMenu = new MainMenu();
    
    currentScreen = mainMenu;
    
    PlayN.keyboard().setListener(new Keyboard.Adapter(){
    	@Override
    	public void onKeyDown(Keyboard.Event e){
    		if(Keybinding.MENU.contains(e.key()))
    			toggleMenu();
    		else
    			currentScreen.notifyKeyEvent(e);
    	}
    });
  }
  
  private void toggleMenu(){
	  if(currentScreen.equals(mainMenu) && previousScreen != null)
		  currentScreen = previousScreen;
	  else{
		  previousScreen = currentScreen;
		  currentScreen = mainMenu;
	  }
  }

  @Override
  public void update(int delta) {
    currentScreen.update(delta);
  }

  @Override
  public void paint(float alpha) {
    currentScreen.paint(alpha);
  }
}
