package com.company;

public class Grid {

    private int width = 20;
    private int height = 12;
    private String[][] screenMatrix;

    public Grid() {
        this.screenMatrix = new String[this.height][this.width];
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setWidth(int width) {
        this.width = width;
        screenMatrix = new String[this.height][width];
    }

    public void setHeight(int height) {
        this.height = height;
        screenMatrix = new String[height][this.width];
    }

    public void initScreen() {
        for (int i = 0; i < this.height; ++i) {
            for (int j = 0; j < this.width; ++j) {
                this.screenMatrix[i][j] = " — ";
            }
        }
    }

    public void printScreen() {
        System.out.println();
        for (int i = 0; i < this.height; ++i) {
            for (int j = 0; j < this.width; ++j) {
                System.out.print(this.screenMatrix[i][j]);
            }
            System.out.println();
        }
    }

    public void clearScreenLocation(int x, int y) {
        this.screenMatrix[y][x] = " — ";
    }

    public void setObjectOnLocation(Object object, int x, int y) {
        this.screenMatrix[y][x] = object.getSymbol();
    }

    public void checkCell(Player player) {
        if (screenMatrix[player.getY()][player.getX()].equals("\uD83C\uDF4E ")) Food.addHealth(player);
        if (screenMatrix[player.getY()][player.getX()].equals("\uD83D\uDCA3 ")) Bomb.subHealth(player);
        if (screenMatrix[player.getY()][player.getX()].equals("\uD83D\uDE20 ")) Enemy.clashPlayer(player);
        if (screenMatrix[player.getY()][player.getX()].equals("\uD83D\uDC1F ")) GoldFish.upgradePlayer(player, this);
        if (screenMatrix[player.getY()][player.getX()].equals("\uD83C\uDF39 ")) Flower.addPoint(player);
    }

    @Override
    public String toString() {
        return "rows: " + this.width + "\ncolumns: " + this.height;
    }
}
