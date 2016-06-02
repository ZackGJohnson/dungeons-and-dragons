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
	
	public void turn()
	{
		if (this.getHealth() > 0)
		{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			int choice = -1;
			do
			{
				
				EncounterManager.getInstance().appendLineToTextBox(this.getName() + " turn, type 1 to attack or 0 to see stats: \n");
				System.out.println(this.getName() + " turn, type 1 to attack or 0 to see stats: ");
				

				try
				{
					//Button zone ###
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
					
					EncounterManager.getInstance().appendLineToTextBox(this.getName() + "Who do you want to attack, %s?: \n");
					System.out.println(this.getName() + "Who do you want to attack, %s?: ");
					
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
						//Button zone ###
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
				EncounterManager.getInstance().appendLineToTextBox(EncounterManager.getInstance().stats());
			}
		}
		

	}

	public String attack(int target)
	{
		
		A_Villain enemy = EncounterManager.getInstance().getEnemies().get(target);
		A_Villain damagedEnemy = EncounterManager.getInstance().getEnemies().get(target);
		
		if(enemy == null)
		{
			System.out.println("Enemy is null");
			return "null";
		}
		
		if(damagedEnemy == null)
		{
			System.out.println("Enemy is null");
			return "null";
		}
		
		if(!(enemy.isAlive()))
		{
			return "Selected enemy is dead!";
		}
		
		int attackRoll = RollManager.getInstance().roll("1d20+" + getAtkMod());
		int damageRoll = RollManager.getInstance().roll("" + getDmgDice() + "+" + getDmgMod());

		if (attackRoll >= enemy.getArmorClass())
		{
			
			//EncounterManager.getInstance().appendLineToTextBox("Note to self, add printf version of this for ease of use");
			damagedEnemy = new HurtEnemy(damagedEnemy, damageRoll);
			EncounterManager.getInstance().replaceEnemy(enemy, damagedEnemy);
			if(EncounterManager.getInstance().getEnemies().get(target).getHealth() < 1)
			{
				EncounterManager.getInstance().removeEnemyAt(target);
			}
			EncounterManager.getInstance().nextEntity();
			
			return ("You hit " + enemy.getName() + " with a(n) " + attackRoll + ", dealing " + damageRoll
					 + " damage!\n");
			
			// Insert actual method of damage enemy here
		}
		else
		{
			EncounterManager.getInstance().nextEntity();
			return ("You miss " + enemy.getName() + " with a(n) " + attackRoll + ", dealing 0 damage!\n");
		}
		
		
	}
}
