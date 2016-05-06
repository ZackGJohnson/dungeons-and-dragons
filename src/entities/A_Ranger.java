package entities;

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
      System.out.println("Enter your actions etc ");
   }

}
