package MAYINTARLASI;


import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;


public class GridInterface extends JPanel {


    protected Grid grid;



    public GridInterface(int width, int height, int mines) {

        grid = new Grid(width, height, mines);

        addMouseListener(new MouseInput(grid));



        new Timer(5, new ActionListener() {



            public void actionPerformed(ActionEvent e) {

                repaint();

            }

        }).start();

    }



    protected void paintComponent(Graphics g) {

        final Graphics2D g2 = (Graphics2D) g;


        g2.setRenderingHint(

                RenderingHints.KEY_ANTIALIASING,

                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setRenderingHint(

                RenderingHints.KEY_TEXT_ANTIALIASING,

                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);


        grid.draw(g2);

    }

}
