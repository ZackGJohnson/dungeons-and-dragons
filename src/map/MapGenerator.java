package map;

import java.util.*;
import entities.*;
import entities.bosses.*;

public class MapGenerator
{
	int _maxBosses = 7;
	int _bossQuantity = 0;
	public static MapGenerator _instance = null;

	private MapGenerator()
	{
	}

	public static MapGenerator getInstance()
	{
		if (_instance == null)
		{
			_instance = new MapGenerator();
		}
		return _instance;
	}

	public Map generateMap(int maxWidth, int maxHeight, int minimumRooms, int numEncounters)
	{
		if (minimumRooms > maxWidth * maxHeight)
		{
			throw new RuntimeException("Minimum rooms is too high for the max dimensions");
		}
		if (numEncounters > minimumRooms)
		{
			throw new RuntimeException("Number of encounters must be equal to or less than the number of minimum rooms");
		}
		Map generatedMap = new Map(maxWidth, maxHeight);
		generateExits(0, 0, generatedMap);
		checkMinimumRooms(generatedMap, minimumRooms);
		checkConnections(generatedMap);
		generateEncounters(generatedMap, numEncounters);

		return generatedMap;
	}

	/* Recursively generates a map in a tree-fashion. It then goes through the
	 * direction left, right, up, and down and randomly decides if it should
	 * create an exit in that direction. If a room already exists in that
	 * direction it simply sets the exit and moves on. If a room doesn't exist
	 * it recursively runs this method with the entranceDirection being the
	 * direction it is coming from relative to the new room. checkConnections()
	 * should be run after this is recursively run to make exits bi-directional. */
	private void generateExits(int x, int y, Map map)
	{
		Random randomGenerator = new Random();

		if (map.getRoom(x, y) == null)
		{
			map.setRoom(x, y, new Room());
		}

		if (x > 0 && !map.getRoom(x, y).getLeftExit())
		{
			map.getRoom(x, y).setLeftExit(randomGenerator.nextBoolean());
			if (map.getRoom(x, y).getLeftExit())
			{
				if (map.getRoom(x - 1, y) == null)
				{
					generateExits(x - 1, y, map);
				}
			}
		}

		if (x < map.getMaxWidth() - 1 && !map.getRoom(x, y).getRightExit())
		{
			map.getRoom(x, y).setRightExit(randomGenerator.nextBoolean());
			if (map.getRoom(x, y).getRightExit())
			{
				if (map.getRoom(x + 1, y) == null)
				{
					generateExits(x + 1, y, map);
				}
			}
		}

		if (y > 0 && !map.getRoom(x, y).getUpExit())
		{
			map.getRoom(x, y).setUpExit(randomGenerator.nextBoolean());
			if (map.getRoom(x, y).getUpExit())
			{
				if (map.getRoom(x, y - 1) == null)
				{
					generateExits(x, y - 1, map);
				}
			}
		}

		if (y < map.getMaxHeight() - 1 && !map.getRoom(x, y).getDownExit())
		{
			map.getRoom(x, y).setDownExit(randomGenerator.nextBoolean());
			if (map.getRoom(x, y).getDownExit())
			{
				if (map.getRoom(x, y + 1) == null)
				{
					generateExits(x, y + 1, map);
				}
			}
		}
	}

	/* Goes through every room in the map and makes sure the up/down/left/right
	 * exits are correct and rooms are connected. If a room has an exit going in
	 * one direction it makes the room in that direction has an exit back. */
	private void checkConnections(Map map)
	{
		for (int x = 0; x < map.getMaxWidth(); x++)
		{
			for (int y = 0; y < map.getMaxHeight(); y++)
			{
				if (map.getRoom(x, y) != null)
				{
					if (map.getRoom(x, y).getLeftExit())
					{
						map.getRoom(x - 1, y).setRightExit(true);
					}
					if (map.getRoom(x, y).getRightExit())
					{
						map.getRoom(x + 1, y).setLeftExit(true);
					}
					if (map.getRoom(x, y).getUpExit())
					{
						map.getRoom(x, y - 1).setDownExit(true);
					}
					if (map.getRoom(x, y).getDownExit())
					{
						map.getRoom(x, y + 1).setUpExit(true);
					}
				}
			}
		}
	}

	/* If there isn't enough rooms it goes through every room on the map and
	 * redetermines if it should put in more exits in that room. If so then it
	 * follows the same rules as seen in generateExits(). Not the most efficient
	 * algorithm but it generates better looking maps than other algorithms
	 * might. */
	private void checkMinimumRooms(Map map, int minimumRooms)
	{
		for (int x = 0; x < map.getMaxWidth(); x++)
		{
			for (int y = 0; y < map.getMaxHeight(); y++)
			{
				if (minimumRooms > map.getNumberOfRooms() && map.getRoom(x, y) != null)
				{
					generateExits(x, y, map);
				}
			}
		}
		if (minimumRooms > map.getNumberOfRooms())
		{
			checkMinimumRooms(map, minimumRooms);
		}
	}

	/* Adds all rooms into a list, picks randomly from that list, adds enemies
	 * to that room, and then removes that room from the list so it can't be
	 * selected twice. */
	private void generateEncounters(Map map, int numEncounters)
	{
		_bossQuantity = 0;
		ArrayList<Room> rooms = new ArrayList<Room>();
		Random rand = new Random();
		int randomIndex;

		for (int y = 0; y < map.getMaxHeight(); y++)
		{
			for (int x = 0; x < map.getMaxWidth(); x++)
			{
				if (map.getRoom(x, y) != null)
				{
					rooms.add(map.getRoom(x, y));
				}
			}
		}

		for (int i = 0; i < numEncounters; i++)
		{
			LinkedList<A_Villain> enemies = new LinkedList<A_Villain>();
			enemies = randomEncounter();

			randomIndex = rand.nextInt(rooms.size());
			rooms.get(randomIndex).setEnemies(enemies);
			rooms.remove(randomIndex);
		}
	}

	public LinkedList<A_Villain> randomEncounter()
	{
		LinkedList<A_Villain> enemies = new LinkedList<A_Villain>();

		Random random = new Random();
		int type = random.nextInt(50);

		if (type >= 0 && type < 8 || _bossQuantity >= _maxBosses)
		{// Encounter: all small putties
			// Rarity: 8 in 10: Common
			for (int i = 1; i < 5; i++)
			{
				A_Villain temp = new SmallPutty();
				temp.setName("Putty:" + i);
				enemies.add(temp);
			}
		}
		else if (type >= 8 && type < 10)
		{//Encounter: Boss battle with 2 big putties and 2 small putties
		 //Rarity: 2 in 10: Uncommon
			for (int i = 1; i < 3; i++)
			{
				A_Villain temp = new SmallPutty();
				temp.setName("Putty:" + i);
				enemies.add(temp);
			}
			for (int i = 1; i < 3; i++)
			{
				A_Villain temp = new BigPutty();
				temp.setName("Big Putty:" + i);
				enemies.add(temp);
			}
			
		}
		else if (type >= 10)
		{// Encounter: Boss Battle with 3 putties
			// Rarity: 1 in 10: Rare
			enemies.add(randomBoss());
			for (int i = 1; i < 4; i++)
			{
				A_Villain temp = new SmallPutty();
				temp.setName("Putty:" + i);
				enemies.add(temp);
			}
		}
		return enemies;
	}
	
	private A_Villain randomBoss()
	{
		Random random = new Random();
	
		A_Villain boss = new Boss(); 
		
		if(_bossQuantity == 0)
		{
			_bossQuantity++;
			boolean finalBoss = random.nextBoolean();
			if(finalBoss)
			{
				boss = new LordZed(boss);
				return boss;
			}
			else
			{
				boss = new IvanOoze(boss);	
				return boss;
			}
		}
		
		int type = random.nextInt(8);
		if(type == 0)
		{
			boss = new Goldar(boss);
		}
		else if(type == 1)
		{
			boss = new Finster(boss);
		}
		else if(type == 2)
		{
			boss = new Lipsyncher(boss);
		}
		else if(type == 3)
		{
			boss = new Mordant(boss);
		}
		else if(type == 4)
		{
			boss = new Rita(boss);
		}
		else if(type == 5)
		{
			boss = new Rito(boss);
		}
		else if(type == 6)
		{
			boss = new Scorpina(boss);
		}
		else if(type == 7)
		{
			boss = new Thrax(boss);
		}
		else
		{
			return randomBoss();
		}
		_bossQuantity++;
		return boss;
		
	}
}
