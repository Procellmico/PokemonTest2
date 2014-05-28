package main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class PokemonTest2 extends Game
{
	@Override
	public void create()
	{
		Art.loadArt();

		setScreen(new GameScreen());
	}

	@Override
	public void render()
	{
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);

		if (getScreen() != null)
		{
			getScreen().render(Gdx.graphics.getDeltaTime());
		}
	}

	@Override
	public void dispose()
	{
		if (getScreen() != null)
		{
			getScreen().hide();
		}
		Art.disposeArt();
	}
}
