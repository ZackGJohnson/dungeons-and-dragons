package entities;

public class Falcon extends A_RangerDecorator
{

	public Falcon(A_Ranger r) 
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
		return 2 + ranger.getAtkMod();
	}
	
	public int getDmgMod() 
	{		
		return 1 + ranger.getDmgMod();
	}
	
	public String getDmgDice() 
	{		
		return ranger.getDmgDice();
	}
	
	public int getDmgReduction() 
	{		
		int result = ranger.getDmgReduction()-1;
		if(result < 0)
		{
			return 0;
		}else
		{
			return result;
		}
	}
	
	public int getArmorClass() 
	{		
		return ranger.getArmorClass();
	}

}
