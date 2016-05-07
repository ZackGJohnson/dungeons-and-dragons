package entities;

import encounter.EncounterManager;
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
		System.out.println("Monsters turn");
		int target = (int) (Math.random()) * EncounterManager.getInstance().getRangers().size();
		attack(target);
		
		
	}
	
	private void attack(int target)
	{
		A_Ranger enemy = EncounterManager.getInstance().getRangers().get(target);
		int attackRoll = RollManager.getInstance().roll("1d20+" + getAtkMod());
		int damageRoll = RollManager.getInstance().roll("" + getDmgDice() + "+" + getDmgMod());

		if (attackRoll >= enemy.getArmorClass())
		{
			System.out.printf("%s hits with a(n) %d, dealing %d damage!\n\n", getName(), attackRoll, damageRoll);
			// Insert actual method of damage enemy here
		}
		else
		{
			System.out.printf("%s misses with a(n) %d, dealing no damage!\n\n", getName(), attackRoll);
		}
	}
}
