package entities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

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
		}
		while (choice != 1);
		
		
		if (choice == 1)
		{
			System.out.printf("You attack with a(n) %d, dealing %d damage!\n\n", RollManager.getInstance().roll("1d20+" + getAtkMod()), RollManager.getInstance().roll("" + getDmgDice() + "+" + getDmgMod()));
		}
		
		
	}

}
