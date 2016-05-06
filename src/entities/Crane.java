package entities;

public class Crane extends A_RangerDecorator
{

	protected Crane(A_Ranger r) 
	{
		super(r);
	}
	
	public int getHealth() 
	{		
		return ranger.getHealth() - 1;
	}
	
	public int getAtkMod() 
	{		
		return 2 + ranger.getAtkMod();
	}
	
	public int getDmgMod() 
	{		
		return ranger.getDmgMod();
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
		return 1 + ranger.getArmorClass();
	}

}
