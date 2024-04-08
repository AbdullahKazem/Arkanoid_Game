package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Intersector;
import java.util.ArrayList;



public class incNumBall extends PowerUps {
    ArrayList<Ball> balls = new ArrayList<>();
    int xSpeed;
    public incNumBall(int x, int y, int radius, int ySpeed, Paddle paddle) {
        super(x, y, radius, ySpeed, paddle);
        color = Color.YELLOW;
    }

    @Override
    public void update() {
        y -= ySpeed;
        circle.setPosition(x, y);
        if(Intersector.overlaps(circle, paddle.rectangle)) {
            for(int i = 0; i < 3; i++){
                balls.add(new Ball(x, y, radius, xSpeed, ySpeed, paddle));
            }
        } 
    }
    
}
