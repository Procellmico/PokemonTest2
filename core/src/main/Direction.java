package main;

import com.badlogic.gdx.math.Vector2;

public class Direction
{
	public static final Direction NORTH = new Direction(0, 0f, 1f, KeyBinding.UP);
	public static final Direction SOUTH = new Direction(1, 0f, -1f, KeyBinding.DOWN);
	public static final Direction EAST = new Direction(2, 1f, 0f, KeyBinding.RIGHT);
	public static final Direction WEST = new Direction(3, -1f, 0f, KeyBinding.LEFT);
	public static final int length = 4; //dat hardcoded value though

	private final Vector2 velocity;
	private final int ID;
	private final int key;

	private Direction(int ID1, float x, float y, int key1)
	{
		velocity = new Vector2(x, y);
		ID = ID1;
		key = key1;
	}

	public int getKey()
	{
		return key;
	}

	public Vector2 getVelocity(float speed)
	{
		return velocity.cpy().scl(speed, speed);
	}

	public int ordinal()
	{
		return ID;
	}
}
