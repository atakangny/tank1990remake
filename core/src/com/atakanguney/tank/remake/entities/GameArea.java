package com.atakanguney.tank.remake.entities;

public class GameArea {
    private int width; // Width of the game area in blocks
    private int height; // Height of the game area in blocks



    public GameArea(int width, int height) {
        this.width = width;
        this.height = height;
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
