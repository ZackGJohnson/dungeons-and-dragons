import entities.*;



public class ZackTester 
{

	public static void main(String[] args) 
	{
		A_Villain v = new BigPutty();
			
		System.out.println("Villan health is: " + v.getHealth());
		System.out.println("Villan atkMod is: " + v.getAtkMod());
		System.out.println("Villan dmgMod is: " + v.getDmgMod());
		System.out.println("Villan dmgDice is: " + v.getDmgDice());
		System.out.println("Villan dmgReduction is: " + v.getDmgReduction());
		System.out.println("Villan AC is: " + v.getArmorClass());
		
		System.out.println("=====================================================");
		
		A_Villain villain = new Boss();
		villain = new IvanOoze(villain);

		System.out.println("Villain's health is: " + villain.getHealth());
		System.out.println("Villain's atkMod is: " + villain.getAtkMod());
		System.out.println("Villain's dmgMod is: " + villain.getDmgMod());
		System.out.println("Villain's dmgDice is: " + villain.getDmgDice());
		System.out.println("Villain's dmgReduction is: " + villain.getDmgReduction());
		System.out.println("Villain's AC is: " + villain.getArmorClass());

	}

}
