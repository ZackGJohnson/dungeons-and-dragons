package items;

import entities.A_Ranger;
import entities.A_RangerDecorator;

public class HealthUp extends A_RangerDecorator
{//Increased both max heath and current health
	public HealthUp(A_Ranger r) 
	{
		super(r);
	}

	public int getHealth() 
	{		
		return ranger.getHealth() + 5;
	}
	
	public int getMaxHealth()
	{
		return ranger.getMaxHealth() + 5;
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
