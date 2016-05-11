package items;

import entities.A_BadGuyDecorator;
import entities.A_Ranger;
import entities.A_RangerDecorator;
import entities.A_Villain;

public class HurtEnemy extends A_BadGuyDecorator
{
	public HurtEnemy(A_Villain v) 
	{
		super(v);
	}

	public int getHealth() 
	{		
		if(villain.getHealth() - 1  < 0)
			villain.die();
		return villain.getHealth() - 1;
	}
	
	public int getMaxHealth()
	{
		return villain.getMaxHealth();
	}
	
	public int getAtkMod() 
	{		
		return villain.getAtkMod();
	}
	
	public int getDmgMod() 
	{		
		return villain.getDmgMod();
	}
	
	public String getDmgDice() 
	{		
		return villain.getDmgDice();
	}
	
	public int getDmgReduction() 
	{		
		return villain.getDmgReduction();
	}
	
	public int getArmorClass() 
	{		
		return villain.getArmorClass();
	}
}
