package entities;

public class Frog extends A_RangerDecorator
{

	public Frog(A_Ranger r) 
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
		return ranger.getAtkMod();
	}

	public int getDmgMod() 
	{
		return ranger.getDmgMod() - 1;
	}

	public String getDmgDice() 
	{
		return ranger.getDmgDice();
	}

	public int getDmgReduction() 
	{
		return 2 + ranger.getDmgReduction();
	}

	public int getArmorClass() 
	{
		return 1 + ranger.getArmorClass();
	}

}
