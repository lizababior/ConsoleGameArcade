package com.company;

public class Object {
    private int x, y;
    private String symbol;

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public String getSymbol() {
        return symbol;
    }

    public void setX(int newLocation) {
        this.x = newLocation;
    }
    public void setY(int newLocation) {
        this.y = newLocation;
    }
    public void setSymbol(String newSymbol) {
        this.symbol = newSymbol;
    }
}
