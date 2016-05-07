package entities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import encounter.EncounterManager;
import encounter.RollManager;

public abstract class A_Ranger
{
	protected int health;
	protected int attackMod;
	protected int dmgMod;
	protected String dmgDice;
	protected int dmgReduction;
	protected int armorClass;

	public abstract int getHealth();

	public abstract int getAtkMod();

	public abstract int getDmgMod();

	public abstract String getDmgDice();

	public abstract int getDmgReduction();

	public abstract int getArmorClass();

	public void turn()
	{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int choice = -1;
		do
		{
			System.out.println("Type 1 to attack: ");

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
		} while (choice != 1);

		if (choice == 1)
		{
			choice = -1;
			do
			{
				System.out.println("Who do you want to attack?: \n");
				for (int i = 0; i < EncounterManager.getInstance().getEnemies().size(); i++)
				{
					System.out.printf("Enter %d to attack %s\n", i, EncounterManager.getInstance().getEnemies().get(i).getName() + i);
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
			} while (choice < 0 && choice > EncounterManager.getInstance().getEnemies().size());
			attack(choice);
		}

	}

	private void attack(int target)
	{
		A_Villain enemy = EncounterManager.getInstance().getEnemies().get(target);
		int attackRoll = RollManager.getInstance().roll("1d20+" + getAtkMod());
		int damageRoll = RollManager.getInstance().roll("" + getDmgDice() + "+" + getDmgMod());

		if (attackRoll >= enemy.getArmorClass())
		{
			System.out.printf("You hit with a(n) %d, dealing %d damage!\n\n", attackRoll, damageRoll);
			// Insert actual method of damage enemy here
		}
		else
		{
			System.out.printf("You miss with a(n) %d, dealing no damage!\n\n", attackRoll);
		}
	}

}
