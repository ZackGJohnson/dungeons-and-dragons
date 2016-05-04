package dungeons;

public class Blue extends A_Ranger
{

	public int getHealth() 
	{
		return 10;
	}

	public int getAtkMod() 
	{
		return 2;
	}

	public int getDmgMod() 
	{
		return 3;
	}

	public String getDmgDice() 
	{
		return "2d6";
	}

	public int getDmgReduction() 
	{
		return 0;
	}

	public int getArmorClass() 
	{
		return 10;
	}

}
