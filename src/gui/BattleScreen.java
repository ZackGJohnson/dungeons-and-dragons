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
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;

import encounter.EncounterManager;
import entities.A_Ranger;
import entities.A_RangerDecorator;
import entities.A_Villain;
import entities.Party;
import entities.Red;

public class BattleScreen extends A_GameScreen
{
	public static Texture _battleBackground;
	Party _party;
	LinkedList<A_Villain> _enemies;
	A_GameScreen _previousScreen;

	Table _battleScreenUI;
	TextButton _useItemButton;
	SelectBox<A_RangerDecorator> _itemSelectBox;
	TextArea _textBox;
	// The total amount of lines the textBox will store
	int _textBoxMaxLines = 10;
	ScrollPane _textScroll;
	ArrayList<ImageButton> _rangerButtons;
	ArrayList<ImageButton> _enemyButtons;

	boolean _usingItem = false;
	A_RangerDecorator _itemToUse;

	public BattleScreen(DungeonGame game, Party party, LinkedList<A_Villain> enemies, A_GameScreen previousScreen)
	{
		super(game);
		_party = party;
		_enemies = enemies;
		_previousScreen = previousScreen;

		EncounterManager.getInstance().addEncounter(enemies);
		EncounterManager.getInstance().initiative();

		_battleScreenUI = new Table();
		_battleScreenUI.setFillParent(true);
		_stage.addActor(_battleScreenUI);
		_itemSelectBox = new SelectBox<A_RangerDecorator>(_skin);
		_itemSelectBox.setItems(_party.getItemsAsArray());
		_battleScreenUI.add(_itemSelectBox);
		_useItemButton = new TextButton("Use Item", _skin);
		_useItemButton.addListener(new ChangeListener()
		{
			@Override
			public void changed(ChangeEvent event, Actor actor)
			{
				_usingItem = true;
			}
		});
		_battleScreenUI.add(_useItemButton);
		_battleScreenUI.row();
		_rangerButtons = new ArrayList<ImageButton>();
		for (int i = 0; i < party.getRangers().size(); i++)
		{
			final int _rangerNumber = i;
			ImageButton _tempRangerButton = new ImageButton(new SpriteDrawable(new Sprite(party.getRangers().get(i).getTexture())));
			_tempRangerButton.addListener(new ChangeListener()
			{
				@Override
				public void changed(ChangeEvent event, Actor actor)
				{
					if (_usingItem)
					{
						// Use an item on a ranger. May have to use reflection
						// here.
					}
					appendLineToTextBox("Clicked on ranger " + _rangerNumber);
				}
			});
			_rangerButtons.add(_tempRangerButton);
		}
		_battleScreenUI.row();
		_enemyButtons = new ArrayList<ImageButton>();
		for (int i = 0; i < enemies.size(); i++)
		{
			final int _enemyNumber = i;
			// TODO: The sprite will need to be changed to the enemy's sprite.
			ImageButton _tempEnemyButton = new ImageButton(new SpriteDrawable(new Sprite(enemies.get(_enemyNumber).getTexture())));
			_tempEnemyButton.addListener(new ChangeListener()
			{
				@Override
				public void changed(ChangeEvent event, Actor actor)
				{
					appendLineToTextBox("Clicked on enemy " + _enemyNumber);
					A_Ranger test = EncounterManager.getInstance().getCurr();

					if (test != null)
					{
						String printStuff = test.attack(_enemyNumber);
						appendLineToTextBox(printStuff);
						//appendLineToTextBox(EncounterManager.getInstance().stats());
						
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

		// Do a "merge sort" and add rangers/enemy buttons with rangers on the
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
		// TODO: Battle background will need to be scaled to screen
		_game.getBatch().draw(_battleBackground, -400, -300);
		_game.getBatch().end();
		_stage.act(delta);
		_stage.draw();

		if (!EncounterManager.getInstance().enemiesAreAlive())
		{
			_game.switchScreens(_previousScreen);
		}
		else
		{
			// runEncounter();
		}
	}

	public void appendLineToTextBox(String string)
	{
		_textBox.appendText("\n" + string);
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
