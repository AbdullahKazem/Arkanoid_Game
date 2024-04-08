package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;


abstract class PowerUps {
    int x;
    int y;
    int radius;
    int ySpeed;
    public Color color;
    Circle circle;
    Paddle paddle;
    
    public PowerUps(int x, int y, int radius, int ySpeed, Paddle paddle) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.ySpeed = ySpeed;
        circle = new Circle(x, y, radius);
        this.paddle = paddle;
    }
    
    public void setpos(int x,int y){
        this.x = x;
        this.y = y;
    }
    
    public abstract void update();
    
    public void draw(ShapeRenderer shape) {
        shape.setColor(color);
        shape.circle(x, y, radius);
    }
      
}


