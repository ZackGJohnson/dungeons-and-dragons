package entities.bosses;
import com.badlogic.gdx.graphics.Texture;

import encounter.EncounterManager;
import entities.*;
public class Scorpina extends A_BadGuyDecorator
{
	public static Texture _scorpinaTexture;

	public Scorpina(A_Villain v) 
	{
		super(v);
		setLoot("Scorpina's Boomerang");
		_name = "Scorpina";
		v._texture = _scorpinaTexture;
		_texture = _scorpinaTexture;
	}
	public int getHealth() 
	{		
		return 2 + villain.getHealth();
	}
	
	public int getMaxHealth()
	{
		return 2 + villain.getMaxHealth();
	}
	
	public int getAtkMod() 
	{		
		return 2 + villain.getAtkMod();
	}
	
	public int getDmgMod() 
	{		
		return villain.getDmgMod();
	}
	
	public String getDmgDice() 
	{		
		return villain.getDmgDice();
	}
	
	public int getDmgReduction() 
	{		
		return villain.getDmgReduction();
	}
	
	public int getArmorClass() 
	{		
		return 4 + villain.getArmorClass();
	}

}

