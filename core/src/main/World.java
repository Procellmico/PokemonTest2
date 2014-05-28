package main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.Disposable;

public class World implements Disposable
{
	private TiledMap map;
	private OrthogonalTiledMapRenderer mapRenderer;
	private OrthographicCamera camera;
	private Player player;

	public World()
	{
		map = new TmxMapLoader().load("PokemonMap2.tmx");
		mapRenderer = new OrthogonalTiledMapRenderer(map, Global.UNIT_SCALE);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Global.TILES_IN_WIDTH, Global.TILES_IN_WIDTH / 16f * 9f);

		player = new Player(5, 5);

		Gdx.input.setInputProcessor(InputManager.getInstance(player));
	}

	public void render(float delta)
	{
		camera.update();
		mapRenderer.setView(camera);
		mapRenderer.render();
	}

	@Override
	public void dispose()
	{
		player.dispose();
		map.dispose();
		mapRenderer.dispose();
	}
}
