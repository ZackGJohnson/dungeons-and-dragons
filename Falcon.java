package dungeons;

public class Falcon extends A_RangerDecorator
{

	protected Falcon(A_Ranger r) 
	{
		super(r);
	}
	
	public int getHealth() 
	{		
		return ranger.getHealth();
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
		return ranger.getDmgReduction() - 1;
	}
	
	public int getArmorClass() 
	{		
		return ranger.getArmorClass();
	}

}
