package main;

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

	public World()
	{
		map = new TmxMapLoader().load("PokemonMap2.tmx");
		mapRenderer = new OrthogonalTiledMapRenderer(map, Global.UNIT_SCALE);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Global.TILES_IN_WIDTH, Global.TILES_IN_WIDTH / 16f * 9f);
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
		map.dispose();
		mapRenderer.dispose();
	}
}
