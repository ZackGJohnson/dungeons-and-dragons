import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import gui.DungeonGame;

/*
 * This class can be safely ignored. It just creates a new LibGDX window/application.
 * See Game.java for the the game loop and initialization.
 */
public class DesktopGame
{
	public static void main (String[] args)
	{
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.fullscreen = false;
		config.width = 800;
		config.height = 600;
		config.title = "Power Ranger Dungeon";
        new LwjglApplication(new DungeonGame(), config);
    }
}
