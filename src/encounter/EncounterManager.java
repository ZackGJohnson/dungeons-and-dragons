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

import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;

import entities.*;

public final class EncounterManager
{

	private static EncounterManager _instance = null;
	private static LinkedList<A_Ranger> _rangers;
	private static A_Ranger _curr;
	private static LinkedList<A_Villain> _enemies;
	private static LinkedList<A_Entity> _init;
	private static LinkedList<String> _items;
	private TextArea _textBox;
	private ScrollPane _textScroll;
	private int _points = 0;

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
				appendLineToTextBox("Invalid item name, please check");
			}

		}
	}

	public void useItem()
	{//Replace with buttons, this will probably be moved to PlayScreen? ###
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int itemIndex = 0;
		int rangerIndex = 0;
		
		try
		{
			for (int i = 0; i < _items.size(); i++)
			{
				System.out.printf("Type %d to use %s on a ranger", i, _items.get(i));
				//Any parseInt should be swapped with a button ###
				itemIndex = (Integer.parseInt(input.readLine())) - 1;
			}
			
			for (int i = 0; i < _rangers.size(); i++)
			{
				System.out.printf("Type %d to use %s on ranger %s", i, _items.get(itemIndex), _rangers.get(i).getName());
				//Any parseInt should be swapped with a button ###
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

	public void appendLineToTextBox(String string)
	{
		_textBox.appendText("\n" + string);
		_textScroll.setScrollPercentY(100);
	}
	
	public void initiative()
	{
		for (A_Ranger ranger : _rangers)
			_init.add(ranger);
		for (A_Villain villain : _enemies)
			_init.add(villain);
		Collections.sort(_init);
		Collections.sort(_rangers);
		_curr = _rangers.getFirst();
			
			
		
	}
	
	public A_Ranger getCurr()
	{
		return _curr;
	}
	
	public A_Ranger nextRanger()
	{
		int i = _rangers.indexOf(_curr);
		if(i >= _rangers.size() - 1)
			i = 0;
		_curr =  _rangers.get(i + 1);
		
		return _curr;
		
	}
	
	
	public void round(TextArea textBox, ScrollPane textScroll)
	{
		_textBox = textBox;
		_textScroll = textScroll;
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		initiative();
			
			
		if (_items.size() > 0)
		{
			//Rather than prompting once a round, this should be attached to a button ###
			appendLineToTextBox("You have items available, enter 1 if you would like to use one");
			try
			{
				//Any parseInt should be swapped with a button ###
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
}
