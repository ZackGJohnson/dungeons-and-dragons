import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

/*
 * This class can be safely ignored. It just creates a new LibGDX window/application.
 * See Game.java for the the game loop and initialization.
 */
public class DesktopGame
{
	public static void main (String[] args)
	{
        new LwjglApplication(new Game(), "Power Rangers", 800, 600);
    }
}
