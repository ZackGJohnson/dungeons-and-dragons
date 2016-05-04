package dungeons;

public class Yellow extends A_Ranger
{

	public int getHealth()
	{
		return 10;
	}

	public int getAtkMod() 
	{
		return 3;
	}

	public int getDmgMod() 
	{
		return 0;
	}

	public String getDmgDice() 
	{
		return "1d12";
	}

	public int getDmgReduction() 
	{
		return 0;
	}

	public int getArmorClass() 
	{
		return 18;
	}
}
