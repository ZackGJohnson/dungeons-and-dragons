package gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class MainMenuScreen extends A_GameScreen
{
	Table _mainMenuTable;
	Image _logo;
	TextButton _newGameButton;
	TextButton _loadGameButton;
	TextButton _highscoresButton;
	TextButton _exitGameButton;
	float _buttonPadding = 15;
	Music _themeMusic;
	
	public MainMenuScreen(DungeonGame game)
	{
		super(game);
		
		_themeMusic = Gdx.audio.newMusic(Gdx.files.internal("themeMusic.mp3"));
		_themeMusic.setVolume(0.25f);
		
		_mainMenuTable = new Table();
		_mainMenuTable.setFillParent(true);
		_stage.addActor(_mainMenuTable);
		_logo = new Image(new Texture("logo.png"));
		_mainMenuTable.add(_logo).padBottom(_buttonPadding).prefSize(300);
		_mainMenuTable.row();
		_newGameButton = new TextButton("New Game", _skin);
		_newGameButton.addListener(new ChangeListener()
				{
					@Override
					public void changed(ChangeEvent event, Actor actor)
					{
						_game.switchScreens(new CharacterSelectScreen(_game));
					}
				});
		_mainMenuTable.add(_newGameButton).fillX().padBottom(_buttonPadding);
		_mainMenuTable.row();
		_highscoresButton = new TextButton("Highscores", _skin);
		_highscoresButton.addListener(new ChangeListener()
		{
			@Override
			public void changed(ChangeEvent event, Actor actor)
			{
				// Highscores
			}
		});
		_mainMenuTable.add(_highscoresButton).fillX().padBottom(_buttonPadding);
		_mainMenuTable.row();
		_exitGameButton = new TextButton("Quit", _skin);
		_exitGameButton.addListener(new ChangeListener()
		{
			@Override
			public void changed(ChangeEvent event, Actor actor)
			{
				Gdx.app.exit();
			}
		});
		_mainMenuTable.add(_exitGameButton).fillX();
		
		_game.playMusic(_themeMusic, true);
	}
	
	public void render(float delta)
	{
		super.render(delta);
		_stage.act(delta);
		_stage.draw();
	}
	
	public void dispose()
	{
		_themeMusic.dispose();
	}
}
