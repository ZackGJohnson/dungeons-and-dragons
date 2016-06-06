package entities.bosses;
import encounter.EncounterManager;
import entities.*;

import com.badlogic.gdx.graphics.Texture;

public class Rito extends A_BadGuyDecorator
{
	public static Texture _ritoTexture;

	public Rito(A_Villain v) 
	{
		super(v);
		_name = "Rito";
		setLoot("Rito's Sword");
		v._texture = _ritoTexture;
		_texture = _ritoTexture;
	}
	
	public int getHealth() 
	{		
		return 5 + villain.getHealth();
	}
	
	public int getMaxHealth()
	{
		return 5 + villain.getMaxHealth();
	}
	
	public int getAtkMod() 
	{		
		return 1 + villain.getAtkMod();
	}
	
	public int getDmgMod() 
	{		
		return 2 + villain.getDmgMod();
	}
	
	public String getDmgDice() 
	{		
		return villain.getDmgDice();
	}
	
	public int getDmgReduction() 
	{		
		return 2 + villain.getDmgReduction();
	}
	
	public int getArmorClass() 
	{		
		return 3 + villain.getArmorClass();
	}

}
