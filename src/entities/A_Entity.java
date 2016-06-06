package entities;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;

import encounter.EncounterManager;
import encounter.RollManager;

public abstract class A_Entity implements Comparable<A_Entity>
{
	protected int health;
	protected int maxHealth;
	protected int attackMod;
	protected int dmgMod;
	protected String dmgDice;
	protected int dmgReduction;
	protected int armorClass;
	protected int init;
	protected String _name;
	protected int _point;
	public Texture _texture;
	private String _loot = "Bandage";

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
		if (getHealth() <= 0)
			return false;
		else return true;
	}

	public void die()
	{
		Random random = new Random();
		boolean giveBandage = random.nextBoolean();
		if (giveBandage ||  !_loot.equalsIgnoreCase("bandage"))
		{
			EncounterManager.getInstance().addItem(_loot);
		}
	}

	public void setLoot(String loot)
	{
		_loot = loot;
	}

	public String getLoot()
	{
		return _loot;
	}

	public int getInit()
	{
		return RollManager.getInstance().roll("1d20+0");
	}

	public abstract String attack(int target);

	public String getStats()
	{
		String stats = "";

		if (getName() != null)
			stats = stats + getName();
		else stats = stats + "null";

		if (getHealth() > 0)
			stats = stats + ": Health: " + getHealth();
		else stats = stats + ": Health: " + getHealth();

		if (getMaxHealth() > 0)
			stats = stats + "/" + getMaxHealth();
		else stats = stats + "/" + getMaxHealth();

		if (getAtkMod() > 0)
			stats = stats + ", Attack: +" + getAtkMod();
		else stats = stats + ", Attack: +" + getAtkMod();

		if (getDmgDice() != null)
			stats = stats + " for " + getDmgDice();
		else stats = stats + "null";

		if (getDmgMod() > 0)
			stats = stats + "+" + getDmgMod();
		else stats = stats + "+" + getDmgMod();

		if (getArmorClass() > 0)
			stats = stats + "\nDefense: AC " + getArmorClass();
		else stats = stats + "\nDefense: AC " + getArmorClass();

		if (getDmgReduction() > 0)
			stats = stats + " DR " + getDmgReduction();
		else stats = stats + " DR " + getDmgReduction();
		return stats;

	}

	public int compareTo(A_Entity target)
	{
		return this.getInit() - target.getInit();
	}

	public Texture getTexture()
	{
		if (_texture == null)
		{
			System.out.println("NULL TEXTURE FOR " + this.getName());
			return Red._redRangerTexture;
		}
		return _texture;
	}
}
