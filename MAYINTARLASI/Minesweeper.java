package MAYINTARLASI;
import javax.swing.*;

import java.awt.event.WindowAdapter;

import java.awt.event.WindowEvent;

class Minesweeper {


    protected JFrame frame;


    public Minesweeper() {

        frame = new JFrame("Minesweeper");

        frame.setSize(400, 300);

        frame.setResizable(false);

        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {

                if (confirmLeave())

                    System.exit(1);

            }

        });

        setLookAndFeel();

        frame.setContentPane(new IntroInterface(this));

        frame.setVisible(true);

    }



    public void settings(int width, int height, int mines) {

        final int s = 30; // cell size

        frame.setSize(width * s + 8, height * s + 30);

        frame.setContentPane(new GridInterface(width, height, mines));

    }


    private void setLookAndFeel() {

        try {

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (Exception e) {

            e.printStackTrace();

        }

    }


    private boolean confirmLeave() {

        int option = JOptionPane.showConfirmDialog(Minesweeper.this.frame,

                "Are you sure you want to leave? You will lose any game " +

                        "progress.",

                "Minesweeper", JOptionPane.YES_NO_OPTION);

        return option == JOptionPane.YES_OPTION;

    }




    public static void main(String[] args) {

        new Minesweeper();

    }

}