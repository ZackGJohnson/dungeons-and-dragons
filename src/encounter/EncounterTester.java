package encounter;
import items.*;

import entities.A_Ranger;
import entities.A_Villain;
import entities.BigPutty;
import entities.Blue;
import entities.Boss;
import entities.IvanOoze;
import entities.Wolf;

public class EncounterTester
{

	public static void encounterTester()
	{

		A_Ranger ranger1 = new Blue();
		ranger1 = new Wolf(ranger1);
		ranger1 = new AttackUp(ranger1);
		ranger1 = new AttackUp(ranger1);
		ranger1 = new AttackUp(ranger1);
		ranger1 = new AttackUp(ranger1);
		ranger1 = new AttackUp(ranger1);
		ranger1 = new AttackUp(ranger1);
		ranger1 = new AttackUp(ranger1);
		ranger1 = new AttackUp(ranger1);
		
		
		ranger1 = new HealthUp(ranger1);
		ranger1 = new HealthUp(ranger1);
		ranger1 = new HealthUp(ranger1);
		ranger1 = new HealthUp(ranger1);
		ranger1 = new HealthUp(ranger1);
		ranger1 = new HealthUp(ranger1);
		ranger1 = new HealthUp(ranger1);
		ranger1 = new HealthUp(ranger1);
		ranger1 = new HealthUp(ranger1);

		A_Ranger ranger2 = new Blue();
		ranger2 = new Wolf(ranger2);

		A_Ranger ranger3 = new Blue();
		ranger3 = new Wolf(ranger3);

		A_Ranger ranger4 = new Blue();
		ranger4 = new Wolf(ranger4);

		A_Villain v1 = new BigPutty();
		A_Villain v3 = new BigPutty();
		A_Villain v4 = new BigPutty();

		A_Villain v2 = new Boss();
		v2 = new IvanOoze(v2);

		EncounterManager.getInstance().addEnemy(v1);
		EncounterManager.getInstance().addEnemy(v2);
		// EncounterManager.getInstance().addEnemy(v3);
		// EncounterManager.getInstance().addEnemy(v4);

		EncounterManager.getInstance().addRanger(ranger1);
		// EncounterManager.getInstance().addRanger(ranger2);
		// EncounterManager.getInstance().addRanger(ranger3);
		// EncounterManager.getInstance().addRanger(ranger4);

		EncounterManager.getInstance().stats();
		
		while (EncounterManager.getInstance().enemiesAreAlive() && EncounterManager.getInstance().rangersAreAlive())
		{
			EncounterManager.getInstance().round();
		}
		if(!EncounterManager.getInstance().enemiesAreAlive())
			System.out.println("All enemies defeated!");
		else if(!EncounterManager.getInstance().rangersAreAlive())
			System.out.println("Mission Failure!");

	}

}
