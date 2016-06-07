package unitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import encounter.*;
import entities.*;


public class EncounterTest
{

	@Test
	public void testEmptyRanger()
	{//Ranger 0
		assert (EncounterManager.getInstance().getRangers().size() == 0);
	}

	@Test
	public void testEmptyEnemy()
	{//Enemy 0
		assert (EncounterManager.getInstance().getEnemies().size() == 0);
	}
	@Test
	public void testOneEnemy()
	{//
		EncounterManager.getInstance().addEnemy(new SmallPutty());
		assert (EncounterManager.getInstance().getEnemies().size() == 1);
	}
	@Test
	public void testOneRanger()
	{//
		EncounterManager.getInstance().addRanger(new Red());
		assert (EncounterManager.getInstance().getRangers().size() == 1);
	}
	
	@Test
	public void testRemoveEnemy()
	{//
		EncounterManager.getInstance().removeEnemyAt(0);
		assert (EncounterManager.getInstance().getEnemies().size() == 0);
	}
	@Test
	public void testRemoveRanger()
	{//
		EncounterManager.getInstance().removeRangerAt(0);
		assert (EncounterManager.getInstance().getRangers().size() == 0);
	}
	@Test
	public void testCurrRanger()
	{//
		assert (EncounterManager.getInstance().getRangers().getFirst().equals(EncounterManager.getInstance().getCurr()));
	}
	
	@Test
	public void testCurrNext()
	{//
		A_Entity curr = EncounterManager.getInstance().getCurr();
		EncounterManager.getInstance().nextEntity();
		assert (curr.equals(EncounterManager.getInstance().getCurr()));
	}
	
	
	
	
}
