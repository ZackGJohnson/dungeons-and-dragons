package entities.bosses;
import entities.*;
import com.badlogic.gdx.graphics.Texture;

public class Rita extends A_BadGuyDecorator
{
	public static Texture _ritaTexture;

	public Rita(A_Villain v) 
	{
		super(v);
		_name = "Rita";
		v._texture = _ritaTexture;
		_texture = _ritaTexture;
	}
	
	public int getHealth() 
	{		
		return 3 + villain.getHealth();
	}
	public int getMaxHealth()
	{
		return 3 + villain.getMaxHealth();
	}
	
	public int getAtkMod() 
	{		
		return villain.getAtkMod();
	}
	
	public int getDmgMod() 
	{		
		return 1 + villain.getDmgMod();
	}
	
	public String getDmgDice() 
	{		
		return villain.getDmgDice();
	}
	
	public int getDmgReduction() 
	{		
		return villain.getDmgReduction();
	}
	
	public int getArmorClass() 
	{		
		return 2 + villain.getArmorClass();
	}

}

