package com.company;

public class Bound extends Object {

    public Bound() {
        setSymbol("#");
    }

    public Bound(String symbol) {
        setSymbol(symbol);
    }

    // Add horizontal line of walls
    public void addWallsRow(Grid grid, Bound bound, int rowNumber) {
        for (int i = 0; i < grid.getWidth(); i++) {
            grid.setObjectOnLocation(bound, i, rowNumber);
        }
    }

    // Add vertical line of walls
    public void addWallsColumn(Grid grid, Bound bound, int columnNumber) {
        for (int i = 0; i < grid.getHeight(); i++) {
            grid.setObjectOnLocation(bound, columnNumber, i);
        }
    }
}
