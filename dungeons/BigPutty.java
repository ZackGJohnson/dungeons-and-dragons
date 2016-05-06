package dungeons;

public class BigPutty extends A_Villain
{
	
	public int getHealth() 
	{		
		return 16 + 3;
	}
	
	public int getAtkMod() 
	{		
		return 1 + 2;
	}
	
	public int getDmgMod() 
	{		
		return 3 + 2;
	}
	
	public String getDmgDice() 
	{		
		return "1d10";
	}
	
	public int getDmgReduction() 
	{		
		return 0 + 1;
	}
	
	public int getArmorClass() 
	{		
		return 14 + 2;
	}

}
