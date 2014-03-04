package com.jomuda.playn.core;

import java.util.EnumSet;
import java.util.Set;

import playn.core.Key;

public class Keybinding {
	

	public static final Set<Key> MENU = EnumSet.of(Key.ESCAPE);
	public static final Set<Key> ACCEPT = EnumSet.of(Key.ENTER);
        public static final Set<Key> UP = EnumSet.of(Key.UP, Key.W);
        public static final Set<Key> DOWN = EnumSet.of(Key.DOWN, Key.S);
        public static final Set<Key> LEFT = EnumSet.of(Key.LEFT, Key.A);
        public static final Set<Key> RIGHT = EnumSet.of(Key.RIGHT, Key.D);
        public static final Set<Key> CANCEL = EnumSet.of(Key.BACKSPACE);
		

	
}
