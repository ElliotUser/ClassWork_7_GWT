package ru.rick_Sanchez.company;

import java.awt.Color;

import javax.swing.JPanel;

public class FieldPanel extends JPanel {
    public  static final int MODE_HVH = 0;
    public  static final int MODE_HVA = 0;

    FieldPanel(){
        setBackground(Color.cyan);
    }

    void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLength){
        System.out.printf("dawn mode: %d\nfield size: %d,\nwin lwngth: %d\n",
                gameMode, fieldSizeX, winLength);
    }
}
