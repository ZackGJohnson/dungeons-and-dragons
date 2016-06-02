package entities;

import com.badlogic.gdx.graphics.Texture;

public class Pink extends A_Ranger
{
	public static Texture _pinkRangerTexture;

	public Pink()
	{
		super();
		_texture = _pinkRangerTexture;
	}
	
	public int getHealth() 
	{
		return 12;
	}

	public int getAtkMod() 
	{
		return 2;
	}
	
	public int getMaxHealth()
	{
		return 12;
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
