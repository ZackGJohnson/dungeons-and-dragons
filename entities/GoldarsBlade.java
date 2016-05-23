package entities;

public class GoldarsBlade extends A_RangerDecorator
{

	protected GoldarsBlade(A_Ranger r) 
	{
		super(r);
	}
	
	public int getHealth() 
	{		
		return ranger.getHealth() + 2;
	}
	
	public int getMaxHealth() 
	{
		return ranger.getMaxHealth() + 2;
	}
	
	public int getAtkMod() 
	{		
		return ranger.getAtkMod() + 1;
	}
	
	public int getDmgMod() 
	{		
		return ranger.getDmgMod() + 2;
	}
	
	public String getDmgDice() 
	{		
		return ranger.getDmgDice();
	}
	
	public int getDmgReduction() 
	{		
		return ranger.getDmgReduction() + 1;
	}
	
	public int getArmorClass() 
	{		
		return ranger.getArmorClass() + 1;
	}

}

