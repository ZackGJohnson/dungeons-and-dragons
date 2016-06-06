package items.boss;
import entities.*;
public class RitasStaff extends A_RangerDecorator
{

	public RitasStaff(A_Ranger r) 
	{
		super(r);
	}
	
	public int getHealth() 
	{		
		return ranger.getHealth() + 3;
	}
	
	public int getMaxHealth() 
	{
		return ranger.getMaxHealth() + 3;
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
		return ranger.getArmorClass();
	}

}