package items;

import entities.A_Ranger;
import entities.A_RangerDecorator;

public class HurtRanger extends A_RangerDecorator
{
	private int _damage = 0;
	public HurtRanger(A_Ranger r) 
	{
		super(r);
	}
	
	public HurtRanger(A_Ranger r, int damage) 
	{
		super(r);
		_damage = damage - getDmgReduction();
	}

	public int getHealth() 
	{		
		if(ranger.getHealth() - _damage  < 0)
			ranger.die();
		return ranger.getHealth() - _damage;
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
