package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import java.util.ArrayList;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    Sprite sp;
    ShapeRenderer shape;	
    Ball ball;
    Paddle paddle;
    ArrayList<Block> blocks = new ArrayList<>();
    int life = 0;
    Texture background;    
    int z = 0;	
@Override
	
public void create () {
    paddle = new Paddle(Gdx.graphics.getWidth() / 2, 0, 60, 10);
    paddle.setpos(Gdx.graphics.getWidth() / 2 - paddle.width / 2, 7);
    ball = new Ball(Gdx.graphics.getWidth() / 2, 28, 15, 5, 5, paddle);
    batch = new SpriteBatch();
    background = new Texture("bluespace.jpg");
    sp = new Sprite(background);
    
   
    shape = new ShapeRenderer();
    
		
    int blockWidth = 80;
		
    int blockHeight = 40;
		
    for(int y = Gdx.graphics.getHeight() / 2; y + blockHeight < Gdx.graphics.getHeight(); y += blockHeight + 5) {
			
    for(int x = 5; x + blockWidth < Gdx.graphics.getWidth(); x += blockWidth + 5) {
				
        blocks.add(new Block(x, y, blockWidth, blockHeight));
			
}
		
}
	
}

	
public void update() {
    
    if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
        z = 1;
        
    }
    if(z == 1){
        ball.update();
        paddle.update();      
    }
    
    if(ball.y + ball.radius + 2 < paddle.y){
        z = 0;
        life++;
        paddle.setpos(Gdx.graphics.getWidth() / 2 - paddle.width / 2, 7);
        ball.setpos(Gdx.graphics.getWidth() / 2, 28);
        ball.switchYAxis();
    }
    
    if(life == 3){
        System.exit(0);
    }
		
    for(int x=0; x<blocks.size(); x++) {
			
        if(blocks.get(x).checkBallColission(ball.circle)) {
				
            ball.switchYAxis();
				
        blocks.remove(x);    
			
        }
		
    }
    
}

	
@Override
	
public void render () {
		
    update();
		
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
    shape.begin(ShapeRenderer.ShapeType.Filled);
    
    batch.begin();
   
    sp.setBounds(0, 0, 1024, 512);           
    sp.draw(batch);
    batch.end();
    paddle.draw(shape);
    ball.draw(shape);
   		
    for (Block block: blocks) {
			
    block.draw(shape);
		
    }
		
    shape.end();
	
}

}


