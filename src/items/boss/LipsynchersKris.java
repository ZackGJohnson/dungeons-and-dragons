package items.boss;
import entities.*;
public class LipsynchersKris extends A_RangerDecorator
{

	protected LipsynchersKris(A_Ranger r) 
	{
		super(r);
	}
	
	public int getHealth() 
	{		
		return ranger.getHealth() + 1;
	}
	
	public int getMaxHealth() 
	{
		return ranger.getMaxHealth() + 1;
	}
	
	public int getAtkMod() 
	{		
		return ranger.getAtkMod() + 3;
	}
	
	public int getDmgMod() 
	{		
		return ranger.getDmgMod() + 1;
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
		return ranger.getArmorClass() + 2;
	}

}

