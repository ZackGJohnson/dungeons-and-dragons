package entities;

public class Ape extends A_RangerDecorator
{

	protected Ape(A_Ranger r) 
	{
		super(r);
	}
	
	public int getHealth() 
	{		
		return 1 + ranger.getHealth();
	}
	
	public int getAtkMod() 
	{		
		return ranger.getAtkMod() - 1;
	}
	
	public int getDmgMod() 
	{		
		return 2 + ranger.getDmgMod();
	}
	
	public String getDmgDice() 
	{		
		return ranger.getDmgDice();
	}
	
	public int getDmgReduction() 
	{		
		return ranger.getDmgReduction();
	}
	
	public int getArmorClass() 
	{		
		return ranger.getArmorClass();
	}

}
