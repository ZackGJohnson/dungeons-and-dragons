package entities;

import java.util.LinkedList;

import map.Room;

public class Party
{
	private Room _currentRoom;
	private LinkedList<A_Ranger> _rangers;
	
	public Party(LinkedList<A_Ranger> rangers, Room initialRoom)
	{
		_rangers = rangers;
		_currentRoom = initialRoom;
		_currentRoom.setParty(_rangers);
	}

	public void setCurrentRoom(Room room)
	{
		// Give the old room an empty party list.
		_currentRoom.setParty(new LinkedList<A_Ranger>());
		_currentRoom = room;
		_currentRoom.setParty(_rangers);
	}
	
	public Room getCurrentRoom()
	{
		return _currentRoom;
	}
	
	public LinkedList<A_Ranger> getRangers()
	{
		return _rangers;
	}
}
