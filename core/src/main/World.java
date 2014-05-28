package main;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.utils.Disposable;

public class World implements Disposable
{
	private TiledMap map;

	public World()
	{
		map = new TmxMapLoader().load("PokemonMap2.tmx");
	}

	@Override
	public void dispose()
	{
		map.dispose();
	}
}
