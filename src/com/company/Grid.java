package com.company;

public class Grid {

    private int width, height;
    private String[][] screenMatrix;

    public Grid (int width, int height) {
        this.width = width;
        this.height = height;
        this.screenMatrix = new String[this.height][this.width];
    }

    public int getWidth() {
        return this.width;
    }
    public int getHeight() {
        return this.height;
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

}
