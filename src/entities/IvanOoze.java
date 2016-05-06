package entities;

public class IvanOoze extends A_BadGuyDecorator
{

	public IvanOoze(A_Villain v) 
	{
		super(v);
	}
	
	public int getHealth() 
	{		
		return 5 + villain.getHealth();
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

