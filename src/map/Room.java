package map;

import entities.*;

import java.util.LinkedList;

import encounter.*;

public class Room
{
	private boolean _upExit, _rightExit, _downExit, _leftExit;
	private LinkedList<A_Villain> _enemies;
	
	public Room()
	{
		_enemies = new LinkedList<A_Villain>();
	}

	/*
	 * Just a placeholder for now. The idea will be that the room will store what enemies
	 * are in the room, and then when the player moves into that room it will add
	 * the enemies to the encounter manager and proceed with the encounter.
	 */
	public void doEncounter()
	{
		for (int i = 0; i < _enemies.size(); i++)
		{
			EncounterManager.getInstance().addEnemy(_enemies.get(i));
		}

		EncounterManager.getInstance().round();
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
	
	public boolean hasEncounter()
	{
		return !_enemies.isEmpty();
	}
}
