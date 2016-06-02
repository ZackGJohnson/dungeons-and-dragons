package entities;

import com.badlogic.gdx.graphics.Texture;

public class White extends A_Ranger
{
	public static Texture _whiteRangerTexture;
	
	public White()
	{
		super();
		_texture = _whiteRangerTexture;
	}
	
	public int getHealth() 
	{		
		return 14;
	}
	
	public int getMaxHealth()
	{
		return 14;
	}
	
	public int getAtkMod() 
	{		
		return 2;
	}
	
	public int getDmgMod() 
	{		
		return 2;
	}

	public String getDmgDice() 
	{		
		return "2d4";
	}
	
	public int getDmgReduction()
	{		
		return 3;
	}
	
	public int getArmorClass() 
	{		
		return 15;
	}
}
