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

import encounter.EncounterManager;

public class EndScreen extends A_GameScreen
{
	Table _endScreenTable;
	Label _gameOverLabel;
	Label _pointsLabel;
	Music _gameOverSound;
	TextField _nameField;
	TextButton _okayButton;
	
	public EndScreen(DungeonGame game)
	{
		super(game);
		
		_gameOverSound = Gdx.audio.newMusic(Gdx.files.internal("gameOverSound.mp3"));
		_gameOverSound.setVolume(0.25f);
		_gameOverSound.setLooping(false);
		
		_endScreenTable = new Table();
		_endScreenTable.setFillParent(true);
		_stage.addActor(_endScreenTable);
		_gameOverLabel = new Label("GAME OVER", _skin);
		_gameOverLabel.setColor(Color.RED);
		_endScreenTable.add(_gameOverLabel);
		_endScreenTable.row();
		
		_pointsLabel = new Label(EncounterManager.getInstance().getPoints() + " points", _skin);
		_endScreenTable.add(_pointsLabel);
		_endScreenTable.row();
		
		_nameField = new TextField("", _skin);
		_nameField.setMaxLength(3);
		_endScreenTable.add(_nameField);
		_endScreenTable.row();
		
		_okayButton = new TextButton("Okay", _skin);
		_okayButton.addListener(new ChangeListener()
		{
			@Override
			public void changed(ChangeEvent event, Actor actor)
			{
				_game.switchScreens(new MainMenuScreen(_game));
			}
		});
		_endScreenTable.add(_okayButton);
		
		_game.playMusic(_gameOverSound, false);
	}
	
	public void render(float delta)
	{
		super.render(delta);
		_stage.act(delta);
		_stage.draw();
	}
	
	public void dispose()
	{
		_gameOverSound.dispose();
	}
}
