//package dungeons;

import entities.*;


public class BenTester 
{

	public static void main(String[] args) 
	{
		A_Ranger ranger = new Blue();
		ranger = new Wolf(ranger);
			
		System.out.println("Ranger's health is: " + ranger.getHealth());
		System.out.println("Ranger's atkMod is: " + ranger.getAtkMod());
		System.out.println("Ranger's dmgMod is: " + ranger.getDmgMod());
		System.out.println("Ranger's dmgDice is: " + ranger.getDmgDice());
		System.out.println("Ranger's dmgReduction is: " + ranger.getDmgReduction());
		System.out.println("Ranger's AC is: " + ranger.getArmorClass());
		
		System.out.println("=====================================================");
		
		A_Villain villain = new General();
		villain = new Goldar(villain);

		System.out.println("Villain's health is: " + villain.getHealth());
		System.out.println("Villain's atkMod is: " + villain.getAtkMod());
		System.out.println("Villain's dmgMod is: " + villain.getDmgMod());
		System.out.println("Villain's dmgDice is: " + villain.getDmgDice());
		System.out.println("Villain's dmgReduction is: " + villain.getDmgReduction());
		System.out.println("Villain's AC is: " + villain.getArmorClass());

	}

}
