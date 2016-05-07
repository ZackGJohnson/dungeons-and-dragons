package entities;

import encounter.RollManager;

public abstract class A_Villain
{
	protected int health;
	protected int attackMod;
	protected int dmgMod;
	protected String dmgDice;
	protected int dmgReduction;
	protected int armorClass;
	protected String name;
	
	public abstract int getHealth();
	public abstract int getAtkMod();
	public abstract int getDmgMod();
	public abstract String getDmgDice();
	public abstract int getDmgReduction();
	public abstract int getArmorClass();
	public String getName()
	{
		return "Test Name";
	}
	
	public void turn()
	{
		
		System.out.printf("The evil creature attacks with a(n) %d, dealing %d damage!\n", RollManager.getInstance().roll("1d20+" + getAtkMod()), RollManager.getInstance().roll("" + getDmgDice() + "+" + getDmgMod()));
		
	}
}
