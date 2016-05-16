package gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

import map.Map;

/*
 * The game is separated into different "screens". An example would be the screen for character select
 * or the screen for playing the game. Each screen has many similarities such as needing to render
 * and process input, however the logic and variables needed for that section of the game may differ.
 */
public abstract class A_GameScreen implements Screen
{
	protected InputHandler _inputHandler;
	protected InputMultiplexer _multiplexer;
	protected OrthographicCamera _camera;
	protected DungeonGame _game;
	
	public A_GameScreen(DungeonGame game)
	{
		_game = game;
		_camera = new OrthographicCamera(30, 30 * (800 / 600));
		_camera.position.set(0,0,0);
		_camera.zoom = 30;
		_camera.update();
		
		_inputHandler = new InputHandler(this);
		_multiplexer = new InputMultiplexer();
		Gdx.input.setInputProcessor(_multiplexer);
		_multiplexer.addProcessor(_inputHandler);
	}

	public void render(float delta)
	{
		_camera.update();
    	_game.getBatch().setProjectionMatrix(_camera.combined);
    	_inputHandler.update();
    	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}

	public void resize(int width, int height)
	{
		_camera.viewportWidth = 30f;
        _camera.viewportHeight = 30f * height / width;
        _camera.update();
	}
	
	public void dispose()
	{

	}

	public void hide()
	{
		
	}

	public void pause()
	{
		
	}

	public void resume()
	{
		
	}

	public void show()
	{
		
	}
	
	public OrthographicCamera getCamera()
    {
    	return _camera;
    }
	
	public void click(int mouseX, int mouseY)
	{
		
	}
}
