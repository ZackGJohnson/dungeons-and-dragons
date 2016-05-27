//Sawyer Zock
//
//
//
//

package encounter;

import items.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import entities.*;

public final class EncounterManager
{

	private static EncounterManager _instance = null;
	private static LinkedList<A_Ranger> _rangers;
	private static LinkedList<A_Villain> _enemies;
	private static LinkedList<A_Entity> _init;
	private static LinkedList<String> _items;

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

	public void replaceRanger(A_Ranger old, A_Ranger replacement)
	{
		int initiative = _init.indexOf(old);
		int order = _rangers.indexOf(old);
		_rangers.remove(old);
		_rangers.add(order, replacement);

		_init.remove(initiative);
		_init.add(initiative, replacement);
	}

	public void replaceEnemy(A_Villain old, A_Villain replacement)
	{
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

	public void addEncounter(LinkedList<A_Ranger> rangers, LinkedList<A_Villain> enemies)
	{
		_rangers = rangers;
		_enemies = enemies;
	}

	public void addEncounter(LinkedList<A_Villain> enemies)
	{
		_enemies = enemies;
	}

	public void addItem(String itemName)
	{
		System.out.println("You found:" + itemName);
		_items.add(itemName);
	}

	public void giveItem(int index, String itemName)
	{
		A_Ranger ranger = EncounterManager.getInstance().getRangers().get(index);
		A_Ranger modified = EncounterManager.getInstance().getRangers().get(index);
		itemName = itemName.toLowerCase();
		itemName = itemName.trim();
		switch (itemName)
		{
			case "armorup":
			{
				modified = new ArmorUp(ranger);
				EncounterManager.getInstance().replaceRanger(ranger, modified);
			}
			case "attackup":
			{
				modified = new AttackUp(ranger);
				EncounterManager.getInstance().replaceRanger(ranger, modified);
			}
			case "damageup":
			{
				modified = new DamageUp(ranger);
				EncounterManager.getInstance().replaceRanger(ranger, modified);
			}
			case "drup":
			{
				modified = new DRUp(ranger);
				EncounterManager.getInstance().replaceRanger(ranger, modified);
			}
			case "healthup":
			{
				modified = new HealthUp(ranger);
				EncounterManager.getInstance().replaceRanger(ranger, modified);
			}
			case "initup":
			{
				modified = new InitUp(ranger);
				EncounterManager.getInstance().replaceRanger(ranger, modified);
			}
			case "bandage":
			{
				modified = new Bandage(ranger);
				EncounterManager.getInstance().replaceRanger(ranger, modified);
			}
			default:
			{
				System.out.println("Invalid item name, please check");
			}

		}
	}

	public void useItem()
	{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int itemIndex = 0;
		int rangerIndex = 0;
		
		try
		{
			for (int i = 0; i < _items.size(); i++)
			{
				System.out.printf("Type %d to use %s on a ranger", i, _items.get(i));
				itemIndex = (Integer.parseInt(input.readLine())) - 1;
			}
			
			for (int i = 0; i < _rangers.size(); i++)
			{
				System.out.printf("Type %d to use %s on ranger %s", i, _items.get(itemIndex), _rangers.get(i).getName());
				rangerIndex = (Integer.parseInt(input.readLine())) - 1;
			}
			giveItem(rangerIndex, _items.get(itemIndex));
			
		}
		catch (NumberFormatException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try
		{
			input.close();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void round()
	{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		for (A_Ranger ranger : _rangers)
			_init.add(ranger);
		for (A_Villain villain : _enemies)
			_init.add(villain);
		Collections.sort(_init);

		if (_items.size() > 0)
		{
			System.out.println("You have items available, enter 1 if you would like to use one");
			try
			{
				if (Integer.parseInt(input.readLine()) == 1)
				{
					useItem();

				}
			}
			catch (NumberFormatException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		
		for (int i = 0; i < _init.size(); i++)
		{
			_init.get(i).turn();

		}

		for (A_Ranger ranger : _rangers)
		{
			if (!ranger.isAlive())
			{
				_rangers.remove(ranger);
			}
		}
		for (A_Villain villain : _enemies)
		{
			if (!villain.isAlive())
			{
				_enemies.remove(villain);
			}
		}

		_init.clear();
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

	public void stats()
	{
		if (_rangers != null)
		{
			for (A_Ranger ranger : _rangers)
			{
				System.out.println(ranger.getStats());
			}
		}

		if (_enemies != null)
		{
			for (A_Ranger ranger : _rangers)
			{
				System.out.println(ranger.getStats());
			}
		}
	}
}
