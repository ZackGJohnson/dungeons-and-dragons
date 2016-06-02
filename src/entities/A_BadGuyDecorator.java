package entities;

import com.badlogic.gdx.graphics.Texture;

public abstract class A_BadGuyDecorator extends A_Villain
{
	protected A_Villain villain;
	
	protected A_BadGuyDecorator(A_Villain v)
	{
		this.villain = v;
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
		return villain.getTexture();
	}
}
