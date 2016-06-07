package gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;

import db.DataBaseRead;
import encounter.EncounterManager;

public class WinScreen extends A_GameScreen
{
	Table _winScreenTable;
	Label _winLabel;
	Label _pointsLabel;
	Music _winSound;
	TextField _nameField;
	TextButton _okayButton;

	public WinScreen(DungeonGame game)
	{
		super(game);
		
		_winSound = Gdx.audio.newMusic(Gdx.files.internal("victorySound.mp3"));
		_winSound.setVolume(0.25f);
		_winSound.setLooping(false);
		
		_winScreenTable = new Table();
		_winScreenTable.setFillParent(true);
		_stage.addActor(_winScreenTable);
		_winLabel = new Label("VICTORY", _skin);
		_winLabel.setColor(Color.RED);
		_winScreenTable.add(_winLabel);
		_winScreenTable.row();
		
		_pointsLabel = new Label(EncounterManager.getInstance().getPoints() + " points", _skin);
		_winScreenTable.add(_pointsLabel);
		_winScreenTable.row();
		
		_nameField = new TextField("", _skin);
		_nameField.setMaxLength(3);
		_winScreenTable.add(_nameField);
		_winScreenTable.row();
		
		_okayButton = new TextButton("Okay", _skin);
		_okayButton.addListener(new ChangeListener()
		{
			@Override
			public void changed(ChangeEvent event, Actor actor)
			{
				DataBaseRead db = new DataBaseRead();
				db.insertScore(_nameField.getText(), EncounterManager.getInstance().getPoints() + 100);
				EncounterManager.getInstance().clearItems();
				_game.switchScreens(new MainMenuScreen(_game));
			}
		});
		_winScreenTable.add(_okayButton);
	}
	
	public void render(float delta)
	{
		super.render(delta);
		_stage.act(delta);
		_stage.draw();
	}
	
	public void dispose()
	{
		_winSound.dispose();
	}
}
