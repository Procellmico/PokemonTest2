package main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;

public class Player implements Disposable
{
	private Vector2 position;
	private PlayerGraphics graphics;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private int currentState = -1;
	private Direction currentDirection;
	private float animationCounter = 0f;
	private InputManager input;
	private float counter = 0f;
	private Vector2[] cellsAroundPlayer;
	private boolean[] allowedMovement;
	private TiledMapTileLayer data;

	private static final int IDLE_STATE = 0;
	private static final int WALKING_STATE = 1;
	private static final int RUNNING_STATE = 2;

	public Player(float x, float y, OrthographicCamera cam, TiledMapTileLayer col)
	{
		position = new Vector2(x, y);
		graphics = new PlayerGraphics(1f / 8f);
		batch = new SpriteBatch();
		camera = cam;
		currentState = IDLE_STATE;
		currentDirection = Direction.SOUTH;
		data = col;

		input = new InputManager(this);
		Gdx.input.setInputProcessor(input);

		allowedMovement = new boolean[4];
		cellsAroundPlayer = new Vector2[4];
		for(int i = 0; i < cellsAroundPlayer.length; i++) //thanks Riven!
		{
			cellsAroundPlayer[i] = new Vector2();
		}
	}

	public void render(float delta)
	{
		update(delta);

		switch (currentState)
		{
		case IDLE_STATE:
			graphics.currentTexture = graphics.idle[currentDirection.ordinal()];
			break;
		case WALKING_STATE:
			graphics.currentTexture = graphics.walkingAnimation[currentDirection.ordinal()].getKeyFrame(animationCounter, true);
			break;
		}

		float texWidth = 1f;
		float texHeight = (float)graphics.currentTexture.getRegionHeight() / (float)graphics.currentTexture.getRegionWidth();

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(graphics.currentTexture, position.x, position.y + 0.03125f, texWidth, texHeight);
		batch.end();
	}

	private void update(float delta)
	{
		animationCounter += delta;

		input.update();

		if (currentState == WALKING_STATE)
		{
			if (allowedMovement[currentDirection.ordinal()])
			{
				position.add(currentDirection.getVelocity(Global.SPEED));
			}

			if (shouldBeIdle(position.x) && shouldBeIdle(position.y))
			{
				updateSurroundingCells();

				if (!Gdx.input.isKeyPressed(currentDirection.getKey()))
				{
					//position.x = Math.round(position.x);
					//position.y = Math.round(position.y);
					currentState = IDLE_STATE;
				}
			}
		}
	}

	private boolean shouldBeIdle(float val)
	{
		int vali = (int)val;
		float rem = Math.abs(val - vali);
		return (rem <= Global.SPEED || (1f - rem <= Global.SPEED));
	}

	private void updateSurroundingCells()
	{
		cellsAroundPlayer[Direction.NORTH.ordinal()].set((int) this.getMiddleOriginX(), (int) (this.getMiddleOriginY() + 1f));
		cellsAroundPlayer[Direction.SOUTH.ordinal()].set((int) this.getMiddleOriginX(), (int) (this.getMiddleOriginY() - 1f));
		cellsAroundPlayer[Direction.EAST.ordinal()].set((int) (this.getMiddleOriginX() + 1f), (int) this.getMiddleOriginY());
		cellsAroundPlayer[Direction.WEST.ordinal()].set((int) (this.getMiddleOriginX() - 1f), (int) this.getMiddleOriginY());

		for (int i = 0; i < Direction.length; i++)
		{
			TiledMapTileLayer.Cell cell = data.getCell((int)cellsAroundPlayer[i].x, (int)cellsAroundPlayer[i].y);
			if (cell == null)
			{
				allowedMovement[i] = true;
			}
			else if (cell.getTile().getProperties().containsKey("collidable"))
			{
				allowedMovement[i] = false;
			}
			else
			{
				throw new RuntimeException("What?"); //debug
			}
		}
	}

	public void onKeyPressed(int keycode)
	{
		if (currentState == IDLE_STATE && isDirectionKey(keycode))
		{
			switch (keycode)
			{
			case KeyBinding.UP:
				currentDirection = Direction.NORTH;
				break;
			case KeyBinding.DOWN:
				currentDirection = Direction.SOUTH;
				break;
			case KeyBinding.LEFT:
				currentDirection = Direction.WEST;
				break;
			case KeyBinding.RIGHT:
				currentDirection = Direction.EAST;
				break;
			}

			currentState = WALKING_STATE;
		}
	}

	public void onKeyTapped(int keycode)
	{
		if (currentState == IDLE_STATE && isDirectionKey(keycode))
		{
			switch (keycode)
			{
			case KeyBinding.UP:
				currentDirection = Direction.NORTH;
				break;
			case KeyBinding.DOWN:
				currentDirection = Direction.SOUTH;
				break;
			case KeyBinding.LEFT:
				currentDirection = Direction.WEST;
				break;
			case KeyBinding.RIGHT:
				currentDirection = Direction.EAST;
				break;
			}
		}
	}

	private boolean isDirectionKey(int i)
	{
		return i == KeyBinding.DOWN || i == KeyBinding.LEFT || i == KeyBinding.RIGHT || i == KeyBinding.UP;
	}

	public float getMiddleOriginX()
	{
		return position.x + 0.5f;
	}

	public float getMiddleOriginY()
	{
		return position.y + 0.5f;
	}

	public Vector2 getPosition()
	{
		return position;
	}

	@Override
	public void dispose()
	{
		batch.dispose();
	}
}
