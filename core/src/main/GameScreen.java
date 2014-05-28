package main;

import com.badlogic.gdx.Screen;

public class GameScreen implements Screen
{
	private World world;

	@Override
	public void render(float delta)
	{
		world.render(delta);
	}

	@Override
	public void resize(int width, int height)
	{

	}

	@Override
	public void show()
	{
		world = new World();
	}

	@Override
	public void hide()
	{
		dispose();
	}

	@Override
	public void pause()
	{

	}

	@Override
	public void resume()
	{

	}

	@Override
	public void dispose()
	{
		world.dispose();
	}
}
