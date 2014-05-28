package main.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import main.PokemonTest2;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.backgroundFPS = 60;
		config.foregroundFPS = 60;
		config.fullscreen = false;
		config.height = 540;
		config.initialBackgroundColor = Color.BLACK;
		config.resizable = false;
		config.title = "Pokemon Test 3";
		config.vSyncEnabled = false;
		config.width = 960;
		new LwjglApplication(new PokemonTest2(), config);
	}
}
