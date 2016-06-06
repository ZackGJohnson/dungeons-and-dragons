package items;

import entities.A_Ranger;
import entities.A_RangerDecorator;

public class InitUp extends A_RangerDecorator
{//Only increases max health, not current
	public InitUp(A_Ranger r) 
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
	public int getInit()
	{
		return ranger.getInit() + 5;
	}
}
