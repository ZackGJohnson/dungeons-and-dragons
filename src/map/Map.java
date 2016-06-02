package map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import encounter.EncounterManager;
import gui.DungeonGame;

public class Map
{
	private Room[][] _rooms;
	public static final int ROOM_SIZE = DungeonGame.TEXTURE_SIZE * 7;
	public static final int HALLWAY_SIZE = DungeonGame.TEXTURE_SIZE * 0;
	public static final int ROOM_SPACE = ROOM_SIZE + (HALLWAY_SIZE * 2);
	
	public Map(int maxWidth, int maxHeight)
	{
		_rooms = new Room[maxWidth][maxHeight];
	}
	
	/*
	 * Returns a room at the given coordinates. It will return
	 * null if a room does not exist at those coordinates.
	 * It will throw an out of bounds exception if the coordinates
	 * are outside of the map.
	 */
	public Room getRoom(int x, int y)
	{
		if (x < 0 || y < 0 || x >= _rooms.length || y >= _rooms[x].length)
		{
			throw new IndexOutOfBoundsException();
		}
		return _rooms[x][y];
	}
	
	public void setRoom(int x, int y, Room room)
	{
		if (x < 0 || y < 0 || x >= _rooms.length || y >= _rooms[x].length)
		{
			throw new IndexOutOfBoundsException();
		}
		_rooms[x][y] = room;
	}
	
	public void displayMap(SpriteBatch batch)
	{
		for (int y = 0; y < _rooms[0].length; y++)
		{
			for (int x = 0; x < _rooms.length; x++)
			{
				if (this.getRoom(x, y) != null)
				{
					_rooms[x][y].draw(x * ROOM_SPACE, y * ROOM_SPACE, batch);
				}
			}
		}
	}
	
	/*
	 * Returns the number of generated rooms.
	 */
	public int getNumberOfRooms()
	{
		int rooms = 0;
		for (int y = 0; y < _rooms[0].length; y++)
		{
			for (int x = 0; x < _rooms.length; x++)
			{
				if (_rooms[x][y] != null)
				{
					rooms++;
				}
			}
		}
		return rooms;
	}
	
	public int getMaxWidth()
	{
		return _rooms.length;
	}
	
	public int getMaxHeight()
	{
		return _rooms[0].length;
	}
	
	/*
	 * Translates the mouse coordinates to the location of a room. If the target room
	 * has an exit in the correct direction and is next to the parties current room
	 * then it moves the party to the target room.
	 * Return true if the target room was a valid move.
	 */
	public boolean moveParty(float mouseX, float mouseY)
	{
		Room currentRoom = EncounterManager.getInstance().getCurrentRoom();
		float roomX = mouseX / ROOM_SPACE;
		float roomY = mouseY / ROOM_SPACE;
		if (roomX >= 0 && roomY >= 0 && roomX < _rooms.length && roomY < _rooms[(int)roomX].length && _rooms[(int)roomX][(int)roomY] != null)
		{
			if (_rooms[(int)roomX][(int)roomY].getUpExit() && _rooms[(int)roomX][(int)roomY-1] == currentRoom)
			{
				EncounterManager.getInstance().setCurrentRoom(_rooms[(int)roomX][(int)roomY]);
				return true;
			}
			if (_rooms[(int)roomX][(int)roomY].getDownExit() && _rooms[(int)roomX][(int)roomY+1] == currentRoom)
			{
				EncounterManager.getInstance().setCurrentRoom(_rooms[(int)roomX][(int)roomY]);
				return true;
			}
			if (_rooms[(int)roomX][(int)roomY].getLeftExit() && _rooms[(int)roomX-1][(int)roomY] == currentRoom)
			{
				EncounterManager.getInstance().setCurrentRoom(_rooms[(int)roomX][(int)roomY]);
				return true;
			}
			if (_rooms[(int)roomX][(int)roomY].getRightExit() && _rooms[(int)roomX+1][(int)roomY] == currentRoom)
			{
				EncounterManager.getInstance().setCurrentRoom(_rooms[(int)roomX][(int)roomY]);
				return true;
			}
		}
		return false;
	}
}
