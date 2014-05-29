package main;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class PlayerGraphics
{
	public Animation[] walkingAnimation;
	public TextureRegion[] idle;
	public TextureRegion currentTexture;

	public PlayerGraphics(float frameTime)
	{
		walkingAnimation = new Animation[4];
		walkingAnimation[Direction.NORTH.ordinal()] = new Animation(frameTime, getFrames(Art.playerUpWalk, 2, 2));
		walkingAnimation[Direction.SOUTH.ordinal()] = new Animation(frameTime, getFrames(Art.playerDownWalk, 2, 2));
		walkingAnimation[Direction.EAST.ordinal()] = new Animation(frameTime, getFrames(Art.playerRightWalk, 2, 2));
		walkingAnimation[Direction.WEST.ordinal()] = new Animation(frameTime, getFrames(Art.playerLeftWalk, 2, 2));

		idle = getFrames(Art.playerIdle, 2, 2);
	}

	/*
	 * Taken from the Libgdx wiki
 	 */
	private TextureRegion[] getFrames(Texture sheet, int frameCols, int frameRows)
	{
		TextureRegion[] output = new TextureRegion[frameCols * frameRows];
		TextureRegion[][] tmp = TextureRegion.split(sheet, sheet.getWidth() / frameCols, sheet.getHeight() / frameRows);
		int index = 0;
		for (int i = 0; i < frameRows; i++)
		{
			for (int j = 0; j < frameCols; j++)
			{
				output[index++] = tmp[i][j];
			}
		}

		return output;
	}
}
