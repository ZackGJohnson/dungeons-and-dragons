package entities;

import items.HurtEnemy;
import items.HurtRanger;
import encounter.EncounterManager;
import encounter.RollManager;

public abstract class A_Villain extends A_Entity
{

	public String getName()
	{
		return "Test Villain";
	}

	public void turn()
	{
		if (isAlive())
		{
			//System.out.println("Monsters turn");
			int target = RollManager.getInstance().roll("1d" + EncounterManager.getInstance().getRangers().size() + "+0");
			attack(target);
		}

	}

	private void attack(int target)
	{
		A_Ranger enemy = EncounterManager.getInstance().getRangers().get(target);
		A_Ranger damagedEnemy = EncounterManager.getInstance().getRangers().get(target);
		int attackRoll = RollManager.getInstance().roll("1d20+" + getAtkMod());
		int damageRoll = RollManager.getInstance().roll("" + getDmgDice() + "+" + getDmgMod());

		if (attackRoll >= enemy.getArmorClass())
		{
			System.out.printf("%s hits %s with a(n) %d, dealing %d damage!\n", getName(), enemy.getName(), attackRoll, damageRoll);
			damagedEnemy = new HurtRanger(damagedEnemy, damageRoll);
			
			EncounterManager.getInstance().replaceRanger(enemy, damagedEnemy);
			
		}
		else
		{
			System.out.printf("%s misses %s with a(n) %d, dealing no damage!\n", getName(), enemy.getName(), attackRoll);
		}
		
		
		
		
		
		
		
		
	}
}
