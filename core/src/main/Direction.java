package main;

import com.badlogic.gdx.math.Vector2;

public class Direction
{
	public static final Direction NORTH = new Direction(0, 0f, 1f);
	public static final Direction SOUTH = new Direction(1, 0f, -1f);
	public static final Direction EAST = new Direction(2, 1f, 0f);
	public static final Direction WEST = new Direction(3, -1f, 0f);
	public static int length = 0; //dat hardcoded value though

	private final Vector2 velocity;
	private final int ID;

	private Direction(int ID1, float x, float y)
	{
		velocity = new Vector2(x, y);
		ID = ID1;
		length++;
	}

	public Vector2 getVelocity(float speed)
	{
		return velocity.cpy().scl(speed, speed);
	}

	public int getNum()
	{
		return ID;
	}
}
