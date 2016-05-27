package gui;

import java.util.LinkedList;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import encounter.EncounterManager;
import entities.*;

public class CharacterSelectScreen extends A_GameScreen
{
	int _totalColumns = 2;
	Table _characterSelectionMenu;
	Dialog _characterSelectionWindow;
	TextButton _finishButton;
	// Character one widgets
	Label _characterOneLabel;
	Label _characterOneNameLabel;
	TextField _characterOneNameField;
	Label _characterOneColorLabel;
	SelectBox<String> _characterOneColorSelectBox;
	Label _characterOneZordLabel;
	SelectBox<String> _characterOneZordSelectBox;
	// Character two widgets
	Label _characterTwoLabel;
	Label _characterTwoNameLabel;
	TextField _characterTwoNameField;
	Label _characterTwoColorLabel;
	SelectBox<String> _characterTwoColorSelectBox;
	Label _characterTwoZordLabel;
	SelectBox<String> _characterTwoZordSelectBox;
	// Character three widgets
	Label _characterThreeLabel;
	Label _characterThreeNameLabel;
	TextField _characterThreeNameField;
	Label _characterThreeColorLabel;
	SelectBox<String> _characterThreeColorSelectBox;
	Label _characterThreeZordLabel;
	SelectBox<String> _characterThreeZordSelectBox;
	// Character four widgets
	Label _characterFourLabel;
	Label _characterFourNameLabel;
	TextField _characterFourNameField;
	Label _characterFourColorLabel;
	SelectBox<String> _characterFourColorSelectBox;
	Label _characterFourZordLabel;
	SelectBox<String> _characterFourZordSelectBox;
	
	public CharacterSelectScreen(DungeonGame game)
	{
		super(game);
		_characterSelectionMenu = new Table();
		_characterSelectionMenu.setFillParent(true);
		_stage.addActor(_characterSelectionMenu);
		_characterSelectionWindow = new Dialog("Character Selection", _skin);
		_characterSelectionWindow.setFillParent(true);
		_characterSelectionWindow.setMovable(false);
		_characterSelectionMenu.addActor(_characterSelectionWindow);
		_characterSelectionWindow.clearChildren();
		
		// Character One
		_characterOneLabel = new Label("Ranger One", _skin);
		_characterSelectionWindow.add(_characterOneLabel).expand().top().left().colspan(_totalColumns);
		_characterSelectionWindow.row();
		_characterOneNameLabel = new Label("Name:" , _skin);
		_characterSelectionWindow.add(_characterOneNameLabel).left();
		_characterOneNameField = new TextField("", _skin);
		_characterSelectionWindow.add(_characterOneNameField).left();
		_characterSelectionWindow.row();
		_characterOneColorLabel = new Label("Color:", _skin);
		_characterSelectionWindow.add(_characterOneColorLabel).left();
		_characterOneColorSelectBox = new SelectBox<String>(_skin);
		_characterOneColorSelectBox.setItems("Red", "Blue", "Pink", "Yellow", "Black", "White");
		_characterSelectionWindow.add(_characterOneColorSelectBox).left().expandX();
		_characterSelectionWindow.row();
		
		_characterOneZordLabel = new Label("Zord:", _skin);
		_characterSelectionWindow.add(_characterOneZordLabel).left();
		_characterOneZordSelectBox = new SelectBox<String>(_skin);
		_characterOneZordSelectBox.setItems("Ape", "Bear", "Crane", "Falcon", "Frog", "Wolf");
		_characterSelectionWindow.add(_characterOneZordSelectBox).left();
		_characterSelectionWindow.row();
		
		// Character Two
		_characterTwoLabel = new Label("Ranger Two", _skin);
		_characterSelectionWindow.add(_characterTwoLabel).expand().top().left().colspan(_totalColumns);
		_characterSelectionWindow.row();
		_characterTwoNameLabel = new Label("Name:" , _skin);
		_characterSelectionWindow.add(_characterTwoNameLabel).left();
		_characterTwoNameField = new TextField("", _skin);
		_characterSelectionWindow.add(_characterTwoNameField).left();
		_characterSelectionWindow.row();
		_characterTwoColorLabel = new Label("Color:", _skin);
		_characterSelectionWindow.add(_characterTwoColorLabel).left();
		_characterTwoColorSelectBox = new SelectBox<String>(_skin);
		_characterTwoColorSelectBox.setItems("Red", "Blue", "Pink", "Yellow", "Black", "White");
		_characterSelectionWindow.add(_characterTwoColorSelectBox).left().expandX();
		_characterSelectionWindow.row();
		
		_characterTwoZordLabel = new Label("Zord:", _skin);
		_characterSelectionWindow.add(_characterTwoZordLabel).left();
		_characterTwoZordSelectBox = new SelectBox<String>(_skin);
		_characterTwoZordSelectBox.setItems("Ape", "Bear", "Crane", "Falcon", "Frog", "Wolf");
		_characterSelectionWindow.add(_characterTwoZordSelectBox).left();
		_characterSelectionWindow.row();
		
		// Character Three
		_characterThreeLabel = new Label("Ranger Three", _skin);
		_characterSelectionWindow.add(_characterThreeLabel).expand().top().left().colspan(_totalColumns);
		_characterSelectionWindow.row();
		_characterThreeNameLabel = new Label("Name:" , _skin);
		_characterSelectionWindow.add(_characterThreeNameLabel).left();
		_characterThreeNameField = new TextField("", _skin);
		_characterSelectionWindow.add(_characterThreeNameField).left();
		_characterSelectionWindow.row();
		_characterThreeColorLabel = new Label("Color:", _skin);
		_characterSelectionWindow.add(_characterThreeColorLabel).left();
		_characterThreeColorSelectBox = new SelectBox<String>(_skin);
		_characterThreeColorSelectBox.setItems("Red", "Blue", "Pink", "Yellow", "Black", "White");
		_characterSelectionWindow.add(_characterThreeColorSelectBox).left().expandX();
		_characterSelectionWindow.row();
		
		_characterThreeZordLabel = new Label("Zord:", _skin);
		_characterSelectionWindow.add(_characterThreeZordLabel).left();
		_characterThreeZordSelectBox = new SelectBox<String>(_skin);
		_characterThreeZordSelectBox.setItems("Ape", "Bear", "Crane", "Falcon", "Frog", "Wolf");
		_characterSelectionWindow.add(_characterThreeZordSelectBox).left();
		_characterSelectionWindow.row();
		
		// Character Four
		_characterFourLabel = new Label("Ranger Four", _skin);
		_characterSelectionWindow.add(_characterFourLabel).expand().top().left().colspan(_totalColumns);
		_characterSelectionWindow.row();
		_characterFourNameLabel = new Label("Name:" , _skin);
		_characterSelectionWindow.add(_characterFourNameLabel).left();
		_characterFourNameField = new TextField("", _skin);
		_characterSelectionWindow.add(_characterFourNameField).left();
		_characterSelectionWindow.row();
		_characterFourColorLabel = new Label("Color:", _skin);
		_characterSelectionWindow.add(_characterFourColorLabel).left();
		_characterFourColorSelectBox = new SelectBox<String>(_skin);
		_characterFourColorSelectBox.setItems("Red", "Blue", "Pink", "Yellow", "Black", "White");
		_characterSelectionWindow.add(_characterFourColorSelectBox).left().expandX();
		_characterSelectionWindow.row();
		
		_characterFourZordLabel = new Label("Zord:", _skin);
		_characterSelectionWindow.add(_characterFourZordLabel).left();
		_characterFourZordSelectBox = new SelectBox<String>(_skin);
		_characterFourZordSelectBox.setItems("Ape", "Bear", "Crane", "Falcon", "Frog", "Wolf");
		_characterSelectionWindow.add(_characterFourZordSelectBox).left();
		_characterSelectionWindow.row();
		
		// Finish Button
		_finishButton = new TextButton("Finish", _skin);
		_characterSelectionWindow.add(_finishButton).bottom().colspan(_totalColumns);
		_finishButton.addListener(new ChangeListener()
				{
					@Override
					public void changed(ChangeEvent event, Actor actor)
					{
						LinkedList<A_Ranger> rangers = new LinkedList<A_Ranger>();
						A_Ranger rangerOne = new Red();
						if (_characterOneColorSelectBox.equals("Red"))
						{
							rangerOne = new Red();
						}
						else if (_characterOneColorSelectBox.equals("Blue"))
						{
							rangerOne = new Blue();
						}
						else if (_characterOneColorSelectBox.equals("Pink"))
						{
							rangerOne = new Pink();
						}
						else if (_characterOneColorSelectBox.equals("Yellow"))
						{
							rangerOne = new Yellow();
						}
						else if (_characterOneColorSelectBox.equals("Black"))
						{
							rangerOne = new Black();
						}
						else if (_characterOneColorSelectBox.equals("White"))
						{
							rangerOne = new White();
						}
						if (_characterOneZordSelectBox.equals("Ape"))
						{
							//rangerOne = new Ape(rangerOne);
						}
						else if (_characterOneZordSelectBox.equals("Bear"))
						{
							//rangerOne = new Bear(rangerOne);
						}
						else if (_characterOneZordSelectBox.equals("Crane"))
						{
							//rangerOne = new Crane(rangerOne);
						}
						else if (_characterOneZordSelectBox.equals("Falcon"))
						{
							//rangerOne = new Falcon(rangerOne);
						}
						else if (_characterOneZordSelectBox.equals("Frog"))
						{
							//rangerOne = new Frog(rangerOne);
						}
						else if (_characterOneZordSelectBox.equals("Wolf"))
						{
							rangerOne = new Wolf(rangerOne);
						}
						rangerOne.setName(_characterOneNameField.getText());
						
						A_Ranger rangerTwo = new Red();
						if (_characterTwoColorSelectBox.equals("Red"))
						{
							rangerTwo = new Red();
						}
						else if (_characterTwoColorSelectBox.equals("Blue"))
						{
							rangerTwo = new Blue();
						}
						else if (_characterTwoColorSelectBox.equals("Pink"))
						{
							rangerTwo = new Pink();
						}
						else if (_characterTwoColorSelectBox.equals("Yellow"))
						{
							rangerTwo = new Yellow();
						}
						else if (_characterTwoColorSelectBox.equals("Black"))
						{
							rangerTwo = new Black();
						}
						else if (_characterTwoColorSelectBox.equals("White"))
						{
							rangerTwo = new White();
						}
						if (_characterTwoZordSelectBox.equals("Ape"))
						{
							//rangerTwo = new Ape(rangerTwo);
						}
						else if (_characterTwoZordSelectBox.equals("Bear"))
						{
							//rangerTwo = new Bear(rangerTwo);
						}
						else if (_characterTwoZordSelectBox.equals("Crane"))
						{
							//rangerTwo = new Crane(rangerTwo);
						}
						else if (_characterTwoZordSelectBox.equals("Falcon"))
						{
							//rangerTwo = new Falcon(rangerTwo);
						}
						else if (_characterTwoZordSelectBox.equals("Frog"))
						{
							//rangerTwo = new Frog(rangerTwo);
						}
						else if (_characterTwoZordSelectBox.equals("Wolf"))
						{
							rangerTwo = new Wolf(rangerTwo);
						}
						rangerTwo.setName(_characterTwoNameField.getText());
						
						A_Ranger rangerThree = new Red();
						if (_characterThreeColorSelectBox.equals("Red"))
						{
							rangerThree = new Red();
						}
						else if (_characterThreeColorSelectBox.equals("Blue"))
						{
							rangerThree = new Blue();
						}
						else if (_characterThreeColorSelectBox.equals("Pink"))
						{
							rangerThree = new Pink();
						}
						else if (_characterThreeColorSelectBox.equals("Yellow"))
						{
							rangerThree = new Yellow();
						}
						else if (_characterThreeColorSelectBox.equals("Black"))
						{
							rangerThree = new Black();
						}
						else if (_characterThreeColorSelectBox.equals("White"))
						{
							rangerThree = new White();
						}
						if (_characterThreeZordSelectBox.equals("Ape"))
						{
							//rangerThree = new Ape(rangerThree);
						}
						else if (_characterThreeZordSelectBox.equals("Bear"))
						{
							//rangerThree = new Bear(rangerThree);
						}
						else if (_characterThreeZordSelectBox.equals("Crane"))
						{
							//rangerThree = new Crane(rangerThree);
						}
						else if (_characterThreeZordSelectBox.equals("Falcon"))
						{
							//rangerThree = new Falcon(rangerThree);
						}
						else if (_characterThreeZordSelectBox.equals("Frog"))
						{
							//rangerThree = new Frog(rangerThree);
						}
						else if (_characterThreeZordSelectBox.equals("Wolf"))
						{
							rangerThree = new Wolf(rangerThree);
						}
						rangerThree.setName(_characterThreeNameField.getText());
						
						A_Ranger rangerFour = new Red();
						if (_characterFourColorSelectBox.equals("Red"))
						{
							rangerFour = new Red();
						}
						else if (_characterFourColorSelectBox.equals("Blue"))
						{
							rangerFour = new Blue();
						}
						else if (_characterFourColorSelectBox.equals("Pink"))
						{
							rangerFour = new Pink();
						}
						else if (_characterFourColorSelectBox.equals("Yellow"))
						{
							rangerFour = new Yellow();
						}
						else if (_characterFourColorSelectBox.equals("Black"))
						{
							rangerFour = new Black();
						}
						else if (_characterFourColorSelectBox.equals("White"))
						{
							rangerFour = new White();
						}
						if (_characterFourZordSelectBox.equals("Ape"))
						{
							//rangerFour = new Ape(rangerFour);
						}
						else if (_characterFourZordSelectBox.equals("Bear"))
						{
							//rangerFour = new Bear(rangerFour);
						}
						else if (_characterFourZordSelectBox.equals("Crane"))
						{
							//rangerFour = new Crane(rangerFour);
						}
						else if (_characterFourZordSelectBox.equals("Falcon"))
						{
							//rangerFour = new Falcon(rangerFour);
						}
						else if (_characterFourZordSelectBox.equals("Frog"))
						{
							//rangerFour = new Frog(rangerFour);
						}
						else if (_characterFourZordSelectBox.equals("Wolf"))
						{
							rangerFour = new Wolf(rangerFour);
						}
						rangerFour.setName(_characterFourNameField.getText());
						
						rangers.add(rangerOne);
						rangers.add(rangerTwo);
						rangers.add(rangerThree);
						rangers.add(rangerFour);
						
						//Adding party to encounter handler
						EncounterManager.getInstance().addRangers(rangers);
						
						PlayScreen playScreen = new PlayScreen(_game);
						playScreen.createNewParty(rangers);
						_game.switchScreens(playScreen);
					}
				});
	}
	
	public void render(float delta)
	{
		super.render(delta);
		_stage.act(delta);
		_stage.draw();
	}
	
	@Override
	public void resize(int width, int height)
	{
		super.resize(width, height);
		_characterSelectionMenu.invalidateHierarchy();
		_characterSelectionMenu.invalidate();
		_stage.getViewport().apply();
	}
}
