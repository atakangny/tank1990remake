package com.atakanguney.tank.remake.entities;

public class Eagle {
    private float x, y; // Position of the eagle
    private int width = 2; // Width of the eagle in blocks
    private int height = 2; // Height of the eagle in blocks

    public Eagle(float x, float y) {
        this.x = x;
        this.y = y;
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
