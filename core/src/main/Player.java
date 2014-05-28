package main;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;

public class Player implements Disposable
{
	private Vector2 position;

	public Player(float x, float y)
	{
		position = new Vector2(x, y);
	}

	public void onKeyTap(int keycode)
	{

	}

	@Override
	public void dispose()
	{

	}
}
