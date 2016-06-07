package entities;

import items.HurtEnemy;
import items.HurtRanger;
import encounter.EncounterManager;
import encounter.RollManager;

public abstract class A_Villain extends A_Entity
{

	private String _type = "Enemy";

	public String getType()
	{
		return _type;
	}

	public void setType(String type)
	{
		_type = type;
	}
	public String attack(int target)
	{
		A_Ranger enemy = EncounterManager.getInstance().getRangers().get(target);
		A_Ranger damagedEnemy = EncounterManager.getInstance().getRangers().get(target);
		if (enemy == null)
		{
			System.out.println("Enemy is null");
			return "null";
		}

		if (damagedEnemy == null)
		{
			System.out.println("Enemy is null");
			return "null";
		}

		if (!(enemy.isAlive()))
		{
			return "Selected enemy is dead!";
		}

		int attackRoll = RollManager.getInstance().roll("1d20+" + getAtkMod());
		int damageRoll = RollManager.getInstance().roll("" + getDmgDice() + "+" + getDmgMod());

		if (attackRoll >= enemy.getArmorClass())
		{
			if (damageRoll - enemy.getDmgReduction() > 0)
			{

				damagedEnemy = new HurtRanger(damagedEnemy, damageRoll);
				EncounterManager.getInstance().replaceRanger(enemy, damagedEnemy);
				if (!EncounterManager.getInstance().getRangers().get(target).isAlive())
				{
					EncounterManager.getInstance().removeRangerAt(target);
				}
			}
			EncounterManager.getInstance().nextEntity();

			return (getName() + " hits " + enemy.getName() + " with a(n) " + attackRoll + ", dealing " + damageRoll + " damage!\n");

		}
		else
		{

			return (getName() + " misses " + enemy.getName() + " with a(n) " + attackRoll + ", dealing 0 damage!\n");
		}

	}
}
