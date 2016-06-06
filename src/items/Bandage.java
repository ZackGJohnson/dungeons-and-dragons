package items;

import entities.A_Ranger;
import entities.A_RangerDecorator;

public class Bandage extends A_RangerDecorator
{
	public Bandage(A_Ranger r) 
	{
		super(r);
	}

	public int getHealth() 
	{		
		if(ranger.getHealth() + 2 > ranger.getMaxHealth())
			return ranger.getMaxHealth();
		else
			return ranger.getHealth() + 3;
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
