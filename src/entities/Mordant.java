package entities;

public class Mordant extends A_BadGuyDecorator
{

	protected Mordant(A_Villain v) 
	{
		super(v);
		_name = "Mordant";
	}
	
	public int getHealth() 
	{		
		return villain.getHealth() + 1;
	}
	
	public int getMaxHealth()
	{
		return villain.getMaxHealth();
	}
	
	public int getAtkMod() 
	{		
		return villain.getAtkMod() - 1;
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
		return villain.getArmorClass() - 1;
	}

}

