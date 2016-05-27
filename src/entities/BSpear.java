package entities;

public class BSpear extends A_RangerDecorator
{

	protected BSpear(A_Ranger r) 
	{
		super(r);
	}
	
	public int getHealth() 
	{		
		return ranger.getHealth();
	}
	
	public int getMaxHealth() 
	{
		return ranger.getMaxHealth();
	}
	
	public int getAtkMod() 
	{		
		return ranger.getAtkMod();
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
		return ranger.getArmorClass();
	}

}

