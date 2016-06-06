package items.boss;
import entities.*;
public class MordantsPlate extends A_RangerDecorator
{

	public MordantsPlate(A_Ranger r) 
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
		return ranger.getDmgReduction() + 1;
	}
	
	public int getArmorClass() 
	{		
		return ranger.getArmorClass() + 2;
	}

}

