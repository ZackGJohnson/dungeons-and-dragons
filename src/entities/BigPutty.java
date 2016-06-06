package entities;

import com.badlogic.gdx.graphics.Texture;

public class BigPutty extends A_Villain
{
	public static Texture _bigPuttyTexture;
	
	public BigPutty()
	{
		super();
		setName("Big Putty");
		_texture = _bigPuttyTexture;
	}
	
	public int getHealth() 
	{		
		return 12;
	}
	
	public int getMaxHealth()
	{
		return 12;
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
		return "1d10";
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
