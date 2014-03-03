package com.jomuda.playn.android;

import playn.android.GameActivity;
import playn.core.PlayN;

import com.jomuda.playn.core.RPGGame;

public class RPGGameActivity extends GameActivity {

  @Override
  public void main(){
    PlayN.run(new RPGGame());
  }
}
