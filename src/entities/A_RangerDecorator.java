package entities;

import com.badlogic.gdx.graphics.Texture;

public abstract class A_RangerDecorator extends A_Ranger
{
	protected A_Ranger ranger;
	
	protected A_RangerDecorator(A_Ranger r)
	{
		this.ranger = r;
	}
	
	public abstract int getHealth();
	public abstract int getAtkMod();
	public abstract int getDmgMod();
	public abstract String getDmgDice();
	public abstract int getDmgReduction();
	public abstract int getArmorClass();
	
	@Override
	public Texture getTexture()
	{
		return ranger.getTexture();
	}
}
