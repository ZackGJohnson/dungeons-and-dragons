package gui;

import java.util.LinkedList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;

import entities.A_Ranger;
import entities.A_Villain;
import entities.BigPutty;
import entities.Party;
import entities.Red;
import map.Map;
import map.MapGenerator;
import encounter.EncounterManager;

public class PlayScreen extends A_GameScreen
{
	private Map _map;
	private Party _party;
	Table _playScreenUI;
	TextArea _textBox;
	// The total amount of lines the textBox will store
	int _textBoxMaxLines = 10;
	ScrollPane _textScroll;
	
	public PlayScreen(DungeonGame game)
	{
		super(game);
		A_Ranger testRanger = new Red();
		LinkedList<A_Ranger> rangers = new LinkedList<A_Ranger>();
		_map = MapGenerator.getInstance().generateMap(8, 8, 20, 15);
		rangers.add(testRanger);
		_party = new Party(rangers, _map.getRoom(0, 0));
		// Camera is adjusted to be centered on rooms.
		_camera.position.set(Map.ROOM_SPACE / 2, Map.ROOM_SPACE / 2,0);
		
		_playScreenUI = new Table();
		_playScreenUI.setFillParent(true);
		_stage.addActor(_playScreenUI);
		_textBox = new TextArea("", _skin);
		_textBox.setPrefRows(_textBoxMaxLines);
		_textBox.clearListeners();
		_textScroll = new ScrollPane(_textBox, _skin);
		_textScroll.setFadeScrollBars(false);
		// Calculates the height of 3 lines of text
		float _textBoxHeight = _textBox.getStyle().font.getLineHeight() * 3 + _textBox.getStyle().background.getBottomHeight() * 6;
		_playScreenUI.add(_textScroll).expand().fillX().maxHeight(_textBoxHeight).bottom();
		// Makes the text box start printing from the bottom instead of the top
		for (int i = 0; i < _textBoxMaxLines; i++)
		{
			_textBox.appendText("\n");
		}
		
		
		
		
		
	}
	
	public void render(float delta)
	{
		super.render(delta);
		_game.getBatch().begin();
    	_map.displayMap(_game.getBatch());
    	_game.getBatch().end();
    	_stage.act(delta);
    	_stage.draw();
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
		
		if (_party.getCurrentRoom().hasEncounter())
		{
			
			_game.switchScreens(new BattleScreen(_game, _party, _party.getCurrentRoom().getEnemies(), this));
			
		}

		printStats();
		
	}
	
	public void printStats()
	{//Prints the stats to text box, attach this to a button  ###
		appendLineToTextBox(EncounterManager.getInstance().stats());
	}
	public void createNewParty(LinkedList<A_Ranger> rangers)
	{
		_party = new Party(rangers, _map.getRoom(0, 0));
	}
	
	public void appendLineToTextBox(String string)
	{
		_textBox.appendText("\n" + string);
		_textScroll.setScrollPercentY(100);
	}
}
