package entities;

import com.badlogic.gdx.graphics.Texture;

public class Red extends A_Ranger
{
	public static Texture _redRangerTexture;
	
	public Red()
	{
		super();
		_texture = _redRangerTexture;
	}
	
	public int getHealth() 
	{		
		return 13;
	}
	
	public int getMaxHealth()
	{
		return 13;
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
		return "1d8";
	}
	
	public int getDmgReduction() 
	{		
		return 1;
	}

	public int getArmorClass() 
	{		
		return 14;
	}
}
