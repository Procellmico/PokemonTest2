package main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;

public class InputManager extends InputAdapter
{
	private Player player;
	private boolean isKeyPressed[];
	private float timePressed[];

	public InputManager(Player play)
	{
		player = play;
		isKeyPressed = new boolean[256];
		timePressed = new float[256];
	}

	public boolean isKeyPressed(int keycode)
	{
		return isKeyPressed[keycode];
	}

	public void update()
	{
		for (int i = 0; i < 256; i++)
		{
			if (isKeyPressed[i])
			{
				timePressed[i] += Gdx.graphics.getDeltaTime();
				if (timePressed[i] > Global.HOLD_THRESHOLD)
				{
					player.onKeyPressed(i);
				}
				else
				{
					player.onKeyTapped(i);
				}
			}
		}
	}

	public boolean keyDown(int keycode)
	{
		isKeyPressed[keycode] = true;
		return true;
	}

	public boolean keyUp(int keycode)
	{
		timePressed[keycode] = 0f;
		isKeyPressed[keycode] = false;
		return true;
	}
}
