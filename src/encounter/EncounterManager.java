//Sawyer Zock
//
//
//
//

package encounter;

import items.*;
import map.Room;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;

import entities.*;

public final class EncounterManager
{

	private static EncounterManager _instance = null;
	private static LinkedList<A_Ranger> _rangers;
	private static A_Entity _curr;
	private static LinkedList<A_Villain> _enemies;
	private static LinkedList<A_Entity> _init;
	private static LinkedList<String> _items;
	private TextArea _textBox;
	private ScrollPane _textScroll;
	private int _points = 0;
	private Room _currentRoom;
	private String[] _itemList = {"ArmorUp", "AttackUp", "Bandage", "DamageUp", "DRUp", "HealthUp", "InitUp"};

	private EncounterManager()
	{
	}

	public static synchronized EncounterManager getInstance()
	{
		if (_instance == null)
		{
			_instance = new EncounterManager();
			_rangers = new LinkedList<A_Ranger>();
			_enemies = new LinkedList<A_Villain>();
			_init = new LinkedList();
			_items = new LinkedList<String>();
		}
		return _instance;
	}

	public void addRanger(A_Ranger creature)
	{
		_rangers.add(creature);
	}

	public void removeRanger(A_Ranger creature)
	{
		_rangers.remove(creature);
	}

	public void removeRangerAt(int index)
	{
		A_Ranger deadRanger = EncounterManager.getInstance().getRangers().get(index);
		_init.remove(deadRanger);
	}
	
	public void removeEnemyAt(int index)
	{
		A_Villain deadEnemy = EncounterManager.getInstance().getEnemies().get(index);
		_init.remove(deadEnemy);
	}
	
	public void replaceRanger(A_Ranger old, A_Ranger replacement)
	{
		replacement.setName(old.getName());
		int initiative = _init.indexOf(old);
		int order = _rangers.indexOf(old);
		_rangers.remove(old);
		_rangers.add(order, replacement);

		if(initiative >= 0)
		{
		_init.remove(initiative);
		_init.add(initiative, replacement);
		}
	}

	public void replaceEnemy(A_Villain old, A_Villain replacement)
	{
		replacement.setName(old.getName());
		int initiative = _init.indexOf(old);
		int order = _enemies.indexOf(old);
		_enemies.remove(old);
		_enemies.add(order, replacement);

		_init.remove(initiative);
		_init.add(initiative, replacement);
	}

	public void addEnemy(A_Villain creature)
	{
		_enemies.add(creature);
	}

	public void removeEnemy(A_Villain creature)
	{
		_enemies.remove(creature);
	}

	public void loot()
	{
		addItem(_itemList[(RollManager.getInstance().roll("1d" + _itemList.length + "+0"))]);
	}
	
	public void addEncounter(LinkedList<A_Ranger> rangers, LinkedList<A_Villain> enemies)
	{
		_rangers = rangers;
		_enemies = enemies;
	}
	
	public void addRangers(LinkedList<A_Ranger> rangers)
	{
		_rangers = rangers;
	}

	public void addEncounter(LinkedList<A_Villain> enemies)
	{
		_enemies = enemies;
	}

	public String addItem(String itemName)
	{
		//If you want to print out to textbox use the return to get the name maybe
		//appendLineToTextBox("You found:" + itemName);
		_items.add(itemName);
		return itemName;
	}

	public void giveItem(int index, String itemName)
	{
		A_Ranger ranger = EncounterManager.getInstance().getRangers().get(index);
		A_Ranger modified = EncounterManager.getInstance().getRangers().get(index);
		_items.remove(itemName);
		itemName = itemName.toLowerCase();
		itemName = itemName.trim();
		
		switch (itemName)
		{
			case "armorup":
			{
				modified = new ArmorUp(ranger);
				EncounterManager.getInstance().replaceRanger(ranger, modified);
				break;
			}
			case "attackup":
			{
				modified = new AttackUp(ranger);
				EncounterManager.getInstance().replaceRanger(ranger, modified);
				break;
			}
			case "damageup":
			{
				modified = new DamageUp(ranger);
				EncounterManager.getInstance().replaceRanger(ranger, modified);
				break;
			}
			case "drup":
			{
				modified = new DRUp(ranger);
				EncounterManager.getInstance().replaceRanger(ranger, modified);
				break;
			}
			case "healthup":
			{
				modified = new HealthUp(ranger);
				EncounterManager.getInstance().replaceRanger(ranger, modified);
				break;
			}
			case "initup":
			{
				modified = new InitUp(ranger);
				EncounterManager.getInstance().replaceRanger(ranger, modified);
				break;
			}
			case "bandage":
			{
				modified = new Bandage(ranger);
				EncounterManager.getInstance().replaceRanger(ranger, modified);
				break;
			}
			default:
			{
				appendLineToTextBox("Invalid item name, please check");
			}
			

		}
	}


	public void appendLineToTextBox(String string)
	{
		_textBox.appendText("\n" + string);
		_textScroll.setScrollPercentY(100);
	}
	
	public void initiative()
	{
		_init.clear();
		for (A_Ranger ranger : _rangers)
			_init.add(ranger);
		for (A_Villain villain : _enemies)
			_init.add(villain);
		Collections.sort(_init);
		_curr = _init.getFirst();
			
			
		
	}
	
	public A_Entity getCurr()
	{
		return _curr;
	}
	
	public A_Entity nextEntity()
	{
		int i = _init.indexOf(_curr);
		if(i >= _init.size() - 1)
			i = 0;
		if(_init.size() > 1)
			_curr =  _init.get(i + 1);
		
		return _curr;
		
	}
	

	public LinkedList<A_Villain> getEnemies()
	{
		return _enemies;
	}

	public LinkedList<A_Ranger> getRangers()
	{
		return _rangers;
	}

	public boolean enemiesAreAlive()
	{
		for (A_Villain enemy : _enemies)
		{
			if (enemy.getHealth() > 0)
				return true;
		}
		//Encounter win, add points
		for (A_Villain enemy : _enemies)
		{
			_points += enemy.getPoint();
		}
		
		
		return false;
	}

	public boolean rangersAreAlive()
	{
		for (A_Ranger ranger : _rangers)
		{
			if (ranger.getHealth() > 0)
				return true;
		}
		return false;
	}

	public String stats()
	{
		String result = "";
		if (_rangers != null)
		{
			for (A_Ranger ranger : _rangers)
			{
				result = result + ranger.getStats() + "\n";
			}
		}

		if (_enemies != null)
		{
			for (A_Villain enemy : _enemies)
			{
				if(enemy != null)
					result = result + enemy.getStats() + "\n";
				else
					result = result + "Enemy is null";
			}
		}
		else
			result = result + "_enemies is null, were the rooms properly initilized?\n";
		return result;
	}
	
	
	public String rangerStats()
	{
		String result = "";
		if (_rangers != null)
		{
			for (A_Ranger ranger : _rangers)
			{
				result = result + ranger.getStats() + "\n";
			}
		}

		return result;
	}
	
	
	public LinkedList<String> getItems()
	{
		return _items;
	}
	
	public String[] getItemsAsArray()
	{
		String[] temp = new String[EncounterManager.getInstance().getItems().size()];
		for (int i = 0; i < EncounterManager.getInstance().getItems().size(); i++)
		{
			temp[i] = EncounterManager.getInstance().getItems().get(i);
		}
		
		return temp;
	}
	
	public int getPoints()
	{
		return _points;
	}
	
	public void setCurrentRoom(Room room)
	{
		// Give the old room an empty party list.
		if (_currentRoom != null)
		{
			_currentRoom.setParty(new LinkedList<A_Ranger>());
		}
		_currentRoom = room;
		_currentRoom.setParty(_rangers);
	}
	
	public Room getCurrentRoom()
	{
		return _currentRoom;
	}
}
