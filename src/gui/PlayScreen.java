package gui;

import java.util.LinkedList;
import java.util.Random;

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
import encounter.encounterRunnable;

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
		_map = MapGenerator.getInstance().generateMap(5, 5, 15, 3);
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
		
		//Print Test ###
		printStats();
		
		
		//This is just my test shit, can be removed later
		A_Villain v1 = new BigPutty();
		A_Villain v2 = new BigPutty();
		EncounterManager.getInstance().addEnemy(v1);
		EncounterManager.getInstance().addEnemy(v2);
		
		//runEncounter();
		//Seems to be an issue with the gui while encounter is running, attempting to use threading
		//Won't need to once buttons exist to handle user input, as it can run inside here.
		//Threading test
		
		//encounterRunnable testThread = new encounterRunnable(_textBox, _textScroll);
		//testThread.run();
		
		//The threading, it doez noething!
		
		//I assume much of my code from EncounterManager will need to be moved to either PlayScreen or Room
		//Also I can't find Game.java, where is it?
		
		//I marked everything that needs a button with triple ### so it is easier to find
		//We should probably just sit down together on tuesday so I can point things out and modify
		//my code while you add the buttons where I show you
		
		//Are we going to fight on the map screen or in a separate battle screen?
		
		
	}
	
	//Move to room?
	public void runEncounter()
	{
		while (EncounterManager.getInstance().enemiesAreAlive() && EncounterManager.getInstance().rangersAreAlive())
		{
			EncounterManager.getInstance().round(_textBox, _textScroll);
		}
		if(!EncounterManager.getInstance().enemiesAreAlive())
			appendLineToTextBox("All enemies defeated!");
		else if(!EncounterManager.getInstance().rangersAreAlive())
			appendLineToTextBox("Mission Failure!");
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
