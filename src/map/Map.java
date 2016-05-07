package map;

public class Map
{
	private Room[][] _rooms;
	
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
	
	/*
	 * This method prints a graphical representation of the map in the console.
	 * It is purely for testing purposes.
	 * Asterisks represent rooms without encounters. Xs represent rooms with encounters.
	 * Lines represent hallways.
	 */
	public void displayMap()
	{
		String topLine = "";
		String midLine = "";
		String bottomLine = "";
		for (int y = 0; y < _rooms[0].length; y++)
		{
			for (int x = 0; x < _rooms.length; x++)
			{
				if (this.getRoom(x, y) != null)
				{
					if (this.getRoom(x, y).getUpExit())
					{
						topLine += " | ";
					}
					else
					{
						topLine += "   ";
					}
					if (this.getRoom(x, y).getLeftExit())
					{
						midLine += "-";
					}
					else
					{
						midLine += " ";
					}
					if (_rooms[x][y].hasEncounter())
					{
						midLine += "X";
					}
					else
					{
						midLine += "*";
					}
					if (this.getRoom(x, y).getRightExit())
					{
						midLine += "-";
					}
					else
					{
						midLine += " ";
					}
					if (this.getRoom(x, y).getDownExit())
					{
						bottomLine += " | ";
					}
					else
					{
						bottomLine += "   ";
					}
				}
				else
				{
					topLine += "   ";
					midLine += "   ";
					bottomLine += "   ";
				}
			}
			System.out.println(topLine);
			topLine = "";
			System.out.println(midLine);
			midLine = "";
			System.out.println(bottomLine);
			bottomLine = "";
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
}
