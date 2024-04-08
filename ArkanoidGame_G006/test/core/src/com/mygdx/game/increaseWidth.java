package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Intersector;


public class increaseWidth extends PowerUps {
    int z = 0;
    public increaseWidth(int x, int y, int radius, int ySpeed, Paddle paddle) {
        super(x, y, radius, ySpeed, paddle);
        color = Color.RED;
    }

    @Override
    public void update() {
        y -= ySpeed;

        circle.setPosition(x, y);

        if(circle.y < paddle.y) {
            circle.setPosition(50, 50);
        }
    }
    
    public void setPos(int x,int y){
        this.x = x;
        this.y = y;
    }
    public void checkCollision(Paddle paddle) {
        if(collidesWith(paddle)) {
            color = Color.GREEN;
        } else {
            color = Color.WHITE;
        }
    }

    private boolean collidesWith(Paddle paddle) {
        return Math.random()>.5;
    } 
}
