package entities;


import items.HurtEnemy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import encounter.EncounterManager;
import encounter.RollManager;

public abstract class A_Ranger extends A_Entity
{

	public String getName()
	{
		return "Test Ranger";
	}

	public void turn()
	{
		if (this.getHealth() > 0)
		{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			int choice = -1;
			do
			{
				System.out.println(getStats());
				System.out.printf("%s turn, type 1 to attack or 0 to see stats: \n", this.getName());
				

				try
				{
					choice = Integer.parseInt(input.readLine());
				}
				catch (NumberFormatException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} while (choice != 1 && choice != 0);

			if (choice == 1)
			{
				choice = -1;
				do
				{
					System.out.printf("Who do you want to attack, %s?: \n", this.getName());
					for (int i = 0; i < EncounterManager.getInstance().getEnemies().size(); i++)
					{
						A_Villain option = EncounterManager.getInstance().getEnemies().get(i);
						if(option.getHealth() > 0)
							System.out.printf("Enter %d to attack %s. (%d/%d health)\n", i, option.getName(), option.getHealth(), option.getMaxHealth());
						else
							System.out.printf("%s is dead\n", option.getName());
					}

					try
					{
						choice = Integer.parseInt(input.readLine());
					}
					catch (NumberFormatException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					catch (IOException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} while (choice < 0 && choice > EncounterManager.getInstance().getEnemies().size() && EncounterManager.getInstance().getEnemies().get(choice).isAlive());
				attack(choice);
			}
			else if(choice == 0)
			{
				EncounterManager.getInstance().stats();
			}
		}
		

	}

	private void attack(int target)
	{
		A_Villain enemy = EncounterManager.getInstance().getEnemies().get(target);
		A_Villain damagedEnemy = EncounterManager.getInstance().getEnemies().get(target);
		int attackRoll = RollManager.getInstance().roll("1d20+" + getAtkMod());
		int damageRoll = RollManager.getInstance().roll("" + getDmgDice() + "+" + getDmgMod());

		if (attackRoll >= enemy.getArmorClass())
		{
			System.out.printf("You hit %s with a(n) %d, dealing %d damage!\n", enemy.getName(), attackRoll, damageRoll);
			damagedEnemy = new HurtEnemy(damagedEnemy, damageRoll);
			
			EncounterManager.getInstance().replaceEnemy(enemy, damagedEnemy);
			// Insert actual method of damage enemy here
		}
		else
		{
			System.out.printf("You miss %s with a(n) %d, dealing no damage!\n", enemy.getName(), attackRoll);
		}
	}

}
