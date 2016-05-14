package gui;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

/*
 * Whenever the user presses something on their keyboard or mouse the signal is
 * sent to an InputHandler. The InputHandler decides if it wants to process it
 * and returns true if it did, or false if it ignored it. InputHandlers are put
 * in an InputMultiplexer where the input signal gets sent to a series of InputHandlers
 * until it is finally processed. This is to prevent an input signal from doing the multiple
 * (wrong) things.
 * An example would be if the user pressed the inventory button but on screen there happened to be 
 * a room behind it. The user interface (inventory button) would consume the mouse click and prevent
 * the game from also processing the click as a command to move to the room.
 */
public class InputHandler implements InputProcessor
{
	private A_GameScreen _screen;
	private boolean _moveLeft, _moveRight, _moveUp, _moveDown;
	public static final int CAMERA_SCROLL_SPEED = 6;
	
	public InputHandler(A_GameScreen screen)
	{
		_screen = screen;
	}
	
	public boolean keyDown(int keycode)
	{
		if (keycode == Input.Keys.A)
        {
            _moveLeft = true;
            return true;
        }
        if (keycode == Input.Keys.D)
        {
            _moveRight = true;
            return true;
        }
        if (keycode == Input.Keys.W)
        {
            _moveUp = true;
            return true;
        }
        if (keycode == Input.Keys.S)
        {
            _moveDown = true;
            return true;
        }
        return false;
	}
	
	public boolean keyUp(int keycode)
    {
        if (keycode == Input.Keys.A)
        {
            _moveLeft = false;
            return true;
        }
        if (keycode == Input.Keys.D)
        {
            _moveRight = false;
            return true;
        }
        if (keycode == Input.Keys.W)
        {
            _moveUp = false;
            return true;
        }
        if (keycode == Input.Keys.S)
        {
            _moveDown = false;
            return true;
        }
        return false;
    }
	
	public boolean keyTyped(char character)
	{
		return false;
	}
	
	public boolean touchDown(int x, int y, int pointer, int button)
	{
		return false;
	}
	
	public boolean touchUp(int x, int y, int pointer, int button)
    {
        return false;
    }

    public boolean touchDragged(int x, int y, int pointer)
    {
        return false;
    }

    public boolean mouseMoved(int x, int y)
    {
        return false;
    }
    
    public boolean scrolled(int amount)
    {
    	_screen.getCamera().zoom += amount;
    	return true;
    }
    
    public void update()
    {
    	if (_moveUp)
    	{
    		_screen.getCamera().translate(0,CAMERA_SCROLL_SPEED,0);
    	}
    	if (_moveDown)
    	{
    		_screen.getCamera().translate(0,-CAMERA_SCROLL_SPEED,0);
    	}
    	if (_moveLeft)
    	{
    		_screen.getCamera().translate(-CAMERA_SCROLL_SPEED,0,0);
    	}
    	if (_moveRight)
    	{
    		_screen.getCamera().translate(CAMERA_SCROLL_SPEED,0,0);
    	}
    }
}
