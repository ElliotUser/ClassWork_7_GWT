package ru.rick_Sanchez.company;

import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 270;
    private static final int MIN_WIN_LENGTH = 3;
    private static final int MAX_FIELD_SIZE = 3;
    private static final int MIN_FIELD_SIZE = 10;
    private static final String  FIELD_SIZE_PREFIX = "Field size is:";
    private static final String  WIN_LENGTH_PREFIX = "Win length is:";

    private GameWindow gameWindow;
    private JRadioButton humVSAI;
    private JRadioButton humVShum;
    private JSlider sliderWinLen;
    private JSlider sliderFieldSize;

    SettingsWindow(GameWindow gameWindow){
        this.gameWindow = gameWindow;
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        Rectangle gameWindowBounds = gameWindow.getBounds();
        int posX = (int) gameWindowBounds.getCenterX() - WINDOW_WIDTH / 2;
        int posY = (int) gameWindowBounds.getCenterY() - WINDOW_HEIGHT /2;
        setLocation(posX,posY);
        setResizable(false);
        setTitle("Creating new game");
        setLayout(new GridLayout(10,1));
        addGameControlsMode();
        addGameControlsField();
    }

    private void addGameControlsMode(){
        add(new JLabel("Choose game mode"));
        humVSAI = new JRadioButton("Human vs. AI", true);
        humVShum = new JRadioButton("Human vs. Human");
        ButtonGroup gameMode = new ButtonGroup();
        gameMode.add(humVSAI);
        gameMode.add(humVShum);

        add(humVSAI);
        add(humVShum);
    }

    private void addGameControlsField(){
        JLabel lbFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);
        JLabel lbWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);
        sliderFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE,MAX_FIELD_SIZE);
        sliderWinLen = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MAX_FIELD_SIZE);

        sliderWinLen.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = sliderFieldSize.getValue();
                lbFieldSize.setText(FIELD_SIZE_PREFIX + currentValue);
                sliderFieldSize.setMaximum(currentValue);
            }
        });
        sliderWinLen.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lbFieldSize.setText(WIN_LENGTH_PREFIX + sliderFieldSize.getValue());
            }
        });
        add(new JLabel("Choose field size"));
        add(lbFieldSize);
        add(sliderFieldSize);
        add(new JLabel("Choose win "));
        add(lbWinLength);
        add(sliderWinLen);
    }

    private void buttonStartClick(){
        int gameMode;
        if(humVSAI.isSelected()){
            gameMode = FieldPanel.MODE_HVA;
        }else if(humVShum.isSelected()){
            gameMode = FieldPanel.MODE_HVH;
        }else {
            throw new RuntimeException("Unexpected game mode!");
        }
        int fieldSize;
        int win
        gameWindow.startNewGame(gameMode, fieldSize, fieldSize, );
        setVisible(false);
    }
}
