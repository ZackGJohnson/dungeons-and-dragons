package entities;

import com.badlogic.gdx.graphics.Texture;

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
	protected int _point;
	
	public String getType()
	{
		return "Entity";
	}
	
	public int getPoint()
	{
		return 1;
	}
	
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
		if(getHealth() <= 0)
			return false;
		else
			return true;
	}
	
	public void die()
	{
		isAlive = false;
	}

	public int getInit()
	{
		return RollManager.getInstance().roll("1d20+0");
	}
	
	public abstract String attack(int target);
	
	public String getStats()
	{
		String stats = "";
		
		if(getName() != null)
			stats = stats + getName();
		else
			stats = stats + "null";
		
		if(getHealth() > 0)
			stats = stats + ": Health: " + getHealth();
		else
			stats = stats + ": Health: " + getHealth();
		
		if(getMaxHealth() > 0)
			stats = stats + "/" + getMaxHealth();
		else
			stats = stats + "/" + getMaxHealth();
		
		if(getAtkMod() > 0)
			stats = stats + ", Attack: +" + getAtkMod();
		else
			stats = stats + ", Attack: +" + getAtkMod();
		
		if(getDmgDice() != null)
			stats = stats + " for " + getDmgDice();
		else
			stats = stats + "null";
		
		if(getDmgMod() > 0)
			stats = stats + "+" + getDmgMod();
		else
			stats = stats + "+" + getDmgMod();
		
		if(getArmorClass() > 0)
			stats = stats + "\nDefense: AC " + getArmorClass();
		else
			stats = stats + "\nDefense: AC " + getArmorClass();
		
		if(getDmgReduction() > 0)
			stats = stats + " DR " + getDmgReduction();
		else
			stats = stats + " DR " + getDmgReduction();
		return stats;
					
	}

	public abstract void turn();
	
	public int compareTo(A_Entity target)
	{
		return this.getInit() - target.getInit();
	}

	// Return a default texture. This method should be overrided and should return the proper texture for that entity.
		public Texture getTexture()
		{
			return Red._redRangerTexture;
		}
}
