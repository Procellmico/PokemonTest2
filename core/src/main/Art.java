package main;

import com.badlogic.gdx.graphics.Texture;

public class Art
{
	public static Texture playerLeftWalk;
	public static Texture playerRightWalk;
	public static Texture playerUpWalk;
	public static Texture playerDownWalk;
	public static Texture playerIdle;

	public static void loadArt()
	{
		playerDownWalk = new Texture("playerDownWalk2.png");
		playerIdle = new Texture("playerIdle2.png");
		playerUpWalk = new Texture("playerUpWalk2.png");
		playerLeftWalk = new Texture("playerLeftWalk2.png");
		playerRightWalk = new Texture("playerRightWalk2.png");
	}

	public static void disposeArt()
	{
		playerDownWalk.dispose();
		playerIdle.dispose();
		playerUpWalk.dispose();
		playerLeftWalk.dispose();
		playerRightWalk.dispose();
	}
}
