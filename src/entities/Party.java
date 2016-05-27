package entities;

import java.util.ArrayList;
import java.util.LinkedList;

import map.Room;

public class Party
{
	private Room _currentRoom;
	private LinkedList<A_Ranger> _rangers;
	private ArrayList<A_RangerDecorator> _items;
	
	public Party(LinkedList<A_Ranger> rangers, Room initialRoom)
	{
		_items = new ArrayList<A_RangerDecorator>();
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
	
	public ArrayList<A_RangerDecorator> getItems()
	{
		return _items;
	}
	
	public A_RangerDecorator[] getItemsAsArray()
	{
		A_RangerDecorator[] temp = new A_RangerDecorator[_items.size()];
		for (int i = 0; i < _items.size(); i++)
		{
			temp[i] = _items.get(i);
		}
		
		return temp;
	}
}
