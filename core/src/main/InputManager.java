package main;

import com.badlogic.gdx.InputAdapter;

public class InputManager extends InputAdapter
{
	private boolean[] keyPressed;
	private static InputManager instance;
	private static Player player;

	private InputManager()
	{
		keyPressed = new boolean[256];
	}

	public boolean keyDown(int keycode)
	{
		player.onKeyTap(keycode);
		keyPressed[keycode] = true;
		return true;
	}

	public boolean keyUp(int keycode)
	{
		keyPressed[keycode] = false;
		return true;
	}

	public static InputManager getInstance(Player player1)
	{
		if (instance == null)
		{
			instance = new InputManager();
		}

		if (player == null)
		{
			player = player1;
		}

		return instance;
	}
}
