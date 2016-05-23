package entities;

public class LordZed extends A_BadGuyDecorator
{

	protected LordZed(A_Villain v) 
	{
		super(v);
	}
	
	public int getHealth() 
	{		
		return 15 + villain.getHealth();
	}
	
	public int getMaxHealth()
	{
		return 15 + villain.getMaxHealth();
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

