package com.atakanguney.tank.remake.entities;

public class Tank {
    private float x;
    private float y; // Position of the tank
    private int width = 2; // Width of the tank in blocks
    private int height = 2; // Height of the tank in blocks

    public Tank(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void move(float deltaX, float deltaY) {
        x += deltaX;
        y += deltaY;
    }





    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
