package gui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;

import db.DataBaseRead;

public class HighScoresScreen extends A_GameScreen
{
	Table _highScoresTable;
	Label _highScoresLabel;
	TextButton _backButton;
	
	public HighScoresScreen(DungeonGame game)
	{
		super(game);
		_highScoresTable = new Table();
		_highScoresTable.setFillParent(true);
		_stage.addActor(_highScoresTable);
		DataBaseRead db = new DataBaseRead();
		_highScoresLabel = new Label("HIGHSCORES\n" + db.toString(), _skin);
		_highScoresTable.add(_highScoresLabel);
		_highScoresTable.row();
		_backButton = new TextButton("Back", _skin);
		_backButton.addListener(new ChangeListener()
		{
			@Override
			public void changed(ChangeEvent event, Actor actor)
			{
				_game.switchScreens(new MainMenuScreen(_game));
			}
		});
		_highScoresTable.add(_backButton);
	}

	public void render(float delta)
	{
		super.render(delta);
		_stage.act(delta);
		_stage.draw();
	}
}
