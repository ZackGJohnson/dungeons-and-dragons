package encounter;

import entities.A_Ranger;
import entities.Blue;
import entities.Wolf;

public class EncounterTester
{
	 
	public static void main(String[] args)
	{
		
		A_Ranger ranger1 = new Blue();
		ranger1 = new Wolf(ranger1);
		
		A_Ranger ranger2 = new Blue();
		ranger2 = new Wolf(ranger2);
		
		A_Ranger ranger3 = new Blue();
		ranger3 = new Wolf(ranger3);
		
		A_Ranger ranger4 = new Blue();
		ranger4 = new Wolf(ranger4);
		
		
		EncounterManager.getInstance().Add(ranger1);
		EncounterManager.getInstance().Add(ranger2);
		EncounterManager.getInstance().Add(ranger3);
		EncounterManager.getInstance().Add(ranger4);
		EncounterManager.getInstance().Round();
		
		
		
	}

	

}
