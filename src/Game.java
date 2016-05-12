import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game implements ApplicationListener
{
	private SpriteBatch batch;
	
	/*
	 * Run when the game is first started.
	 */
	public void create ()
	{
		
    }

	/*
	 * Loop run constantly as the game runs.
	 */
    public void render ()
    {
    	// Clears the screen and then draws to screen.
    	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    	batch.begin();
    	
    	batch.end();
    }

    /*
     * Run when the game window is resized.
     */
    public void resize (int width, int height)
    {
    	
    }

    public void pause ()
    {
    	
    }

    public void resume ()
    {
    	
    }

    /*
     * Run when the game is closed
     */
    public void dispose ()
    {
    	
    }
}
