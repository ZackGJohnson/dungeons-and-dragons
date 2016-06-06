package entities;

import items.HurtEnemy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.badlogic.gdx.graphics.Texture;

import encounter.EncounterManager;
import encounter.RollManager;

public abstract class A_Ranger extends A_Entity
{

	public String getType()
	{
		return "Ranger";
	}

	public String attack(int target)
	{

		A_Villain enemy = EncounterManager.getInstance().getEnemies().get(target);
		A_Villain damagedEnemy = EncounterManager.getInstance().getEnemies().get(target);

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
					damagedEnemy = new HurtEnemy(damagedEnemy, damageRoll);
					EncounterManager.getInstance().replaceEnemy(enemy, damagedEnemy);
					if (!EncounterManager.getInstance().getEnemies().get(target).isAlive())
					{
						EncounterManager.getInstance().removeEnemyAt(target);
					}
				
			}
			EncounterManager.getInstance().nextEntity();

			return ("You hit " + enemy.getName() + " with a(n) " + attackRoll + ", dealing " + damageRoll + " damage!\n");

			
		}
		else
		{
			EncounterManager.getInstance().nextEntity();
			return ("You miss " + enemy.getName() + " with a(n) " + attackRoll + ", dealing 0 damage!\n");
		}

	}
}
