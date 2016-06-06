package entities;

import com.badlogic.gdx.graphics.Texture;

public class Lipsyncher extends A_BadGuyDecorator
{
	public static Texture _lipsyncherTexture;

	protected Lipsyncher(A_Villain v) 
	{
		super(v);
		_name = "Lip Syncher";
		v._texture = _lipsyncherTexture;
		_texture = _lipsyncherTexture;
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

