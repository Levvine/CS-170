package finalProject;

import acm.graphics.GImage;

public class RangeIndicator implements Actions {

    public static final int TRANSPARENT = -16777216;
    public static final int RED = 1694439962;
    public static final int BLUE = 1681077247;
    
    GImage indicator;

    public RangeIndicator(Unit a) {
        indicator = new GImage("map01Transparent.png"); //Map.getGraphics();
        
    }
    
    public void pixelArrayFiller(int[][] actionTiles, int[][] pArray, int tileR, int tileC) {
        if (actionTiles[tileR][tileC] == MOVEMENT) {
            System.out.print(actionTiles[tileR][tileC]);
            /*
            for (int r = (int) (tileR * Map.getTileSize()); r < tileR * Map.getTileSize() + Map.getTileSize();
                 tileR++) {
                for (int c = ((int) (tileC * Map.getTileSize())); c < tileC * Map.getTileSize() +
                     Map.getTileSize(); tileC++) {
                    pArray[r][c] = BLUE;
                }
            }
            */
        }
    }
    
    public void update(int[][] actionTiles) {
        int[][] pixelArray = indicator.getPixelArray();
        System.out.println("Alpha: " + GImage.getAlpha(pixelArray[0][0]));
        System.out.println("ActionTiles Length: " + actionTiles.length + " ActionTiles Width: " + actionTiles[0].length);
        for (int r = 0; r < actionTiles.length; r++) {
            for (int c = 0; c < actionTiles[r].length; c++) {
                pixelArrayFiller(actionTiles, pixelArray, r, c);
            }
        }
        
    }
    
    public GImage getIndicator() {
        return indicator;
    }

}

