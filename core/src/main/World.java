package main;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.Disposable;

public class World implements Disposable
{
	private TiledMap map;
	private OrthogonalTiledMapRenderer mapRenderer;
	private OrthographicCamera camera;
	private Player player;
	private int[] bgLayer;
	private int[] fgLayer;

	public World()
	{
		map = new TmxMapLoader().load("PokemonMap2.tmx");
		mapRenderer = new OrthogonalTiledMapRenderer(map, Global.UNIT_SCALE);
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Global.TILES_IN_WIDTH, Global.TILES_IN_WIDTH / 16f * 9f);

		player = new Player(5, 5, camera, (TiledMapTileLayer)map.getLayers().get("data"));

		bgLayer = new int[]{0};
		fgLayer = new int[]{map.getLayers().getCount() - 1};
	}

	public void render(float delta)
	{
		camera.position.set(player.getPosition(), 0f);
		camera.update();
		mapRenderer.setView(camera);
		mapRenderer.render(bgLayer);
		player.render(delta);
		mapRenderer.render(fgLayer);
	}

	@Override
	public void dispose()
	{
		player.dispose();
		map.dispose();
		mapRenderer.dispose();
	}
}
