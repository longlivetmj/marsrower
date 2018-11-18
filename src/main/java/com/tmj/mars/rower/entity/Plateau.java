package com.tmj.mars.rower.entity;

public class Plateau {

    private int lowerX = 0;
    private int lowerY = 0;
    private int upperX;
    private int upperY;

    public Plateau(int upperX, int upperY) {
        this.upperX = upperX;
        this.upperY = upperY;
    }

    public int getLowerX() {
        return lowerX;
    }

    public void setLowerX(int lowerX) {
        this.lowerX = lowerX;
    }

    public boolean isValidMove(Position position) {
        return position.isInside(upperX, upperY) && position.isOutside(this.lowerX, this.lowerY);
    }

    public int getLowerY() {
        return lowerY;
    }

    public void setLowerY(int lowerY) {
        this.lowerY = lowerY;
    }

    public int getUpperX() {
        return upperX;
    }

    public void setUpperX(int upperX) {
        this.upperX = upperX;
    }

    public int getUpperY() {
        return upperY;
    }

    public void setUpperY(int upperY) {
        this.upperY = upperY;
    }
}
