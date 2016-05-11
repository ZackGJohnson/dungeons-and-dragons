package items;

import entities.A_Ranger;
import entities.A_RangerDecorator;

public class HurtRanger extends A_RangerDecorator
{
	public HurtRanger(A_Ranger r) 
	{
		super(r);
	}

	public int getHealth() 
	{		
		if(ranger.getHealth() - 1  < 0)
			ranger.die();
		return ranger.getHealth() - 1;
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
