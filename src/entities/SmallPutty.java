package entities;

import com.badlogic.gdx.graphics.Texture;

public class SmallPutty extends A_Villain
{
	public static Texture _smallPuttyTexture;
	
	public SmallPutty()
	{
		super();
		_texture = _smallPuttyTexture;
	}
	
	public int getHealth() 
	{		
		return 10;
	}
	
	public int getMaxHealth()
	{
		return 10;
	}
	
	public int getAtkMod() 
	{		
		return 1;
	}
	
	public int getDmgMod() 
	{		
		return 2;
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
