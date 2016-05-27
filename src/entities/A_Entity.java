package entities;

import encounter.RollManager;

public abstract class A_Entity implements Comparable<A_Entity>
{
	protected int health;
	protected int maxHealth;
	protected boolean isAlive = true;
	protected int attackMod;
	protected int dmgMod;
	protected String dmgDice;
	protected int dmgReduction;
	protected int armorClass;
	protected int init;
	protected String _name;
	
	public String getName()
	{
		return _name;
	}
	
	public void setName(String name)
	{
		_name = name;
	}
	

	public abstract int getHealth();
	
	public abstract int getMaxHealth();

	public abstract int getAtkMod();

	public abstract int getDmgMod();

	public abstract String getDmgDice();

	public abstract int getDmgReduction();

	public abstract int getArmorClass();
	
	public boolean isAlive()
	{
		return isAlive;
	}
	
	public void die()
	{
		isAlive = false;
	}

	public int getInit()
	{
		return RollManager.getInstance().roll("1d20+0");
	}
	
	public String getStats()
	{
		return (getName() + ":Health: " + getHealth() + "/" + getMaxHealth() + ", Attack: +" + getAtkMod() + " for " + getDmgDice() + "+" + getDmgMod() + 
				"\nDefense: AC " + getArmorClass() + " DR " + getDmgReduction());
					
	}

	public abstract void turn();
	
	public int compareTo(A_Entity target)
	{
		return this.getInit() - target.getInit();
	}

}
