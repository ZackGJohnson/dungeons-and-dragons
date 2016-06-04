package gui;

import java.util.ArrayList;
import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;

import encounter.EncounterManager;
import encounter.RollManager;
import entities.A_Entity;
import entities.A_Ranger;
import entities.A_RangerDecorator;
import entities.A_Villain;
import entities.Red;

public class BattleScreen extends A_GameScreen
{
	public static Texture _battleBackground;
	LinkedList<A_Villain> _enemies;
	A_GameScreen _previousScreen;

	Table _battleScreenUI;
	TextButton _useItemButton;
	SelectBox<String> _itemSelectBox;
	TextArea _textBox;
	// The total amount of lines the textBox will store
	int _textBoxMaxLines = 10;
	ScrollPane _textScroll;
	ArrayList<ImageButton> _rangerButtons;
	ArrayList<ImageButton> _enemyButtons;

	boolean _usingItem = false;

	public BattleScreen(DungeonGame game, A_GameScreen previousScreen)
	{
		super(game);
		_enemies = EncounterManager.getInstance().getCurrentRoom().getEnemies();
		_previousScreen = previousScreen;

		EncounterManager.getInstance().addEncounter(_enemies);
		EncounterManager.getInstance().initiative();

		_battleScreenUI = new Table();
		_battleScreenUI.setFillParent(true);
		_stage.addActor(_battleScreenUI);
		_itemSelectBox = new SelectBox<String>(_skin);
		_itemSelectBox.setItems(EncounterManager.getInstance().getItemsAsArray());
		_battleScreenUI.add(_itemSelectBox).padBottom(_stage.getHeight() / 5);
		;
		_useItemButton = new TextButton("Use Item", _skin);
		_useItemButton.addListener(new ChangeListener()
		{
			@Override
			public void changed(ChangeEvent event, Actor actor)
			{
				_usingItem = true;
			}
		});
		_battleScreenUI.add(_useItemButton).padBottom(_stage.getHeight() / 5);
		_battleScreenUI.row();
		_rangerButtons = new ArrayList<ImageButton>();
		for (int i = 0; i < EncounterManager.getInstance().getRangers().size(); i++)
		{
			final int _rangerNumber = i;
			ImageButton _tempRangerButton = new ImageButton(new SpriteDrawable(new Sprite(EncounterManager.getInstance().getRangers().get(i).getTexture())));
			_tempRangerButton.addListener(new ChangeListener()
			{
				@Override
				public void changed(ChangeEvent event, Actor actor)
				{
					if (_usingItem)
					{
						EncounterManager.getInstance().giveItem(_rangerNumber, _itemSelectBox.getSelected());
						appendLineToTextBox("Used " + _itemSelectBox.getSelected() + " on " + EncounterManager.getInstance().getRangers().get(_rangerNumber).getName() + ".");
						enemyTurn();
						_usingItem = false;
						// Remove the item from the list
						// TODO: Item needs to be removed from the encounter
						// manager item list.
						_itemSelectBox.clearItems();
						_itemSelectBox.setItems(EncounterManager.getInstance().getItemsAsArray());
					}
				}
			});
			_rangerButtons.add(_tempRangerButton);
		}
		_battleScreenUI.row();
		_enemyButtons = new ArrayList<ImageButton>();
		for (int i = 0; i < _enemies.size(); i++)
		{
			final int _enemyNumber = i;
			ImageButton _tempEnemyButton = new ImageButton(new SpriteDrawable(new Sprite(_enemies.get(_enemyNumber).getTexture())));
			_tempEnemyButton.addListener(new ChangeListener()
			{
				@Override
				public void changed(ChangeEvent event, Actor actor)
				{
					A_Entity test = EncounterManager.getInstance().getCurr();

					if (test != null)
					{
						String printStuff = test.attack(_enemyNumber);
						appendLineToTextBox(printStuff);
						enemyTurn();

						// This doesn't work, maybe due to size of textbox?
						// appendLineToTextBox(EncounterManager.getInstance().stats());

					}
					else
					{
						appendLineToTextBox("Test is null");
					}

					// appendLineToTextBox(EncounterManager.getInstance().getCurr().attack(_enemyNumber));
				}
			});
			_enemyButtons.add(_tempEnemyButton);
		}

		// Add rangers/enemy buttons with rangers on the
		// left and enemies on the right.
		int _rangerNumber = 0;
		int _enemyNumber = 0;
		while (_rangerNumber < _rangerButtons.size() || _enemyNumber < _enemyButtons.size())
		{
			if (_rangerNumber < _rangerButtons.size())
			{
				_battleScreenUI.add(_rangerButtons.get(_rangerNumber));
				_rangerNumber++;
			}
			if (_enemyNumber < _enemyButtons.size())
			{
				_battleScreenUI.add(_enemyButtons.get(_enemyNumber));
				_enemyNumber++;
			}
			_battleScreenUI.row();
		}

		_battleScreenUI.row();
		_textBox = new TextArea("", _skin);
		_textBox.setPrefRows(_textBoxMaxLines);
		_textBox.clearListeners();
		_textScroll = new ScrollPane(_textBox, _skin);
		_textScroll.setFadeScrollBars(false);
		// Calculates the height of 3 lines of text
		float _textBoxHeight = _textBox.getStyle().font.getLineHeight() * 3 + _textBox.getStyle().background.getBottomHeight() * 6;
		_battleScreenUI.add(_textScroll).expand().fillX().maxHeight(_textBoxHeight).bottom().colspan(2);
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
		_game.getBatch().draw(_battleBackground, -((_camera.viewportWidth * _camera.zoom) / 2), -((_camera.viewportHeight * _camera.zoom) / 2), _camera.viewportWidth * _camera.zoom, _camera.viewportHeight * _camera.zoom);
		_game.getBatch().end();
		_stage.act(delta);
		_stage.draw();

		if (!EncounterManager.getInstance().enemiesAreAlive())
		{
			LinkedList<A_Ranger> testRangers = EncounterManager.getInstance().getRangers();
			_game.switchScreens(_previousScreen);
		}

		for (int j = 0; j < _enemyButtons.size(); j++)
		{
			if (!_enemies.get(j).isAlive())
			{
				_enemyButtons.get(j).setVisible(false);
			}
		}

		if (!EncounterManager.getInstance().rangersAreAlive())
		{
			_game.switchScreens(new EndScreen(_game));
		}
		else
		{
			for (int j = 0; j < _rangerButtons.size(); j++)
			{
				if (!EncounterManager.getInstance().getRangers().get(j).isAlive())
				{
					_rangerButtons.get(j).setVisible(false);
				}
			}
		}
	}

	public void enemyTurn()
	{
		A_Entity curr = EncounterManager.getInstance().getCurr();
		if (EncounterManager.getInstance().rangersAreAlive())
		{
			if (curr.getType().equalsIgnoreCase("Enemy"))
			{
				int target = RollManager.getInstance().roll("1d" + EncounterManager.getInstance().getRangers().size() + "+0");
				while(!EncounterManager.getInstance().getRangers().get(target).isAlive())
				{
					target = RollManager.getInstance().roll("1d" + EncounterManager.getInstance().getRangers().size() + "+0");
				}
				
				String attackResult = curr.attack(target);
				// String attackResult = "Enemy Attack";
				appendLineToTextBox(attackResult);
				EncounterManager.getInstance().nextEntity();
				if (curr.getType().equalsIgnoreCase("Enemy"))
				{// Scary recursion
					enemyTurn();
				}
			}
		}
	}

	public void appendLineToTextBox(String string)
	{
		_textBox.appendText(string);
		_textScroll.setScrollPercentY(100);
	}

	public void runEncounter()
	{
		while (EncounterManager.getInstance().enemiesAreAlive() && EncounterManager.getInstance().rangersAreAlive())
		{
			// EncounterManager.getInstance().round(_textBox, _textScroll);
		}
		if (!EncounterManager.getInstance().enemiesAreAlive())
			appendLineToTextBox("All enemies defeated!");
		else if (!EncounterManager.getInstance().rangersAreAlive())
			appendLineToTextBox("Mission Failure!");
	}
}
