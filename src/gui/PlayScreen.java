package gui;

import map.Map;
import map.MapGenerator;

public class PlayScreen extends A_GameScreen
{
	private Map _map;
	
	public PlayScreen(DungeonGame game)
	{
		super(game);
		_map = MapGenerator.getInstance().generateMap(10, 10, 10, 3);
	}
	
	public void render(float delta)
	{
		super.render(delta);
		_game.getBatch().begin();
    	_map.displayMap(_game.getBatch());
    	_game.getBatch().end();
	}
}
