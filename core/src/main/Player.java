package main;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;

public class Player implements Disposable
{
	private Vector2 position;
	private PlayerGraphics graphics;
	private SpriteBatch batch;
	private OrthographicCamera camera;

	public Player(float x, float y, OrthographicCamera cam)
	{
		position = new Vector2(x, y);
		graphics = new PlayerGraphics(1f / 6f);
		batch = new SpriteBatch();
		camera = cam;
	}

	public void render(float delta)
	{
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(graphics.currentTexture, position.x, position.y, 1f, (float)graphics.currentTexture.getRegionHeight() / (float)graphics.currentTexture.getRegionWidth());
		batch.end();
	}

	public void onKeyTap(int keycode)
	{
	}

	@Override
	public void dispose()
	{
		batch.dispose();
	}
}
