package map;

import entities.*;
import gui.DungeonGame;

import java.util.LinkedList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import encounter.*;

public class Room
{
	private boolean _upExit, _rightExit, _downExit, _leftExit;
	private LinkedList<A_Ranger> _party;
	private LinkedList<A_Villain> _enemies;
	public static Texture _wallTexture;
	public static Texture _floorTexture;
	
	public Room()
	{
		_enemies = new LinkedList<A_Villain>();
		_party = new LinkedList<A_Ranger>();
	}

	/*
	 * Just a placeholder for now. The idea will be that the room will store what enemies
	 * are in the room, and then when the player moves into that room it will add
	 * the enemies to the encounter manager and proceed with the encounter.
	 */
	
	/*
	 * Draws the room with startX and startY being the top left corner.
	 */
	public void draw(int startX, int startY, SpriteBatch batch)
	{
		int drawX;
		int drawY;
		
		for (int y = 0; y < 7; y++)
		{
			for (int x = 0; x < 7; x++)
			{
				drawX = startX + (DungeonGame.TEXTURE_SIZE * x);
				drawY = startY + (DungeonGame.TEXTURE_SIZE * y);
				
				if (y == 0 && (x != 3 || !_upExit))
				{
					batch.draw(_wallTexture, drawX, drawY, DungeonGame.TEXTURE_SIZE, DungeonGame.TEXTURE_SIZE);
				}
				else if (y == 6 && (x != 3 || !_downExit))
				{
					batch.draw(_wallTexture, drawX, drawY, DungeonGame.TEXTURE_SIZE, DungeonGame.TEXTURE_SIZE);
				}
				else if (x == 0 && (y != 3 || !_leftExit))
				{
					batch.draw(_wallTexture, drawX, drawY, DungeonGame.TEXTURE_SIZE, DungeonGame.TEXTURE_SIZE);
				}
				else if (x == 6 && (y != 3 || !_rightExit))
				{
					batch.draw(_wallTexture, drawX, drawY, DungeonGame.TEXTURE_SIZE, DungeonGame.TEXTURE_SIZE);
				}
				else
				{
					batch.draw(_floorTexture, drawX, drawY, DungeonGame.TEXTURE_SIZE, DungeonGame.TEXTURE_SIZE);
				}
			}
		}
		// Draws a red ranger sprite near the center of the room if the party is at this location.
		if (!_party.isEmpty())
		{
			batch.draw(EncounterManager.getInstance().getRangers().getFirst().getTexture(), startX + (Map.ROOM_SIZE / 2), startY + (Map.ROOM_SIZE / 2));
		}
		if (this.hasEncounter())
		{
			batch.draw(_enemies.getFirst().getTexture(), startX + (Map.ROOM_SIZE / 2), startY + (Map.ROOM_SIZE / 2));
		}
	}
	
	public boolean getUpExit()
	{
		return _upExit;
	}
	
	public boolean getRightExit()
	{
		return _rightExit;
	}
	
	public boolean getLeftExit()
	{
		return _leftExit;
	}
	
	public boolean getDownExit()
	{
		return _downExit;
	}
	
	public void setUpExit(boolean exit)
	{
		_upExit = exit;
	}
	
	public void setRightExit(boolean exit)
	{
		_rightExit = exit;
	}
	
	public void setLeftExit(boolean exit)
	{
		_leftExit = exit;
	}
	
	public void setDownExit(boolean exit)
	{
		_downExit = exit;
	}

	public LinkedList<A_Villain> getEnemies()
	{
		return _enemies;
	}

	public void setEnemies(LinkedList<A_Villain> enemyList)
	{
		_enemies = enemyList;
	}
	
	public void setParty(LinkedList<A_Ranger> rangerList)
	{
		_party = rangerList;
	}
	
	// Returns true if there is both enemies in the room and at least one of them
	// is alive.
	public boolean hasEncounter()
	{
		for (int i = 0; i < _enemies.size(); i++)
		{
			if (_enemies.get(i).isAlive())
			{
				return true;
			}
		}
		return false;
	}
}
