package MAYINTARLASI;

import javax.swing.*;

import javax.swing.border.EtchedBorder;

import javax.swing.border.TitledBorder;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;



public class IntroInterface extends JPanel {


    protected Minesweeper game;


    private JSpinner boardWidth, boardHeight;



    private JSpinner numMines;



    public IntroInterface(final Minesweeper game) {

        this.game = game;



        setLayout(null);

        JPanel panel = new JPanel();

        panel.setLayout(null);

        panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),

                "Game settings", TitledBorder.LEADING, TitledBorder.TOP, null, null));

        panel.setBounds(63, 100, 253, 150);

        add(panel);



        JLabel title = new JLabel("Minesweeper in Java");

        title.setFont(new Font("sans-serif", Font.BOLD, 30));

        title.setBounds(40, 34, 377, 44);

        add(title);



        JLabel widthLabel = new JLabel("Board width in tiles:");

        widthLabel.setBounds(30, 31, 119, 14);

        panel.add(widthLabel);



        boardWidth = new JSpinner();

        boardWidth.setModel(new SpinnerNumberModel(9, null, null, 1));

        boardWidth.setBounds(159, 29, 71, 18);

        panel.add(boardWidth);



        JLabel heightLabel = new JLabel("Board height in tiles:");

        heightLabel.setBounds(30, 58, 119, 14);

        panel.add(heightLabel);



        boardHeight = new JSpinner();

        boardHeight.setModel(new SpinnerNumberModel(9, null, null, 1));

        boardHeight.setBounds(159, 56, 71, 18);

        panel.add(boardHeight);



        numMines = new JSpinner();

        numMines.setModel(new SpinnerNumberModel(10, null, null, 1));

        numMines.setBounds(159, 83, 71, 18);

        panel.add(numMines);



        JLabel minesLabel = new JLabel("Number of mines:");

        minesLabel.setBounds(30, 85, 123, 14);

        panel.add(minesLabel);



        JButton button = new JButton("Start");

        button.setBounds(82, 116, 91, 23);

        panel.add(button);

        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                int height = Math.max((Integer) boardHeight.getValue(), 9);

                int width = Math.max((Integer) boardWidth.getValue(), 9);

                int mines = Math.max((Integer) numMines.getValue(), 10);

                game.settings(width, height, mines);

            }

        });

    }

}