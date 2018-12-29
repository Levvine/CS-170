package finalProject;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Main extends GraphicsProgram implements UnitList {

    static JTextArea textArea;
    static JTextArea textArea2;
    static Map map;
    Random random = new Random();
    PlayerUnit marth;
    EnemyUnit apple;
    EnemyUnit pear;
    EnemyUnit cherry;
    int turn;
    
    boolean dialogue1used;
    
    public static Map getMap() {
        return map;
    }
    
    public static JTextArea getTextArea() {
        return textArea;
    }
        
    public void init() {
               
        this.getGCanvas().requestFocus();
        Main.textArea = new JTextArea(4, 35);
        Main.textArea.setLineWrap(true);
        Main.textArea.setWrapStyleWord(true);
        this.add(textArea, SOUTH);
        
        Main.textArea2 = new JTextArea(1,20);
        Main.textArea.setLineWrap(true);
        Main.textArea.setWrapStyleWord(true);
        this.add(textArea2, NORTH);
        
        map = new Map(1);
        map.update();
        int northHeight = this.getRegionPanel(NORTH).getHeight();
        int southHeight = this.getRegionPanel(SOUTH).getHeight();
        this.setSize((int) Map.getGraphics().getWidth() - 10, (int) Map.getGraphics().getHeight() + 70);
        this.add(map);
        marth = new PlayerUnit("Marth", Unit.MERCENARY);
        apple = new EnemyUnit("Apple", Unit.KNIGHT);
        pear = new EnemyUnit("Pear", Unit.MERCENARY);
        cherry = new EnemyUnit("Cherry", Unit.FIGHTER);
        
        this.add(apple);
        this.add(pear);
        this.add(cherry);
        this.add(marth);
        marth.setTileLocation(3,1);
        apple.setTileLocation(5,9);
        pear.setTileLocation(8,8);
        cherry.setTileLocation(11,9);
        
        Main.textArea.setText(marth.getName() + ": Something doesn't seem quite right in this world.");
        
        final JDialog dialog = new JDialog(); //forces joptionpane to appear on top
        //dialog.setAlwaysOnTop(true);
        JOptionPane.showMessageDialog(dialog, "Move Marth by selecting him with the mouse, then clicking to his"
                + " destination.\nMarth can move two tiles and attack one tile beyond his destination.", "Fruit Emblem"
                + " Instructions",1);
        dialog.setVisible(false); //closes jdialog so scanner and printwriter can work
        
    }
    
    public void run() {
        turn++;
        textArea2.setText("Turn " + turn);
        this.getGCanvas().addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e) {
                int row = (int) (e.getY() / Map.getTileSize());
                int column = (int) (e.getX() / Map.getTileSize());
                //System.out.println("row: "+row+" column: "+column);
                
                if (Map.getOccupant(row, column) == marth) {              
                    marth.setSelected(!marth.getSelected());
                    if (marth.getSelected()) {
                        textArea.setText(marth.getName() + " Selected");
                    }
                    else {
                        textArea.setText(marth.getName() + " Deselected");
                    }
                    /*
                    for (int r = 0; r < marth.getActionTiles().length; r++) {
                        for (int c = 0; c < marth.getActionTiles()[r].length; c++) {
                            System.out.print(marth.getActionTiles()[r][c] + " ");
                        }
                        System.out.println();
                    }*/
                }
                else {
                    if (marth.getSelected()) {
                        //System.out.println("Enemies: " + Unit.getEnemies());
                        //System.out.println("Test Area: " +marth.getActionTiles()[row][column]);
                        if (Map.getPassable(row, column)) {
                            if (marth.getActionTiles()[row][column] == Actions.MOVEMENT && 
                                Map.getOccupant(row, column) == null) {
                                marth.setTileLocation(row, column);
                                marth.setSelected(true);
                                textArea.setText("Moved Marth from ("+marth.getTileRow()+","+marth.getTileColumn()+
                                        ") to ("+row+","+column+")");
                                turn++;
                                textArea2.setText("Turn " + turn);
                                
                            }
                            if (marth.getActionTiles()[row][column] == Actions.ATTACK ||
                                marth.getActionTiles()[row][column] == Actions.MOVEMENT){
                                if(Map.getOccupant(row, column) instanceof EnemyUnit) {
                                    int enemyRow = row; int enemyColumn = column;
                                    marth.attack(Map.getOccupant(row, column));
                                    
                                    if (Map.hasOccupant(row, column)){
                                        int newRow = 0; int newColumn = 0;
                                        do {
                                            newRow = random.nextInt(Map.getData().length - 1);
                                            newColumn = random.nextInt(Map.getData()[0].length - 1);
                                            
                                        } while (Map.hasOccupant(newRow, newColumn) == true || Map.getPassable(newRow, 
                                                newColumn) == false);
                                    
                                        Map.getOccupant(row,column).setTileLocation(newRow, newColumn);
                                        if (!dialogue1used) {
                                            Main.textArea.setText(marth.getName() + ": So these enemies also " +
                                        "teleport? How bothersome...");
                                            dialogue1used = true;
                                        }
                                        else {
                                            Main.textArea.setText(((EnemyUnit) Map.getOccupant(newRow, newColumn)).getName()
                                                    + " HP: " + Map.getOccupant(newRow, newColumn).getTotalHitpoints() +
                                                    "\n" + marth.getName() + " HP: " + 
                                                    marth.getTotalHitpoints());
                                        }
                                        
                                        turn++;
                                        textArea2.setText("Turn " + turn);
                                    }
                                    else { // enemy dies
                                        if (Unit.getEnemies() == 0) {
                                            textArea.setText("Player wins!");
                                        }
                                        else {
                                            textArea.setText(textArea.getText() + "\nEnemies Remaining: " + Unit.getEnemies());
                                        }
                                    }
                                    marth.setTileLocation(enemyRow, enemyColumn);
                                }
                                marth.setSelected(true);
                            }
                        }
                    }
                        //System.out.println("Marth Deselected");
                    }
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent arg0) {}
            public void mouseEntered(MouseEvent arg0) {}
            public void mouseExited(MouseEvent arg0) {}});
    }
}
