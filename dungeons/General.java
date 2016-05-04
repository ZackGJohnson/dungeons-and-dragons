package dungeons;

public class General extends A_Villain
{

	public int getHealth()
	{
		return 15;
	}

	public int getAtkMod() 
	{
		return 3;
	}

	public int getDmgMod() 
	{
		return 2;
	}

	public String getDmgDice() 
	{
		return "1d10";
	}

	public int getDmgReduction() 
	{
		return 2;
	}

	public int getArmorClass() 
	{
		return 12;
	}
}