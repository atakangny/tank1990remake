package com.atakanguney.tank.remake;

import com.atakanguney.tank.remake.entities.Eagle;
import com.atakanguney.tank.remake.entities.GameArea;
import com.atakanguney.tank.remake.entities.Tank;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Tank1990 extends ApplicationAdapter {

    private Tank tank;
    private GameArea gameArea;
    private Eagle eagle;

    private int blockSize = 20;


    SpriteBatch batch;
    Texture img;
    Texture tankTexture;
    Texture waveTexture;
    Texture grassTexture;
    Texture blackTexture;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        tankTexture = new Texture("tank.png");
        waveTexture = new Texture("wave.png");
        grassTexture  = new Texture("grass.png");
        blackTexture  = new Texture("black.png");

        tank = new Tank(10, 10); // Initial position of the tank
        gameArea = new GameArea(40, 40);
        eagle = new Eagle(18, 18); // Initial position of the eagle
    }

	/*
	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	 */


    @Override
    public void render() {
        // Clear the screen
        ScreenUtils.clear(0, 0, 0, 1);

        // Handle input and move the tank
        handleInput();
        // Update game logic
        update();
        // Render game elements
        renderGame();
    }


    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }


    private void handleInput() {
        float speed = 50.0f; // Adjust the speed of tank movement

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            tank.move(-speed, 0);
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            tank.move(speed, 0);
        } else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            tank.move(0, speed);
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            tank.move(0, -speed);
        }
    }

    private void update() {
        // Ensure the tank stays within the game boundaries
        float tankX = tank.getX();
        float tankY = tank.getY();

        // Define the boundaries of the game area
        float minX = 0;
        float minY = 0;
        float maxX = (gameArea.getWidth() - tank.getWidth()) * blockSize; // Considering a 40x40 grid and tank width of 2 blocks
        float maxY = (gameArea.getHeight() - tank.getHeight()) * blockSize; // Considering a 40x40 grid and tank height of 2 blocks

        // Check for collision with game boundaries
        if (tankX < minX) {
            tank.setX(minX);
        } else if (tankX > maxX) {
            tank.setX(maxX);
        }

        if (tankY < minY) {
            tank.setY(minY);
        } else if (tankY > maxY) {
            tank.setY(maxY);
        }
    }

    private void renderGame() {
        // Clear the screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Begin rendering
        batch.begin();

        // Render the game area (example: drawing a grid)
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                batch.draw(blackTexture, i * blockSize, j * blockSize, blockSize, blockSize);
            }
        }



        // Render the tank at its current position
        batch.draw(tankTexture, tank.getX(), tank.getY(), tank.getWidth() * blockSize, tank.getHeight() * blockSize);


        for (int i = 0; i < gameArea.getWidth(); i++) {
            for (int j = 0; j < gameArea.getHeight(); j++) {

                if(i+j>50) {
                    batch.draw(waveTexture, i * blockSize, j * blockSize, blockSize, blockSize);
                } else if(i+j<20){
                    batch.draw(grassTexture, i * blockSize, j * blockSize, blockSize, blockSize);
                }
            }
        }

        // Render the eagle at its current position
        batch.draw(img,
                eagle.getX() * blockSize,
                eagle.getY() * blockSize,
                eagle.getWidth() * blockSize,
                eagle.getHeight() * blockSize);

        // End rendering
        batch.end();
    }
}
