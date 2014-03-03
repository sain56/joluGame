package com.jomuda.playn.java;

import playn.core.PlayN;
import playn.java.JavaPlatform;

import com.jomuda.playn.core.RPGGame;

public class RPGGameJava {

  public static void main(String[] args) {
    JavaPlatform.Config config = new JavaPlatform.Config();
    // use config to customize the Java platform, if needed
    JavaPlatform.register(config);
    PlayN.run(new RPGGame());
  }
}
