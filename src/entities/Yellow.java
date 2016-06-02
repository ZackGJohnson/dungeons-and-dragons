package entities;

import com.badlogic.gdx.graphics.Texture;

public class Yellow extends A_Ranger
{
	public static Texture _yellowRangerTexture;
	
	public Yellow()
	{
		super();
		_texture = _yellowRangerTexture;
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
		return 3;
	}

	public int getDmgMod() 
	{
		return 0;
	}

	public String getDmgDice() 
	{
		return "1d12";
	}

	public int getDmgReduction() 
	{
		return 0;
	}

	public int getArmorClass() 
	{
		return 18;
	}
}
