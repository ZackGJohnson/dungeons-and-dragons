package gui;

import java.util.LinkedList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;

import db.DataBaseRead;
import entities.A_Ranger;
import entities.A_Villain;
import entities.BigPutty;
import entities.Red;
import map.Map;
import map.MapGenerator;
import encounter.EncounterManager;

public class PlayScreen extends A_GameScreen
{
	private Map _map;
	Table _playScreenUI;
	TextButton _statsButton;
	TextArea _textBox;
	// The total amount of lines the textBox will store
	int _textBoxMaxLines = 10;
	ScrollPane _textScroll;
	
	Dialog _statsDialog;
	Label _statsLabel;
	TextButton _statsCloseButton;
	
	public PlayScreen(DungeonGame game)
	{
		super(game);
		_map = MapGenerator.getInstance().generateMap(8, 8, 20, 15);
		EncounterManager.getInstance().setCurrentRoom(_map.getRoom(0, 0));
		// Camera is adjusted to be centered on rooms.
		_camera.position.set(Map.ROOM_SPACE / 2, Map.ROOM_SPACE / 2,0);
		
		_playScreenUI = new Table();
		_playScreenUI.setFillParent(true);
		_stage.addActor(_playScreenUI);
		
		_statsButton = new TextButton("Stats", _skin);
		_statsButton.addListener(new ChangeListener()
		{
			@Override
			public void changed(ChangeEvent event, Actor actor)
			{
				_statsDialog.setVisible(!_statsDialog.isVisible());
			}
		});
		_playScreenUI.add(_statsButton).left();
		_playScreenUI.row();
		_statsDialog = new Dialog("Character Stats", _skin);
		_playScreenUI.add(_statsDialog);
		_statsDialog.setModal(false);
		_statsDialog.setVisible(false);
		_statsDialog.clearChildren();
		_statsLabel = new Label(EncounterManager.getInstance().stats(), _skin);
		_statsDialog.add(_statsLabel);
		_statsDialog.row();
		_statsCloseButton = new TextButton("Close", _skin);
		_statsCloseButton.addListener(new ChangeListener()
		{
			@Override
			public void changed(ChangeEvent event, Actor actor)
			{
				_statsDialog.setVisible(false);
			}
		});
		_statsDialog.add(_statsCloseButton);
		
		_playScreenUI.row();
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
		if (_map.moveParty(mouseX, mouseY))
		{
			_camera.translate(-_camera.position.x + (Map.ROOM_SPACE / 2), -_camera.position.y + (Map.ROOM_SPACE / 2));
			_camera.translate((mouseX / Map.ROOM_SPACE) * Map.ROOM_SPACE, (mouseY / Map.ROOM_SPACE) * Map.ROOM_SPACE, 0);
		}
		
		if (EncounterManager.getInstance().getCurrentRoom().hasEncounter())
		{
			
			_game.switchScreens(new BattleScreen(_game, this));
			
		}

		printStats();
		
	}
	
	public void printStats()
	{//Prints the stats to text box, attach this to a button  ###
		appendLineToTextBox(EncounterManager.getInstance().stats());
	}
	
	public void appendLineToTextBox(String string)
	{
		_textBox.appendText("\n" + string);
		_textScroll.setScrollPercentY(100);
	}
}
