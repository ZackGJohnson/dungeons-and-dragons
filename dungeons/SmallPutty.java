package dungeons;

public class SmallPutty extends A_Villain
{
	
	public int getHealth() 
	{		
		return 16;
	}
	
	public int getAtkMod() 
	{		
		return 1;
	}
	
	public int getDmgMod() 
	{		
		return 3;
	}
	
	public String getDmgDice() 
	{		
		return "1d10";
	}
	
	public int getDmgReduction() 
	{		
		return 0;
	}
	
	public int getArmorClass() 
	{		
		return 14;
	}

}
