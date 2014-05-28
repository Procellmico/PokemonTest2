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
		playerDownWalk = new Texture("playerDownWalk.png");
		playerIdle = new Texture("playerIdle.png");
		playerUpWalk = new Texture("playerUpWalk.png");
		playerLeftWalk = new Texture("playerLeftWalk.png");
		playerRightWalk = new Texture("playerRightWalk.png");
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
