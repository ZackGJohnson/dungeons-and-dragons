package encounter;

import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;

public class encounterRunnable implements Runnable
{

	private TextArea _textBox;
	private ScrollPane _textScroll;
	public encounterRunnable(TextArea textBox, ScrollPane textScroll)
	{
		_textBox = textBox;
		_textScroll = textScroll;
	}
	
	@Override
	public void run()
	{
		
		while (EncounterManager.getInstance().enemiesAreAlive() && EncounterManager.getInstance().rangersAreAlive())
		{
			EncounterManager.getInstance().round(_textBox, _textScroll);
		}
		if(!EncounterManager.getInstance().enemiesAreAlive())
			EncounterManager.getInstance().appendLineToTextBox("All enemies defeated!");
		else if(!EncounterManager.getInstance().rangersAreAlive())
			EncounterManager.getInstance().appendLineToTextBox("Mission Failure!");
	}

}
