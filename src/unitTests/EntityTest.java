package unitTests;

import static org.junit.Assert.*;
import items.boss.*;
import items.*;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.*;
import entities.bosses.*;


public class EntityTest {
	
	A_Ranger test;
	@Before
	public void setUp() throws Exception{
		test = new Blue();
	}
	
	@After
	public void tearDown() throws Exception{
		
	}
	
	@Test
	public void testBaseBlueStats(){
		A_Ranger blue = new Blue();
		assertEquals(10, blue.getHealth());
		assertEquals(2, blue.getAtkMod());
		assertEquals(3, blue.getDmgMod());
		assertEquals("2d6", blue.getDmgDice());
		assertEquals(0, blue.getDmgReduction());
		assertEquals(10, blue.getArmorClass());
	}
	
	@Test
	public void testBaseBlackStats(){
		A_Ranger black = new Black();
		assertEquals(16, black.getHealth());
		assertEquals(1, black.getAtkMod());
		assertEquals(3, black.getDmgMod());
		assertEquals("1d10", black.getDmgDice());
		assertEquals(0, black.getDmgReduction());
		assertEquals(14, black.getArmorClass());
	}
	
	@Test
	public void testBaseWhiteStats(){
		A_Ranger white = new White();
		assertEquals(14, white.getHealth());
		assertEquals(2, white.getAtkMod());
		assertEquals(2, white.getDmgMod());
		assertEquals("2d4", white.getDmgDice());
		assertEquals(3, white.getDmgReduction());
		assertEquals(15, white.getArmorClass());
	}
	
	@Test
	public void testBasePinkStats(){
		A_Ranger pink = new Pink();
		assertEquals(12, pink.getHealth());
		assertEquals(2, pink.getAtkMod());
		assertEquals(2, pink.getDmgMod());
		assertEquals("1d8", pink.getDmgDice());
		assertEquals(1, pink.getDmgReduction());
		assertEquals(14, pink.getArmorClass());
	}
	
	@Test
	public void testBaseRedStats(){
		A_Ranger red = new Red();
		assertEquals(13, red.getHealth());
		assertEquals(2, red.getAtkMod());
		assertEquals(2, red.getDmgMod());
		assertEquals("1d8", red.getDmgDice());
		assertEquals(1, red.getDmgReduction());
		assertEquals(14, red.getArmorClass());
	}
	
	@Test
	public void testBaseYellowStats(){
		A_Ranger yellow = new Yellow();
		assertEquals(10, yellow.getHealth());
		assertEquals(3, yellow.getAtkMod());
		assertEquals(0, yellow.getDmgMod());
		assertEquals("1d12", yellow.getDmgDice());
		assertEquals(0, yellow.getDmgReduction());
		assertEquals(18, yellow.getArmorClass());
	}
	
	@Test
	public void testBlueWolfStats(){
		A_Ranger blue = new Blue();
		blue = new Wolf(blue);
		assertEquals(10, blue.getHealth());
		assertEquals(3, blue.getAtkMod());
		assertEquals(3, blue.getDmgMod());
		assertEquals("2d6", blue.getDmgDice());
		assertEquals(0, blue.getDmgReduction());
		assertEquals(12, blue.getArmorClass());
	}
	
	@Test
	public void testBlueApeStats(){
		A_Ranger blue = new Blue();
		blue = new Ape(blue);
		assertEquals(11, blue.getHealth());
		assertEquals(1, blue.getAtkMod());
		assertEquals(5, blue.getDmgMod());
		assertEquals("2d6", blue.getDmgDice());
		assertEquals(0, blue.getDmgReduction());
		assertEquals(10, blue.getArmorClass());
	}
	
	@Test
	public void testBlueFrogStats(){
		A_Ranger blue = new Blue();
		blue = new Frog(blue);
		assertEquals(10, blue.getHealth());
		assertEquals(2, blue.getAtkMod());
		assertEquals(2, blue.getDmgMod());
		assertEquals("2d6", blue.getDmgDice());
		assertEquals(2, blue.getDmgReduction());
		assertEquals(11, blue.getArmorClass());
	}
	
	@Test
	public void testBlueCraneStats(){
		A_Ranger blue = new Blue();
		blue = new Crane(blue);
		assertEquals(9, blue.getHealth());
		assertEquals(4, blue.getAtkMod());
		assertEquals(3, blue.getDmgMod());
		assertEquals("2d6", blue.getDmgDice());
		assertEquals(0, blue.getDmgReduction());
		assertEquals(11, blue.getArmorClass());
	}
	
	@Test
	public void testBlueFalconStats(){
		A_Ranger blue = new Blue();
		blue = new Falcon(blue);
		assertEquals(10, blue.getHealth());
		assertEquals(4, blue.getAtkMod());
		assertEquals(4, blue.getDmgMod());
		assertEquals("2d6", blue.getDmgDice());
		assertEquals(0, blue.getDmgReduction());
		assertEquals(10, blue.getArmorClass());
	}
	
	@Test
	public void testBlueBearStats(){
		A_Ranger blue = new Blue();
		blue = new Bear(blue);
		assertEquals(12, blue.getHealth());
		assertEquals(1, blue.getAtkMod());
		assertEquals(4, blue.getDmgMod());
		assertEquals("2d6", blue.getDmgDice());
		assertEquals(0, blue.getDmgReduction());
		assertEquals(10, blue.getArmorClass());
	}
	
	@Test
	public void testRedWolfStats(){
		A_Ranger red = new Red();
		red = new Wolf(red);
		assertEquals(13, red.getHealth());
		assertEquals(3, red.getAtkMod());
		assertEquals(2, red.getDmgMod());
		assertEquals("1d8", red.getDmgDice());
		assertEquals(0, red.getDmgReduction());
		assertEquals(16, red.getArmorClass());
	}
	
	@Test
	public void testRedApeStats(){
		A_Ranger red = new Red();
		red = new Ape(red);
		assertEquals(14, red.getHealth());
		assertEquals(1, red.getAtkMod());
		assertEquals(4, red.getDmgMod());
		assertEquals("1d8", red.getDmgDice());
		assertEquals(1, red.getDmgReduction());
		assertEquals(14, red.getArmorClass());
	}
	
	@Test
	public void testRedFrogStats(){
		A_Ranger red = new Red();
		red = new Frog(red);
		assertEquals(13, red.getHealth());
		assertEquals(2, red.getAtkMod());
		assertEquals(1, red.getDmgMod());
		assertEquals("1d8", red.getDmgDice());
		assertEquals(3, red.getDmgReduction());
		assertEquals(15, red.getArmorClass());
	}
	
	@Test
	public void testRedCraneStats(){
		A_Ranger red = new Red();
		red = new Crane(red);
		assertEquals(12, red.getHealth());
		assertEquals(4, red.getAtkMod());
		assertEquals(2, red.getDmgMod());
		assertEquals("1d8", red.getDmgDice());
		assertEquals(1, red.getDmgReduction());
		assertEquals(15, red.getArmorClass());
	}
	
	@Test
	public void testRedFalconStats(){
		A_Ranger red = new Red();
		red = new Falcon(red);
		assertEquals(13, red.getHealth());
		assertEquals(4, red.getAtkMod());
		assertEquals(3, red.getDmgMod());
		assertEquals("1d8", red.getDmgDice());
		assertEquals(0, red.getDmgReduction());
		assertEquals(14, red.getArmorClass());
	}
	
	@Test
	public void testRedBearStats(){
		A_Ranger red = new Red();
		red = new Bear(red);
		assertEquals(15, red.getHealth());
		assertEquals(1, red.getAtkMod());
		assertEquals(3, red.getDmgMod());
		assertEquals("1d8", red.getDmgDice());
		assertEquals(1, red.getDmgReduction());
		assertEquals(14, red.getArmorClass());
	}
	
	@Test
	public void testWhiteWolfStats(){
		A_Ranger white = new White();
		white = new Wolf(white);
		assertEquals(14, white.getHealth());
		assertEquals(3, white.getAtkMod());
		assertEquals(2, white.getDmgMod());
		assertEquals("2d4", white.getDmgDice());
		assertEquals(2, white.getDmgReduction());
		assertEquals(17, white.getArmorClass());
	}
	
	@Test
	public void testWhiteApeStats(){
		A_Ranger white = new White();
		white = new Ape(white);
		assertEquals(15, white.getHealth());
		assertEquals(1, white.getAtkMod());
		assertEquals(4, white.getDmgMod());
		assertEquals("2d4", white.getDmgDice());
		assertEquals(3, white.getDmgReduction());
		assertEquals(15, white.getArmorClass());
	}
	
	@Test
	public void testWhiteFrogStats(){
		A_Ranger white = new White();
		white = new Frog(white);
		assertEquals(14, white.getHealth());
		assertEquals(2, white.getAtkMod());
		assertEquals(1, white.getDmgMod());
		assertEquals("2d4", white.getDmgDice());
		assertEquals(5, white.getDmgReduction());
		assertEquals(16, white.getArmorClass());
	}
	
	@Test
	public void testWhiteCraneStats(){
		A_Ranger white = new White();
		white = new Crane(white);
		assertEquals(13, white.getHealth());
		assertEquals(4, white.getAtkMod());
		assertEquals(2, white.getDmgMod());
		assertEquals("2d4", white.getDmgDice());
		assertEquals(3, white.getDmgReduction());
		assertEquals(16, white.getArmorClass());
	}
	
	@Test
	public void testWhiteFalconStats(){
		A_Ranger white = new White();
		white = new Falcon(white);
		assertEquals(14, white.getHealth());
		assertEquals(4, white.getAtkMod());
		assertEquals(3, white.getDmgMod());
		assertEquals("2d4", white.getDmgDice());
		assertEquals(2, white.getDmgReduction());
		assertEquals(15, white.getArmorClass());
	}
	
	@Test
	public void testWhiteBearStats(){
		A_Ranger white = new White();
		white = new Bear(white);
		assertEquals(16, white.getHealth());
		assertEquals(1, white.getAtkMod());
		assertEquals(3, white.getDmgMod());
		assertEquals("2d4", white.getDmgDice());
		assertEquals(3, white.getDmgReduction());
		assertEquals(15, white.getArmorClass());
	}
	
	@Test
	public void testPinkWolfStats(){
		A_Ranger pink = new Pink();
		pink = new Wolf(pink);
		assertEquals(12, pink.getHealth());
		assertEquals(3, pink.getAtkMod());
		assertEquals(2, pink.getDmgMod());
		assertEquals("1d8", pink.getDmgDice());
		assertEquals(0, pink.getDmgReduction());
		assertEquals(16, pink.getArmorClass());
	}
	
	@Test
	public void testPinkApeStats(){
		A_Ranger pink = new Pink();
		pink = new Ape(pink);
		assertEquals(13, pink.getHealth());
		assertEquals(1, pink.getAtkMod());
		assertEquals(4, pink.getDmgMod());
		assertEquals("1d8", pink.getDmgDice());
		assertEquals(1, pink.getDmgReduction());
		assertEquals(14, pink.getArmorClass());
	}
	
	@Test
	public void testPinkFrogStats(){
		A_Ranger pink = new Pink();
		pink = new Frog(pink);
		assertEquals(12, pink.getHealth());
		assertEquals(2, pink.getAtkMod());
		assertEquals(1, pink.getDmgMod());
		assertEquals("1d8", pink.getDmgDice());
		assertEquals(3, pink.getDmgReduction());
		assertEquals(15, pink.getArmorClass());
	}
	
	@Test
	public void testPinkCraneStats(){
		A_Ranger pink = new Pink();
		pink = new Crane(pink);
		assertEquals(11, pink.getHealth());
		assertEquals(4, pink.getAtkMod());
		assertEquals(2, pink.getDmgMod());
		assertEquals("1d8", pink.getDmgDice());
		assertEquals(1, pink.getDmgReduction());
		assertEquals(15, pink.getArmorClass());
	}
	
	@Test
	public void testPinkFalconStats(){
		A_Ranger pink = new Pink();
		pink = new Falcon(pink);
		assertEquals(12, pink.getHealth());
		assertEquals(4, pink.getAtkMod());
		assertEquals(3, pink.getDmgMod());
		assertEquals("1d8", pink.getDmgDice());
		assertEquals(0, pink.getDmgReduction());
		assertEquals(14, pink.getArmorClass());
	}
	
	@Test
	public void testPinkBearStats(){
		A_Ranger pink = new Pink();
		pink = new Bear(pink);
		assertEquals(14, pink.getHealth());
		assertEquals(1, pink.getAtkMod());
		assertEquals(3, pink.getDmgMod());
		assertEquals("1d8", pink.getDmgDice());
		assertEquals(1, pink.getDmgReduction());
		assertEquals(14, pink.getArmorClass());
	}
	
	@Test
	public void testYellowWolfStats(){
		A_Ranger yellow = new Yellow();
		yellow = new Wolf(yellow);
		assertEquals(10, yellow.getHealth());
		assertEquals(4, yellow.getAtkMod());
		assertEquals(0, yellow.getDmgMod());
		assertEquals("1d12", yellow.getDmgDice());
		assertEquals(0, yellow.getDmgReduction());
		assertEquals(20, yellow.getArmorClass());
	}
	
	@Test
	public void testYellowApeStats(){
		A_Ranger yellow = new Yellow();
		yellow = new Ape(yellow);
		assertEquals(11, yellow.getHealth());
		assertEquals(2, yellow.getAtkMod());
		assertEquals(2, yellow.getDmgMod());
		assertEquals("1d12", yellow.getDmgDice());
		assertEquals(0, yellow.getDmgReduction());
		assertEquals(18, yellow.getArmorClass());
	}
	
	@Test
	public void testYellowFrogStats(){
		A_Ranger yellow = new Yellow();
		yellow = new Frog(yellow);
		assertEquals(10, yellow.getHealth());
		assertEquals(3, yellow.getAtkMod());
		assertEquals(-1, yellow.getDmgMod());
		assertEquals("1d12", yellow.getDmgDice());
		assertEquals(2, yellow.getDmgReduction());
		assertEquals(19, yellow.getArmorClass());
	}
	
	@Test
	public void testYellowCraneStats(){
		A_Ranger yellow = new Yellow();
		yellow = new Crane(yellow);
		assertEquals(9, yellow.getHealth());
		assertEquals(5, yellow.getAtkMod());
		assertEquals(0, yellow.getDmgMod());
		assertEquals("1d12", yellow.getDmgDice());
		assertEquals(0, yellow.getDmgReduction());
		assertEquals(19, yellow.getArmorClass());
	}
	
	@Test
	public void testYellowFalconStats(){
		A_Ranger yellow = new Yellow();
		yellow = new Falcon(yellow);
		assertEquals(10, yellow.getHealth());
		assertEquals(5, yellow.getAtkMod());
		assertEquals(1, yellow.getDmgMod());
		assertEquals("1d12", yellow.getDmgDice());
		assertEquals(0, yellow.getDmgReduction());
		assertEquals(18, yellow.getArmorClass());
	}
	
	@Test
	public void testYellowBearStats(){
		A_Ranger yellow = new Yellow();
		yellow = new Bear(yellow);
		assertEquals(12, yellow.getHealth());
		assertEquals(2, yellow.getAtkMod());
		assertEquals(1, yellow.getDmgMod());
		assertEquals("1d12", yellow.getDmgDice());
		assertEquals(0, yellow.getDmgReduction());
		assertEquals(18, yellow.getArmorClass());
	}
	
	@Test
	public void testBlackWolfStats(){
		A_Ranger black = new Black();
		black = new Wolf(black);
		assertEquals(16, black.getHealth());
		assertEquals(2, black.getAtkMod());
		assertEquals(3, black.getDmgMod());
		assertEquals("1d10", black.getDmgDice());
		assertEquals(0, black.getDmgReduction());
		assertEquals(16, black.getArmorClass());
	}
	
	@Test
	public void testBlackApeStats(){
		A_Ranger black = new Black();
		black = new Ape(black);
		assertEquals(17, black.getHealth());
		assertEquals(0, black.getAtkMod());
		assertEquals(5, black.getDmgMod());
		assertEquals("1d10", black.getDmgDice());
		assertEquals(0, black.getDmgReduction());
		assertEquals(14, black.getArmorClass());
	}
	
	@Test
	public void testBlackFrogStats(){
		A_Ranger black = new Black();
		black = new Frog(black);
		assertEquals(16, black.getHealth());
		assertEquals(1, black.getAtkMod());
		assertEquals(2, black.getDmgMod());
		assertEquals("1d10", black.getDmgDice());
		assertEquals(2, black.getDmgReduction());
		assertEquals(15, black.getArmorClass());
	}
	
	@Test
	public void testBlackCraneStats(){
		A_Ranger black = new Black();
		black = new Crane(black);
		assertEquals(15, black.getHealth());
		assertEquals(3, black.getAtkMod());
		assertEquals(3, black.getDmgMod());
		assertEquals("1d10", black.getDmgDice());
		assertEquals(0, black.getDmgReduction());
		assertEquals(15, black.getArmorClass());
	}
	
	@Test
	public void testBlackFalconStats(){
		A_Ranger black = new Black();
		black = new Falcon(black);
		assertEquals(16, black.getHealth());
		assertEquals(3, black.getAtkMod());
		assertEquals(4, black.getDmgMod());
		assertEquals("1d10", black.getDmgDice());
		assertEquals(0, black.getDmgReduction());
		assertEquals(14, black.getArmorClass());
	}
	
	@Test
	public void testBlackBearStats(){
		A_Ranger black = new Black();
		black = new Bear(black);
		assertEquals(18, black.getHealth());
		assertEquals(0, black.getAtkMod());
		assertEquals(4, black.getDmgMod());
		assertEquals("1d10", black.getDmgDice());
		assertEquals(0, black.getDmgReduction());
		assertEquals(14, black.getArmorClass());
	}
	
	@Test
	public void testSmallPuttyStats(){
		A_Villain small = new SmallPutty();
		assertEquals(10, small.getHealth());
		assertEquals(1, small.getAtkMod());
		assertEquals(2, small.getDmgMod());
		assertEquals("1d10", small.getDmgDice());
		assertEquals(0, small.getDmgReduction());
		assertEquals(14, small.getArmorClass());
	}
	
	@Test
	public void testBigPuttyStats(){
		A_Villain big = new BigPutty();
		assertEquals(12, big.getHealth());
		assertEquals(2, big.getAtkMod());
		assertEquals(2, big.getDmgMod());
		assertEquals("1d10", big.getDmgDice());
		assertEquals(1, big.getDmgReduction());
		assertEquals(14, big.getArmorClass());
	}
	
	@Test
	public void testGeneralBaseStats(){
		A_Villain general = new General();
		assertEquals(15, general.getHealth());
		assertEquals(3, general.getAtkMod());
		assertEquals(2, general.getDmgMod());
		assertEquals("1d10", general.getDmgDice());
		assertEquals(2, general.getDmgReduction());
		assertEquals(12, general.getArmorClass());
	}
	
	@Test
	public void testFinsterStats(){
		A_Villain finster = new General();
		finster = new Finster(finster);
		assertEquals(16, finster.getHealth());
		assertEquals(2, finster.getAtkMod());
		assertEquals(2, finster.getDmgMod());
		assertEquals("1d10", finster.getDmgDice());
		assertEquals(2, finster.getDmgReduction());
		assertEquals(11, finster.getArmorClass());
	}
	
	@Test
	public void testMordantStats(){
		A_Villain mordant = new General();
		mordant = new Mordant(mordant);
		assertEquals(16, mordant.getHealth());
		assertEquals(2, mordant.getAtkMod());
		assertEquals(2, mordant.getDmgMod());
		assertEquals("1d10", mordant.getDmgDice());
		assertEquals(2, mordant.getDmgReduction());
		assertEquals(11, mordant.getArmorClass());
	}
	
	@Test
	public void testGoldarStats(){
		A_Villain goldar = new General();
		goldar = new Goldar(goldar);
		assertEquals(20, goldar.getHealth());
		assertEquals(4, goldar.getAtkMod());
		assertEquals(4, goldar.getDmgMod());
		assertEquals("1d10", goldar.getDmgDice());
		assertEquals(4, goldar.getDmgReduction());
		assertEquals(15, goldar.getArmorClass());
	}
	
	@Test
	public void testRitoStats(){
		A_Villain rito = new General();
		rito = new Rito(rito);
		assertEquals(20, rito.getHealth());
		assertEquals(4, rito.getAtkMod());
		assertEquals(4, rito.getDmgMod());
		assertEquals("1d10", rito.getDmgDice());
		assertEquals(4, rito.getDmgReduction());
		assertEquals(15, rito.getArmorClass());
	}
	
	@Test
	public void testRitaStats(){
		A_Villain rita = new General();
		rita = new Rita(rita);
		assertEquals(18, rita.getHealth());
		assertEquals(3, rita.getAtkMod());
		assertEquals(3, rita.getDmgMod());
		assertEquals("1d10", rita.getDmgDice());
		assertEquals(2, rita.getDmgReduction());
		assertEquals(14, rita.getArmorClass());
	}
	
	@Test
	public void testThraxStats(){
		A_Villain thrax = new General();
		thrax = new Thrax(thrax);
		assertEquals(18, thrax.getHealth());
		assertEquals(3, thrax.getAtkMod());
		assertEquals(3, thrax.getDmgMod());
		assertEquals("1d10", thrax.getDmgDice());
		assertEquals(2, thrax.getDmgReduction());
		assertEquals(14, thrax.getArmorClass());
	}
	
	@Test
	public void testScorpinaStats(){
		A_Villain scorpina = new General();
		scorpina = new Scorpina(scorpina);
		assertEquals(17, scorpina.getHealth());
		assertEquals(5, scorpina.getAtkMod());
		assertEquals(2, scorpina.getDmgMod());
		assertEquals("1d10", scorpina.getDmgDice());
		assertEquals(2, scorpina.getDmgReduction());
		assertEquals(16, scorpina.getArmorClass());
	}
	
	@Test
	public void testLipsyncerStats(){
		A_Villain lipsyncher = new General();
		lipsyncher = new Lipsyncher(lipsyncher);
		assertEquals(17, lipsyncher.getHealth());
		assertEquals(5, lipsyncher.getAtkMod());
		assertEquals(2, lipsyncher.getDmgMod());
		assertEquals("1d10", lipsyncher.getDmgDice());
		assertEquals(2, lipsyncher.getDmgReduction());
		assertEquals(16, lipsyncher.getArmorClass());
	}
	
	@Test
	public void testBossBaseStats(){
		A_Villain boss = new Boss();
		assertEquals(15, boss.getHealth());
		assertEquals(3, boss.getAtkMod());
		assertEquals(2, boss.getDmgMod());
		assertEquals("1d10", boss.getDmgDice());
		assertEquals(2, boss.getDmgReduction());
		assertEquals(12, boss.getArmorClass());
	}
	
	@Test
	public void testLordZedStats(){
		A_Villain zed = new Boss();
		zed = new LordZed(zed);
		assertEquals(20, zed.getHealth());
		assertEquals(4, zed.getAtkMod());
		assertEquals(4, zed.getDmgMod());
		assertEquals("1d10", zed.getDmgDice());
		assertEquals(4, zed.getDmgReduction());
		assertEquals(15, zed.getArmorClass());
	}
	
	@Test
	public void testIvanOozeStats(){
		A_Villain ooze = new Boss();
		ooze = new IvanOoze(ooze);
		assertEquals(30, ooze.getHealth());
		assertEquals(4, ooze.getAtkMod());
		assertEquals(4, ooze.getDmgMod());
		assertEquals("1d10", ooze.getDmgDice());
		assertEquals(4, ooze.getDmgReduction());
		assertEquals(15, ooze.getArmorClass());
	}
	
	@Test
	public void testGoldarWeaponStats(){
		A_Ranger blue = new Blue();
		blue = new Wolf(blue);
		blue = new GoldarsBlade(blue);
		assertEquals(12, blue.getHealth());
		assertEquals(4, blue.getAtkMod());
		assertEquals(5, blue.getDmgMod());
		assertEquals(1, blue.getDmgReduction());
		assertEquals(13, blue.getArmorClass());
	}
	
	@Test
	public void testRitoWeaponStats(){
		A_Ranger blue = new Blue();
		blue = new Wolf(blue);
		blue = new RitosSword(blue);
		assertEquals(12, blue.getHealth());
		assertEquals(4, blue.getAtkMod());
		assertEquals(5, blue.getDmgMod());
		assertEquals(1, blue.getDmgReduction());
		assertEquals(13, blue.getArmorClass());
	}
	
	@Test
	public void testRitaWeaponStats(){
		A_Ranger blue = new Blue();
		blue = new Wolf(blue);
		blue = new RitasStaff(blue);
		assertEquals(13, blue.getHealth());
		assertEquals(4, blue.getAtkMod());
		assertEquals(5, blue.getDmgMod());
		assertEquals(1, blue.getDmgReduction());
		assertEquals(12, blue.getArmorClass());
	}
	
	@Test
	public void testThraxWeaponStats(){
		A_Ranger blue = new Blue();
		blue = new Wolf(blue);
		blue = new ThraxsStaff(blue);
		assertEquals(13, blue.getHealth());
		assertEquals(4, blue.getAtkMod());
		assertEquals(5, blue.getDmgMod());
		assertEquals(1, blue.getDmgReduction());
		assertEquals(12, blue.getArmorClass());
	}
	
	@Test
	public void testFinsterWeaponStats(){
		A_Ranger blue = new Blue();
		blue = new Wolf(blue);
		blue = new FinstersMonocle(blue);
		assertEquals(12, blue.getHealth());
		assertEquals(3, blue.getAtkMod());
		assertEquals(3, blue.getDmgMod());
		assertEquals(1, blue.getDmgReduction());
		assertEquals(14, blue.getArmorClass());
	}
	
	@Test
	public void testMordantWeaponStats(){
		A_Ranger blue = new Blue();
		blue = new Wolf(blue);
		blue = new MordantsPlate(blue);
		assertEquals(12, blue.getHealth());
		assertEquals(3, blue.getAtkMod());
		assertEquals(3, blue.getDmgMod());
		assertEquals(1, blue.getDmgReduction());
		assertEquals(14, blue.getArmorClass());
	}
	
	@Test
	public void testScorpinaWeaponStats(){
		A_Ranger blue = new Blue();
		blue = new Wolf(blue);
		blue = new ScorpinasBoomerang(blue);
		assertEquals(11, blue.getHealth());
		assertEquals(6, blue.getAtkMod());
		assertEquals(4, blue.getDmgMod());
		assertEquals(0, blue.getDmgReduction());
		assertEquals(14, blue.getArmorClass());
	}
	
	@Test
	public void testLipsynhcerWeaponStats(){
		A_Ranger blue = new Blue();
		blue = new Wolf(blue);
		blue = new LipsynchersKris(blue);
		assertEquals(11, blue.getHealth());
		assertEquals(6, blue.getAtkMod());
		assertEquals(4, blue.getDmgMod());
		assertEquals(0, blue.getDmgReduction());
		assertEquals(14, blue.getArmorClass());
	}
}
