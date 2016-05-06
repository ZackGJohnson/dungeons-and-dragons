package entities;

public class Wolf extends A_RangerDecorator
{

	public Wolf(A_Ranger r) 
	{
		super(r);
	}
	
	public int getHealth() 
	{		
		return ranger.getHealth();
	}
	
	public int getAtkMod() 
	{		
		return 1 + ranger.getAtkMod();
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
		return ranger.getDmgReduction() - 1;
	}
	
	public int getArmorClass() 
	{		
		return 2 + ranger.getArmorClass();
	}

}

