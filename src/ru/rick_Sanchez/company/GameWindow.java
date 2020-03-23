package ru.rick_Sanchez.company;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class GameWindow extends JFrame {

    private static final int WIN_WIDTH = 507;
    private static final int WIN_HEIGHT = 555;
    private static final int WIN_POSX = 650;
    private static final int WIN_POSY = 250;
    private FieldPanel fieldPanel;
    private SettingsWindow settingsWindow;

    GameWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIN_WIDTH,WIN_HEIGHT);
        setLocation(WIN_POSX, WIN_POSY);
        setTitle("Tic tac toe");
        setResizable(false);

        JButton btnStart = new JButton("Start new game");
        JButton btnStop = new JButton("<html><body><b>Exit</b></body></html>");
        settingsWindow = new SettingsWindow(this);
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsWindow.setVisible(true);
            }
        });
        JPanel pButtons = new JPanel(new GridLayout(1,2));

        pButtons.add(btnStart);
        pButtons.add(btnStop);
        JPanel fieldPanel = new FieldPanel();

        add(pButtons, BorderLayout.SOUTH);
        add(fieldPanel);
        setVisible(true);
    }

    void startNewGame(int gameMode,int fieldSizeX, int fieldSizeY, int winLength){
        fieldPanel.startNewGame(gameMode, fieldSizeX, fieldSizeY, winLength);
    }
}
