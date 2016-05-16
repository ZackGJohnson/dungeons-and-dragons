package gui;

import java.util.LinkedList;

import entities.A_Ranger;
import entities.Party;
import entities.Red;
import map.Map;
import map.MapGenerator;

public class PlayScreen extends A_GameScreen
{
	private Map _map;
	private Party _party;
	
	public PlayScreen(DungeonGame game)
	{
		super(game);
		A_Ranger testRanger = new Red();
		LinkedList<A_Ranger> rangers = new LinkedList<A_Ranger>();
		_map = MapGenerator.getInstance().generateMap(5, 5, 15, 3);
		rangers.add(testRanger);
		_party = new Party(rangers, _map.getRoom(0, 0));
		// Camera is adjusted to be centered on a room.
		_camera.position.set(Map.ROOM_SPACE / 2, Map.ROOM_SPACE / 2,0);
	}
	
	public void render(float delta)
	{
		super.render(delta);
		_game.getBatch().begin();
    	_map.displayMap(_game.getBatch());
    	_game.getBatch().end();
	}
	
	/*
	 * Tries to move the party to a room clicked on by the player. If successful
	 * it also moves the camera by setting the camera back to the starting/original position
	 * then calculating the necessary camera coordinates for the clicked on room.
	 */
	public void click(int mouseX, int mouseY)
	{
		if (_map.moveParty(mouseX, mouseY, _party))
		{
			_camera.translate(-_camera.position.x + (Map.ROOM_SPACE / 2), -_camera.position.y + (Map.ROOM_SPACE / 2));
			_camera.translate((mouseX / Map.ROOM_SPACE) * Map.ROOM_SPACE, (mouseY / Map.ROOM_SPACE) * Map.ROOM_SPACE, 0);
		}
	}
}
