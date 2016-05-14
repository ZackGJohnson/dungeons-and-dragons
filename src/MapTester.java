import map.Map;
import map.MapGenerator;

public class MapTester
{
	public static void main(String[] args)
	{
		System.out.println("Max Width: 5 | Max Height: 5 | Minimum Rooms: 10 | Encounters: 5");
		Map map = MapGenerator.getInstance().generateMap(5, 5, 10, 5);
		//map.displayMap();
		System.out.println("Actual Rooms: " + map.getNumberOfRooms());
		System.out.println("=========================");
		
		System.out.println("Max Width: 10 | Max Height: 10 | Minimum Rooms: 35 | Encounters: 15");
		map = MapGenerator.getInstance().generateMap(10, 10, 35, 15);
		//map.displayMap();
		System.out.println("Actual Rooms: " + map.getNumberOfRooms());
		System.out.println("Done");
	}
}
