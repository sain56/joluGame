package com.jomuda.playn.core;

import playn.core.Keyboard;

public interface Screen {


  public void update(int delta);

  public void paint(float alpha);

//  public boolean unload();

  public void notifyKeyEvent(Keyboard.Event e);
}
