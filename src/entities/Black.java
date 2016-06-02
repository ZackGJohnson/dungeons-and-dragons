package entities;

import com.badlogic.gdx.graphics.Texture;

public class Black extends A_Ranger
{
	public static Texture _blackRangerTexture;
	
	public Black()
	{
		super();
		_texture = _blackRangerTexture;
	}
	
	public int getHealth() 
	{		
		return 16;
	}
	
	public int getMaxHealth()
	{
		return 16;
	}
	
	public int getAtkMod() 
	{		
		return 1;
	}
	
	public int getDmgMod() 
	{		
		return 3;
	}
	
	public String getDmgDice() 
	{		
		return "1d10";
	}
	
	public int getDmgReduction() 
	{		
		return 0;
	}
	
	public int getArmorClass() 
	{		
		return 14;
	}
}
