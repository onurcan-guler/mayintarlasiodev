package MAYINTARLASI;
import java.awt.*;


public class Cell {




    public enum Type {

        MINE, EMPTY, FLAGGED, FLAGGED_MINE

    }





    public enum State {

        OPEN, CLOSED

    }



    protected int surroundingBombs = 0;



    protected int x, y;



    protected State state;



    protected Type type;


    protected static final Font FONT = new Font("serif", Font.PLAIN, 30);


    protected static final Color BACKGROUND = new Color(0xd0d0d0);



    protected static final Color OPENED = new Color(0xeeeeee);



    private static final Color[] CELL_COLOURS = {

            new Color(0xffffff),

            new Color(0x0000FE), // 1

            new Color(0x186900), // 2

            new Color(0xAE0107), // 3

            new Color(0x000177), // 4

            new Color(0x8D0107), // 5

            new Color(0x007A7C), // 6

            new Color(0x902E90), // 7

            new Color(0x000000), // 8

    };



    /* Construct a new cell */

    public Cell(int x, int y) {

        this.x = x;

        this.y = y;

        this.type = Type.EMPTY;

        this.state = State.CLOSED;

    }



    /* Set the cell type*/

    public void setType(Type type) {

        this.type = type;

    }



    public Type getType() {

        return type;

    }



    public void setState(State state) {

        this.state = state;

    }



    public State getState() {

        return state;

    }



    public void draw(Graphics2D g) {

        final int s = 30; // size of a cell

        g.setColor(BACKGROUND);

        g.fillRect(x * s, y * s, s, s);

        g.setFont(FONT);



        if (state == State.OPEN) {

            g.setColor(OPENED);

            g.fillRect(x * s, y * s, s, s);

            if (type == Type.MINE) {

                g.setColor(Color.BLACK);

                g.fillOval((x * s) + 8, ((y * s) + 9), s / 2, s / 2);

                g.setColor(Color.WHITE);

                g.fillOval((x * s) + 10, ((y * s) + 12), 5, 5);

            } else if (surroundingBombs > 0) {

                g.setColor(CELL_COLOURS[surroundingBombs]);

                g.drawString(String.valueOf(surroundingBombs), (x * s) + 8,

                        ((y * s) + s) - 4);

            }

        }

        if (type == Type.FLAGGED || type == Type.FLAGGED_MINE) {

            g.setColor(Color.RED);

            g.fillRect((x * s) + 8, ((y * s) + 6), 15, 5);

            g.setColor(Color.BLACK);

            g.fillRect((x * s) + 14, ((y * s) + 11), 3, 15);

        }



        g.setColor(Color.GRAY); // outline

        g.drawRect(x * s, y * s, s, s); // outline

    }

}

