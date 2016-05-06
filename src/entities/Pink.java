package entities;

public class Pink extends A_Ranger
{

	public int getHealth() 
	{
		return 12;
	}

	public int getAtkMod() 
	{
		return 2;
	}

	public int getDmgMod() 
	{
		return 2;
	}

	public String getDmgDice() 
	{	
		return "1d8";
	}

	public int getDmgReduction() 
	{	
		return 1;
	}

	public int getArmorClass() 
	{
		return 14;
	}

}
