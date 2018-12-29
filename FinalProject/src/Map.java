package finalProject;

import java.util.ArrayList;

import acm.graphics.GCompound;
import acm.graphics.GImage;

public class Map extends GCompound implements Actions {

    private static GImage graphics;
    private static GImage dataGrid;
    private static GImage grid;
    private static GImage transparentMap;
    private static MapOverlay overlay;
    private static Tile[][] data;
    private static double tileSize;
    private static int selection;
    

    public Map(int selection) {
        this.selection = selection;
    }
        
    public static void genActionTiles(Unit a) {
        
        int[][] outTile = new int[data.length][data[0].length];
        for (int tileR = a.getTileRow() - a.getActionRange(); tileR <= a.getTileRow() + a.getActionRange();
             tileR++) {
            for (int tileC = a.getTileColumn() - a.getActionRange(); tileC <= a.getTileColumn() +
                 a.getActionRange(); tileC++) {
                if ((tileR >= 0) && (tileC >= 0) && (tileR < data.length) && (tileC < data[0].length)) {
                    if (tileR == a.getTileRow() && tileC == a.getTileColumn()){
                        outTile[tileR][tileC] = SELF;
                    }
                    else if (a.getClassMovement() >= Math.abs(a.getTileRow() - tileR) +
                             Math.abs(a.getTileColumn() - tileC)) {
                        outTile[tileR][tileC] = MOVEMENT;
                        
                    }      
                    else if (a.getClassMovement() + a.getWeaponRange() >= Math.abs(a.getTileRow() - tileR) +
                             Math.abs(a.getTileColumn() - tileC)) {
                        outTile[tileR][tileC] = ATTACK;
                    }
                    else if (tileR >= a.getTileRow() - a.getClassMovement() - a.getHealRange() && 
                            tileR <= a.getTileRow() + a.getClassMovement() + a.getHealRange() &&
                            tileC >= a.getTileColumn() - a.getClassMovement() - a.getHealRange() &&
                            tileC <= a.getTileColumn() + a.getClassMovement() + a.getHealRange() &&
                            a.getHealRange() > 0) {
                            outTile[tileR][tileC] = HEAL;
                    }
                }
            }          
        }
        a.setActionTiles(outTile);
        //overlay.modRangeIndicator(a);
        
        /*debug
        for (int r = 0; r < outTile.length; r++) {
            for (int c = 0; c < outTile[r].length; c++) {
                System.out.print(outTile[r][c] + " "); 
            }
            System.out.println();
        }
        */
        
    }

    public static GImage getGraphics() {
        return graphics;
    }
    
    public static GImage getGrid() {
        return grid;
    }
    
    public static Tile[][] getData() {
        return data;
    }
    
    public static GImage getTransparentMap() {
        return transparentMap;
    }
    
    public static double getTileSize() {
        return tileSize;
    }
    
    public static boolean hasOccupant(int row, int column) {
        return data[row][column].hasOccupant();
    }
    
    public static Unit getOccupant(int row, int column) {
        return data[row][column].getOccupant();
    }
    
    public static boolean getPassable(int row, int column) {
        return data[row][column].getPassable();
    }

    public void genData() {

        int red;

        int[][] pixelArray = dataGrid.getPixelArray();
        switch (selection) {
        case 1:
            for (int r = 0; r < data.length; r++) {
                for (int c = 0; c < data[r].length; c++) {
                    red = GImage.getRed(pixelArray[r * (int) tileSize + 1][c * (int) tileSize + 1]);
                    if (red == 255)  
                        data[r][c] = new Tile(false);
                    else
                        data[r][c] = new Tile(true);
                }
            }
        }
        
        /*debug
        for(int r = 0; r < data.length; r++) {
            for(int c = 0; c < data[r].length; c++) {
                System.out.print(data[r][c].getPassable());
            }
            System.out.println();
        }
        */
        
    }

    public void update() {
        switch (selection) {
        case 1:
            data = new Tile[13][10];
            tileSize = 53;
            graphics = new GImage("bin/Map01.png");
            dataGrid = new GImage("bin/MapDataGrid01.png");
            grid = new GImage("bin/MapGrid01.png");
            transparentMap = new GImage("bin/Map01Transparent.png");
            overlay = new MapOverlay();
            break;

        }
        this.add(graphics);
        this.add(grid);
        this.add(overlay);
        this.genData();
    }

}
