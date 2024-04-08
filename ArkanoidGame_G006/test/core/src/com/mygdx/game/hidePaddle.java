package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Intersector;



public class hidePaddle extends PowerUps{

    public hidePaddle(int x, int y, int radius, int ySpeed, Paddle paddle) {
        super(x, y, radius, ySpeed, paddle);
        color = Color.BLUE;
    }

    @Override
    public void update() {
        y -= ySpeed;
        circle.setPosition(x, y);
        if(Intersector.overlaps(circle, paddle.rectangle)) {
            paddle.rectangle.setWidth(0);
        }    
    }
    
}
